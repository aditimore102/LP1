import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FIFO {
private Scanner sc;

public void execute() {
sc = new Scanner(System.in);
System.out.println("Enter Number of Pages:");
int numPages = sc.nextInt();
int[] pages = new int[numPages];

System.out.println("Enter Reference String: ");
for (int i = 0; i < numPages; i++) {
pages[i] = sc.nextInt();
}

System.out.println("Enter Number of Frames:");
int capacity = sc.nextInt();

// To represent set of current pages
HashSet<Integer> frames = new HashSet<>();

// To store pages in FIFO manner
Queue<Integer> index = new LinkedList<>();
int pageFaults = 0;
int hits = 0;

for (int i = 0; i < numPages; i++) {
// If the page is not present in frames
if (!frames.contains(pages[i])) {
// If there is space in frames
if (frames.size() < capacity) {
frames.add(pages[i]);
index.add(pages[i]); // Push current page into queue
pageFaults++;
} else { // Set is full, need replacement
int val = index.poll(); // Remove the oldest page
frames.remove(val);
frames.add(pages[i]);
index.add(pages[i]); // Add the new page
pageFaults++;
}
// Output current frames
System.out.print("Current Frames: ");
for (int frame : index) {
System.out.print(frame + "\t");
}
System.out.println();
} else { // Page is present in set
hits++;
}
}

System.out.println("Number of Page Faults: " + pageFaults);
System.out.println("Hits: " + hits);

System.out.println("Hit Ratio: " + ((double) hits / numPages));
}

public static void main(String[] args) {
FIFO fifo = new FIFO();
fifo.execute();
}
}
