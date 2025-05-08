import java.util.Scanner;

public class WorstFitMemoryAllocation {

    // Method to allocate memory using the Worst Fit strategy
    static void worstFit(int blockSizes[], int processes[]) {
        int blocksCount = blockSizes.length;
        int processesCount = processes.length;
        int allocation[] = new int[processesCount]; // Stores block assigned to each process (-1 if not allocated)

        // Initially no process is allocated
        for (int i = 0; i < processesCount; i++) {
            allocation[i] = -1;
        }

        // Worst Fit Allocation
        for (int i = 0; i < processesCount; i++) {
            int worstIdx = -1;  // Index of the largest block that fits the process
            for (int j = 0; j < blocksCount; j++) {
                if (blockSizes[j] >= processes[i]) {  // Block is big enough
                    if (worstIdx == -1 || blockSizes[j] > blockSizes[worstIdx]) {
                        worstIdx = j;  // Update to the worst (largest) fitting block
                    }
                }
            }

            // If a suitable block is found
            if (worstIdx != -1) {
                allocation[i] = worstIdx;             // Assign block to process
                blockSizes[worstIdx] -= processes[i]; // Reduce block size
            }
        }

        // Output result of Worst Fit
        System.out.println("Worst Fit Allocation:");
        System.out.println("Process No.\tProcess Size\tBlock No.");
        for (int i = 0; i < processesCount; i++) {
            System.out.print("   " + (i + 1) + "\t\t" + processes[i] + "\t\t");
            if (allocation[i] != -1) {
                System.out.println(allocation[i] + 1);  // Block number (1-based index)
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
        int[] processes = new int[processesCount];

        System.out.println("Enter sizes of the processes: ");
        for (int i = 0; i < processesCount; i++) {
            processes[i] = sc.nextInt();
        }

        // Call Worst Fit function to allocate memory
        worstFit(blockSizes, processes);

        sc.close();
    }
}

/*
  javac WorstFitMemoryAllocation.java
  java WorstFitMemoryAllocation
 */
