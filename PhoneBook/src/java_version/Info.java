package java_version;

import java.time.Duration;

public class Info {
    private static long startSearchingTime;
    private static long endSearchingTime;
    private static long startSortingTime;
    private static long startCreatingTime;
    private static long endCreatingTime;
    private static long endSortingTime;
    private static long linearSearchTime;

    void startSearch() {
        startSearchingTime = System.currentTimeMillis();
    }

    void startCreating() {
        startCreatingTime = System.currentTimeMillis();
    }

    void endCreating() {
        endCreatingTime = System.currentTimeMillis();
    }

    void endSearchTime() {
        endSearchingTime = System.currentTimeMillis();
    }

    void startSorting() {
        startSortingTime = System.currentTimeMillis();
    }

    void endSorting() {
        endSortingTime = System.currentTimeMillis();

    }

    public void setLinearSearchTime() {
        linearSearchTime = endSearchingTime - startSearchingTime;
    }

    public long getLinearSearchTime() {
        setLinearSearchTime();
        return linearSearchTime;
    }

    long currentSortingTime() {
        return System.currentTimeMillis() - startSortingTime;
    }

    String getTime(long time) {
        Duration duration = Duration.ofMillis(time);
        long seconds = duration.toSecondsPart();
        long minutes = duration.toMinutesPart();
        long milliseconds = duration.toMillisPart();
        return String.format("%d min. %d sec. %d ms.", minutes, seconds, milliseconds);
    }

    void printLinearSearchTime() {
        System.out.println("Time taken: " + getTime(getLinearSearchTime()));
    }

    void printLinearSearchAndBubbleSortTime() {
        System.out.println("Time taken: " + getTime(endSortingTime - startSortingTime + getLinearSearchTime()));
        System.out.println("Sorting time: " + getTime(endSortingTime - startSortingTime));
        System.out.print(" - STOPPED, moved to linear search\n");
        System.out.println("Searching time: " + getTime(getLinearSearchTime()));

    }

    void printAllTime() {
        System.out.println("Time taken: " + getTime(endSearchingTime - startSortingTime));
        System.out.println("Sorting time: " + getTime(endSortingTime - startSortingTime));
        System.out.println("Searching time: " + getTime(endSearchingTime - startSearchingTime));

    }

    void printHashMapTime() {
        System.out.println("Time taken: " + getTime(endSearchingTime - startCreatingTime));
        System.out.println("Creating time: " + getTime(endCreatingTime - startCreatingTime));
        System.out.println("Searching time: " + getTime(endSearchingTime - startSearchingTime));

    }

    void printFoundEntries(int count, int namesCount) {
        System.out.printf("Found %d / %d entries. ", count, namesCount);
    }
}