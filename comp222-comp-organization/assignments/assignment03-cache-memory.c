#include <stdio.h>
#include <stdlib.h>

/* ---------- global variables ---------- */

/* one cache line: a tag and a pointer to its block of words */
typedef struct {
    int  tag;     /* -1 means "nothing stored here yet" */
    int *block;   /* NULL until the line is first used  */
} CacheLine;

CacheLine *cache      = NULL;  /* dynamic array of cache lines    */
int       *mainMemory = NULL;  /* dynamic array for main memory   */

int mainMemSize = 0;           /* main memory size (words)        */
int cacheSize   = 0;           /* cache size (words)              */
int blockSize   = 0;           /* words per block                 */
int numLines    = 0;           /* cacheSize / blockSize           */


/****************************************************************/
/* option 1: read the parameters, allocate main memory and cache */
void enterParameters()
{
    int i;

    /* if parameters were entered before, release the old memory first */
    if (cache != NULL) {
        for (i = 0; i < numLines; i++)
            free(cache[i].block);      /* free(NULL) is safe */
        free(cache);
        cache = NULL;
    }
    free(mainMemory);
    mainMemory = NULL;

    printf("Enter main memory size (words): ");
    scanf("%d", &mainMemSize);
    printf("Enter cache size (words): ");
    scanf("%d", &cacheSize);
    printf("Enter block size (words/block): ");
    scanf("%d", &blockSize);

    /* main memory: word i holds (size of main memory - i) */
    mainMemory = (int *) malloc(mainMemSize * sizeof(int));
    for (i = 0; i < mainMemSize; i++)
        mainMemory[i] = mainMemSize - i;

    /* cache: one line per block that fits in the cache */
    numLines = cacheSize / blockSize;
    cache = (CacheLine *) malloc(numLines * sizeof(CacheLine));
    for (i = 0; i < numLines; i++) {
        cache[i].tag   = -1;
        cache[i].block = NULL;
    }

    return;
}


/****************************************************************/
/* option 2: read or write one word through the cache            */
void accessCache()
{
    int rw, addr, value = 0;
    int word, memBlock, line, tag;
    int i, start;

    if (mainMemory == NULL || cache == NULL) {
        printf("Enter parameters first!\n");
        return;
    }

    printf("Select read (0) or write (1): ");
    scanf("%d", &rw);

    if (rw == 0)
        printf("Enter main memory address to read from: ");
    else
        printf("Enter main memory address to write to: ");
    scanf("%d", &addr);

    if (rw == 1) {
        printf("Enter value to write: ");
        scanf("%d", &value);
    }

    /* translate main memory address to cache fields */
    word     = addr % blockSize;      /* which word inside the block       */
    memBlock = addr / blockSize;      /* which block of main memory        */
    line     = memBlock % numLines;   /* which cache line (block) it maps to */
    tag      = memBlock / numLines;   /* distinguishes blocks sharing a line */

    /* Case 1: MISS--BLOCK NOT ALLOCATED */
    if (cache[line].block == NULL)
        cache[line].block = (int *) malloc(blockSize * sizeof(int));

    if (cache[line].tag != tag) {
        /* Case 2: MISS--NON-MATCHING TAGS */
        printf(rw == 0 ? "Read miss!\n" : "Write miss!\n");
        cache[line].tag = tag;

        /* transfer the equivalent main memory block */
        start = memBlock * blockSize;
        for (i = 0; i < blockSize; i++)
            cache[line].block[i] = mainMemory[start + i];
    }
    else {
        /* Case 3:HIT DUE TO MATCHING TAGS */
        printf(rw == 0 ? "Read hit!\n" : "Write hit!\n");
    }

    /* reference the cache word -> write the value, or just read it */
    if (rw == 1)
        cache[line].block[word] = value;

    printf("---------------------------------------------------------------------------------\n");
    printf("| Tag: %-5d| Block: %-3d| Word: %-4d| Contents: %-6d|\n",
           cache[line].tag, line, word, cache[line].block[word]);
    printf("---------------------------------------------------------------------------------\n");

    return;
}


/****************************************************************/
int main()
{
    int choice = 0, i;

    do {
        printf("\nCache memory allocation and mapping:\n");
        printf("-----------------------------------------------------\n");
        printf("1) Enter parameters\n");
        printf("2) Access cache for reading/writing and transfer data\n");
        printf("3) Quit\n");
        printf("\nEnter selection: ");

        if (scanf("%d", &choice) != 1)
            break;                      /* EOF or non-numeric input */

        switch (choice) {
            case 1: enterParameters(); break;
            case 2: accessCache();     break;
            case 3:                    break;
            default:                   break;
        }
    } while (choice != 3);

    /* clean up */
    if (cache != NULL) {
        for (i = 0; i < numLines; i++)
            free(cache[i].block);
        free(cache);
    }
    free(mainMemory);

    return 0;
}