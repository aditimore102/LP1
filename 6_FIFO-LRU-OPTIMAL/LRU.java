import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LRU {
private Scanner sc;

public void execute() {
sc = new Scanner(System.in);
System.out.println("Enter Number of Pages:");
int numPages = sc.nextInt();
int[] pages = new int[numPages];

System.out.println("Enter Reference String:");
for (int i = 0; i < numPages; i++) {
pages[i] = sc.nextInt();
}

System.out.println("Enter Number of Frames:");
int capacity = sc.nextInt();

// Using LinkedHashMap to maintain the order of pages
Map<Integer, Integer> lruCache = new LinkedHashMap<>(capacity, 0.75f, true);
int pageFaults = 0;
int hits = 0;

for (int i = 0; i < numPages; i++) {
if (!lruCache.containsKey(pages[i])) {
// Page fault occurs

pageFaults++;
if (lruCache.size() >= capacity) {
// Remove the least recently used (LRU) page
int lruPage = lruCache.keySet().iterator().next();
lruCache.remove(lruPage);
}
} else {
// Hit occurs
hits++;
}
lruCache.put(pages[i], i); // Update the page in cache
System.out.print("Current Frames: " + lruCache.keySet() + "\n");
}

System.out.println("Number of Page Faults: " + pageFaults);
System.out.println("Hits: " + hits);
System.out.println("Hit Ratio: " + ((double) hits / numPages));
}

public static void main(String[] args) {
LRU lru = new LRU();
lru.execute();
}
}

/* javac LRU.java
   java LRU */
