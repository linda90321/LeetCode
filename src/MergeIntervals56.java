import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].

Hide Company Tags LinkedIn Google Bloomberg Microsoft
Hide Tags Array Sort
Hide Similar Problems (H) Insert Interval (E) Meeting Rooms (M) Meeting Rooms II
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class MergeIntervals56 {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals.size() == 0 || intervals == null)
        return res;
        
        Collections.sort(intervals, new IntervalComparator());
        
        Interval cur = intervals.get(0);
        for(int i=1;i<intervals.size();i++){
            if(cur.end >= intervals.get(i).start){
                Interval temp =new Interval();
                temp.start = cur.start;
                temp.end = Math.max(cur.end, intervals.get(i).end);
                cur = temp;
            }else{
                res.add(cur);
                cur = intervals.get(i);
            }
        }
        
        res.add(cur);
        
        return res;
    }
	public class IntervalComparator implements Comparator<Interval> {
		public int compare(Interval a, Interval b) {
			return a.start - b.start;
		}
	}
}
