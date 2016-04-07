import java.util.ArrayList;
import java.util.List;

/*Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:
 Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

 Example 2:
 Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

 This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

 Hide Company Tags LinkedIn Google
 Hide Tags Array Sort
 Hide Similar Problems (H) Merge Intervals
 */

public class InsertInterval57 {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> res = new ArrayList<Interval>();
		if (newInterval == null)
			return intervals;

		if (intervals == null || intervals.size() == 0) {
			res.add(newInterval);
			return res;
		}

		Interval pre = newInterval;

		for (int i = 0; i < intervals.size(); i++) {
			Interval cur = intervals.get(i);
			if (cur.start > pre.end) {
				res.add(pre);
				pre = cur;
			} else if (cur.end < pre.start) {
				res.add(cur);
			} else {
				pre.start = Math.min(pre.start, cur.start);
				pre.end = Math.max(pre.end, cur.end);
			}
		}
		res.add(pre);

		return res;

	}
}
