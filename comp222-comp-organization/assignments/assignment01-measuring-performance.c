#include <stdio.h>
/* declare global var's, including total cycles,
total instruction count, and clock cycle rate */
double totalCycles = 0.0;
double totalInstructionCount = 0.0;
double clockCycleRate = 0.0;

/*********************************************************/
void enterParameters()
{
    /* declare local var's and initialize*/
    int numClasses;
    int i;
    double cpi;
    double count;
    
    /* reset whenever new parameters are entered */
    totalCycles = 0.0;
    totalInstructionCount = 0.0;
    
    /* prompt for # instruction classes & clock cycle rate of machine */
    printf("Enter the number of instruction classes: ");
    scanf("%d", &numClasses);
    
    printf("Enter the frequency of the machine (GHz): ");
    scanf("%lf", &clockCycleRate);
    
    /* for each instruction class, prompt for CPI of class and instruction count */
    for (i = 1; i <= numClasses; i++)
    {
        printf("Enter CPI of class %d: ", i);
        scanf("%lf", &cpi);
        
        printf("Enter instruction count of class %d (billions): ", i);
        scanf("%lf", &count);
        
        /* update values in appropriate glocal var's */
        totalCycles += cpi * count;
        totalInstructionCount += count;
    }
    
    return;
}


/*********************************************************/
void calculateExecutionTime()
{
    /* declare local var's */
    double executionTime;
    
    /* Calculate execution time and print result */
    executionTime = totalCycles / clockCycleRate;
    printf("The execution time of the sequence is: %.2f sec\n", executionTime);
    
    return;
}


/*********************************************************/
void calculateMIPS()
{
    /* declare local var's */
    double executionTime;
    double mips;
    
    /* Calculate MIPS and print result */
    executionTime = totalCycles / clockCycleRate;
    mips = (totalInstructionCount * 1000.0) / executionTime;
    printf("The MIPS of the sequence is: %.2f\n", mips);
    
    return;
}


/*********************************************************/
void calculateAverageCPI()
{
    /* declare local var's */
    double avgCPI;
    
    /* Calculate average CPI and print result */
    avgCPI = totalCycles / totalInstructionCount;
    printf("The average CPI of the sequence is: %.2f\n", avgCPI);
    
    return;
}


/*********************************************************/
int main()
{
    /* declare local var's */
    int userSelection;
    
    /* until user chooses to quit, print menu,
    select choice via switch statement and call appropriate function*/
    do
    {
        printf("\nMeasuring Performance:\n");
        printf("-------------------------------\n");
        printf("1) Enter parameters\n");
        printf("2) Calculate Execution time of a sequence\n");
        printf("3) Calculate MIPS of a sequence\n");
        printf("4) Calculate average CPI of a sequence\n");
        printf("5) Exit program\n\n");
        printf("Enter selection: ");
        scanf("%d", &userSelection);
        
        switch (userSelection)
        {
            case 1:
                enterParameters();
                break;
            case 2:
                calculateExecutionTime();
                break;
            case 3:
                calculateMIPS();
                break;
            case 4:
                calculateAverageCPI();
                break;
            case 5:
                break;
            default:
                printf("Invalid selection. Please try again.\n");
        }
        
    } while (userSelection != 5);
    
    return 1;
}