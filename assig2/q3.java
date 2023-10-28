import java.util.ArrayList;
import java.util.List;

class Interval {

    int first, second;
    Interval(int x, int y) 
    {
        first = x;
        second = y;
    }
}

 class MergeIntervals {
    public static List<int[]> mergeIntervals(List<int[]> intervals) {
        List<int[]> result = new ArrayList<>();

        if (intervals.isEmpty()) {
            return result;
        }

        int currentStart = intervals.get(0)[0];
        int currentEnd = intervals.get(0)[1];

        for (int i = 1; i < intervals.size(); i++) {
            int nextStart = intervals.get(i)[0];
            int nextEnd = intervals.get(i)[1];

            if (currentEnd >= nextStart) {
                if (nextEnd > currentEnd) {
                    currentEnd = nextEnd;
                }
            } else {
                result.add(new int[]{currentStart, currentEnd});
                currentStart = nextStart;
                currentEnd = nextEnd;
            }
        }

        result.add(new int[]{currentStart, currentEnd});

        return result;
    }

    public static void main(String[] args) {
        List<int[]> intervals = new ArrayList<>();
        intervals.add(new int[]{1, 3});
        intervals.add(new int[]{2, 6});
        intervals.add(new int[]{8, 10});
        intervals.add(new int[]{15, 18});

        List<int[]> mergedIntervals = mergeIntervals(intervals);
        System.out.println("The merged intervals are as follow:");

        for (int[] interval : mergedIntervals) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}
