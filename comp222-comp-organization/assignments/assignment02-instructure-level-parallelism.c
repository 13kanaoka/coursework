#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_LEN 64
#define NO_REG  -1

typedef struct {
    char text[MAX_LEN];
    int  dest;
    int  src1, src2;
    int  delay;
} Instruction;

Instruction *instr = NULL;
int total = 0;

static int depends(const Instruction *producer, const Instruction *consumer)
{
    return producer->dest != NO_REG &&
           (producer->dest == consumer->src1 || producer->dest == consumer->src2);
}

/*************************************************************/
void enterInstructions(void)
{
    int n, i;
    char buf[MAX_LEN];

    printf("Enter total number of instructions: ");
    if (scanf("%d", &n) != 1 || n <= 0)
        return;

    free(instr);
    instr = calloc(3 * (size_t)n + 1, sizeof(Instruction));
    if (instr == NULL) {
        total = 0;
        return;
    }

    instr[0].dest = instr[0].src1 = instr[0].src2 = NO_REG;
    strcpy(instr[0].text, "");

    for (i = 1; i <= n; i++) {
        if (scanf("%63s", buf) != 1) {
            total = i - 1;
            return;
        }
        strcpy(instr[i].text, buf);
        if (sscanf(buf, "%*[^_]_$s%d,$s%d,$s%d",
                   &instr[i].dest, &instr[i].src1, &instr[i].src2) != 3) {
            printf("Invalid instruction, re-enter (format: add_$s2,$s1,$s0): ");
            i--;
            continue;
        }
        instr[i].delay = 0;
    }
    total = n;
}

/*****************************************************/
void calculateCycles(void)
{
    int i, j, k, delay, cycles;

    if (instr == NULL || total == 0) {
        printf("No instructions entered yet.\n");
        return;
    }

    for (i = 2; i <= total; i++) {
        delay = 0;

        if (depends(&instr[i - 1], &instr[i]))
            delay = 2;
        else if (depends(&instr[i - 2], &instr[i]))
            delay = 1;

        if (delay > 0) {
            for (j = total; j >= i; j--)
                instr[j + delay] = instr[j];

            for (k = 0; k < delay; k++) {
                strcpy(instr[i + k].text, "NOP");
                instr[i + k].dest = instr[i + k].src1 = instr[i + k].src2 = NO_REG;
                instr[i + k].delay = 0;
            }
            instr[i + delay].delay = delay;

            total += delay;
            i += delay;
        }
    }

    cycles = total + 4;
    printf("Total Cycles: %d\n", cycles);

    for (i = 1; i <= total; i++) {
        printf("%-15s :", instr[i].text);
        for (j = 0; j < i; j++)
            printf("\t");
        printf("IF\tID\tEX\tME\tWB\n");
    }
}

/****************************************************************/
int main(void)
{
    int choice = 0;

    do {
        printf("\nInstruction-level parallelism\n");
        printf("-----------------------------\n");
        printf("1) Enter instructions\n");
        printf("2) Calculate total cycle count on a 5-stage pipeline processor\n");
        printf("3) Quit Program\n\n");
        printf("Enter selection: ");

        if (scanf("%d", &choice) != 1)
            break;

        switch (choice) {
            case 1: enterInstructions(); break;
            case 2: calculateCycles();   break;
            case 3:                      break;
            default: printf("Invalid selection.\n");
        }
    } while (choice != 3);

    free(instr);
    return 0;
}