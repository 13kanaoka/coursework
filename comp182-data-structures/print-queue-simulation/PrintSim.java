package LAB02;
import java.util.Random;
/*
 * PrintSim.java
 *
 */
/**
 * Simulate a system printer queue.
 */
public class PrintSim {

    // Data Fields
    /**
     * Queue of less than 10 pages jobs.
     */
    private final JobQueue tenPageQueue
            = new JobQueue("10-Page Jobs");
    /**
     * Queue of less than 20 pages jobs.
     */
    private final JobQueue twentyPageQueue
            = new JobQueue("20-Page Jobs");
    /**
     * Queue of more than 20 pages jobs.
     */
    private final JobQueue fiftyPageQueue
            = new JobQueue("50-Page Jobs");

    /**
     * Declare Total simulated time:
     */
		int totalTime;
	/**
     * Declare Simulated clock:
     */
		int clock;
	/**
     * Declare Time that the printer will be done with the current job:
     */
		public int[] timeDone;
    /**
     * Declare Flags for detailed report:
     */
		boolean showAll;
		private int NUMPRINTERS = 3;

    /**
     * Creates a new instance of PrintSim
     */
    public PrintSim() {
        showAll = true;
        timeDone = new int[NUMPRINTERS];
    }

    //Private Methods
    private void runSimulation() {
        Random random = new Random();
        int numPages;

        for (int i = 0; i < 100; i++) {
            numPages = (int)((Math.random() * 50) + 1);
            if (numPages < 10) {
                tenPageQueue.checkNewArrival(clock, numPages, showAll);
            } else if (numPages < 20) {
                twentyPageQueue.checkNewArrival(clock, numPages, showAll);
            } else {
                fiftyPageQueue.checkNewArrival(clock, numPages, showAll);
            }
	// for loop 0 to number of printers
			for (int j = 0; j < NUMPRINTERS; j++) {
                if (clock > timeDone[j]) {
                    startServe(j);
                }
            }

        while (!tenPageQueue.isEmpty() || !twentyPageQueue.isEmpty() || !fiftyPageQueue.isEmpty()) {
            for (int j = 0; j < NUMPRINTERS; j++) {
                if (clock >= timeDone[j]) {
                    startServe(j);
                }
            }
            clock++;
        }
        totalTime = clock - 1;
    }
    }

    private void startServe(int printer) {
        if (!tenPageQueue.isEmpty()) {
            timeDone[printer] = tenPageQueue.update(clock, printer, showAll);

        } else if (!twentyPageQueue.isEmpty()) {
            timeDone[printer] = twentyPageQueue.update(clock, printer, showAll);

        } else if (!fiftyPageQueue.isEmpty()) {
            timeDone[printer] = fiftyPageQueue.update(clock, printer, showAll);

        } else if (showAll) {
            System.out.println("Time is " + clock + " printer " + printer + " is idle");
        }
    }

    /**
     * Method to show the statistics.
     */
    private void showStats() {
        System.out.println("Time required in minutes: " + totalTime);
    }

    /**
     * Main method.
     *
     * @param args Not used
     */
    public static void main(String args[]) {
        PrintSim sim = new PrintSim();
        sim.runSimulation();
        sim.showStats();
        System.exit(0);
    }
}