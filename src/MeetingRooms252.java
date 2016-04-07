import java.util.Arrays;
import java.util.Comparator;

/*Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

 For example,
 Given [[0, 30],[5, 10],[15, 20]],
 return false.

 Hide Company Tags Facebook
 Hide Tags Sort
 Hide Similar Problems (H) Merge Intervals (M) Meeting Rooms II
 */

// Definition for an interval.
class Interval{
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class MeetingRooms252 {
	public boolean canAttendMeetings(Interval[] intervals) {
		if (intervals == null || intervals.length == 0)
			return true;

		Arrays.sort(intervals, new IntervalComparator());

		for (int i = 0; i < intervals.length - 1; i++) {
			if (intervals[i].end > intervals[i + 1].start)
				return false;
		}

		return true;
	}

	public class IntervalComparator implements Comparator<Interval> {
		public int compare(Interval a, Interval b) {
			return a.start - b.start;
		}
	}
}
