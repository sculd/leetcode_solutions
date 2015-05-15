import java.util.*;

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}

class Solution {
    private boolean ifOverlap(Interval interval1, Interval interval2)   {
        return (interval1.start <= interval2.end && interval1.end >= interval2.start) || 
                (interval2.start <= interval1.end && interval2.end >= interval1.start);
    }
    
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
        boolean ifInserted = false;
        for (Interval interval: intervals)  {
            if (!ifInserted && (ifOverlap(interval, newInterval) || interval.start > newInterval.start))    {
                result.add(newInterval);
                ifInserted = true;
            }
            
            if (ifInserted && ifOverlap(interval, newInterval))    {
                newInterval.start = Math.min(newInterval.start, interval.start);
                newInterval.end = Math.max(newInterval.end, interval.end);
            } else {
                result.add(interval);
            }
        }
        
        if (!ifInserted)
            result.add(newInterval);
        
        return result;
    }
}

public class InsertInterval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
