import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Optimal {
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

HashSet<Integer> frames = new HashSet<>();
HashMap<Integer, Integer> index = new HashMap<>();
int pageFaults = 0;
int hits = 0;

for (int i = 0; i < numPages; i++) {
if (frames.size() < capacity) {
// Page is not in the frames

if (!frames.contains(pages[i])) {
pageFaults++;
frames.add(pages[i]);
} else {
hits++;
}
index.put(pages[i], nextIndex(pages, i, pages[i]));
} else {
// Frame is full, need to replace a page
if (!frames.contains(pages[i])) {
int farthestIndex = -1;
int pageToReplace = -1;

for (int frame : frames) {
int nextUse = nextIndex(pages, i, frame);
if (nextUse > farthestIndex) {
farthestIndex = nextUse;
pageToReplace = frame;
}
}

frames.remove(pageToReplace);
frames.add(pages[i]);
pageFaults++;
} else {
hits++;
}
index.put(pages[i], nextIndex(pages, i, pages[i]));
}

System.out.println("Current Frames: " + frames);
}

System.out.println("Number of Page Faults: " + pageFaults);
System.out.println("Hits: " + hits);
System.out.println("Hit Ratio: " + ((double) hits / numPages));
}

public static int nextIndex(int[] pages, int curIndex, int page) {
for (int j = curIndex + 1; j < pages.length; j++) {
if (pages[j] == page) {
return j; // Return the next index of the requested page
}
}
return Integer.MAX_VALUE; // If the page is not found again
}

public static void main(String[] args) {
Optimal optimal = new Optimal();
optimal.execute();
}
}

/* javac Optimal.java
   java Optimal */

