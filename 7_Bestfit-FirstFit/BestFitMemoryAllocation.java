import java.util.Scanner;

public class BestFitMemoryAllocation {
    // Method to allocate memory to processes using the Best Fit strategy
    static void bestFit(int blockSizes[], int blocksCount, int processSizes[], int processesCount) {
        // Array to store the allocation for each process (-1 means not allocated)
        int allocation[] = new int[processesCount];
        
        // Initially, no process is allocated, so fill allocation array with -1
        for (int i = 0; i < allocation.length; i++) {
            allocation[i] = -1;
        }
        
        // Pick each process and find the best fitting block
        for (int i = 0; i < processesCount; i++) {
            int bestIdx = -1;
            
            for (int j = 0; j < blocksCount; j++) {
                // If block can accommodate process and it's a better fit (smaller block but fits)
                if (blockSizes[j] >= processSizes[i]) {
                    if (bestIdx == -1 || blockSizes[j] < blockSizes[bestIdx]) {
                        bestIdx = j;
                    }
                }
            }
            
            // If a block was found for process i
            if (bestIdx != -1) {
                // Allocate block j to process i
                allocation[i] = bestIdx;

                // Reduce available memory in this block
                blockSizes[bestIdx] -= processSizes[i];
            }
        }
        
        // Display process allocation results
        System.out.println("\nProcess No.\tProcess Size\tBlock No.");
        for (int i = 0; i < processesCount; i++) {
            System.out.print("   " + (i+1) + "\t\t" + processSizes[i] + "\t\t");
            if (allocation[i] != -1) {
                System.out.println(allocation[i] + 1);  // Block number (1-based indexing)
            } else {
                System.out.println("Not Allocated");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input the number of memory blocks
        System.out.print("Enter number of memory blocks: ");
        int blocksCount = sc.nextInt();
        
        int[] blockSizes = new int[blocksCount];
        System.out.println("Enter sizes of the memory blocks: ");
        for (int i = 0; i < blocksCount; i++) {
            blockSizes[i] = sc.nextInt();
        }

        // Input the number of processes
        System.out.print("Enter number of processes: ");
        int processesCount = sc.nextInt();

        int[] processSizes = new int[processesCount];
        System.out.println("Enter sizes of the processes: ");
        for (int i = 0; i < processesCount; i++) {
            processSizes[i] = sc.nextInt();
        }

        // Call best fit function to allocate memory
        bestFit(blockSizes, blocksCount, processSizes, processesCount);

        sc.close();
    }
}
/* Complie Program-
javac BestFitMemoryAllocation.java
java BestFitMemoryAllocation*/
