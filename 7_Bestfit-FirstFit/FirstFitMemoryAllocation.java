import java.util.Scanner;

public class FirstFitMemoryAllocation {

    // Method to allocate memory using the First Fit strategy
    static void firstFit(int blockSizes[], int processes[]) {
        int blocksCount = blockSizes.length;
        int processesCount = processes.length;
        int allocation[] = new int[processesCount]; // Stores block assigned to each process (-1 if not allocated)

        // Initially no process is allocated
        for (int i = 0; i < processesCount; i++) {
            allocation[i] = -1;
        }

        // First Fit Allocation
        for (int i = 0; i < processesCount; i++) {
            for (int j = 0; j < blocksCount; j++) {
                if (blockSizes[j] >= processes[i]) {  // If block j can accommodate process i
                    allocation[i] = j;              // Assign block j to process i
                    blockSizes[j] -= processes[i];  // Reduce available memory in this block
                    break;  // Move to the next process after allocation
                }
            }
        }

        // Output result of First Fit
        System.out.println("First Fit Allocation:");
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

        // Call First Fit function to allocate memory
        firstFit(blockSizes, processes);

        sc.close();
    }
}
