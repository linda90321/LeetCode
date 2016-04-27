import java.util.HashMap;

/*Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Hide Company Tags LinkedIn Apple Twitter
Hide Tags Hash Table Math
 */
//http://www.cnblogs.com/springfor/p/3896120.html
 // Definition for a point.
 class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
}
public class MaxPointsOnALine149 {
	public int maxPoints(Point[] points) {
		if (points == null || points.length == 0)
			return 0;

		int max = 0;
		for (int i = 0; i < points.length; i++) {
			HashMap<Float, Integer> map = new HashMap<Float, Integer>();
			int same = 0;
			int localMax = 1;
			for (int j = 0; j < points.length; j++) {
				if (points[i] == points[j])
					continue;

				if (points[i].x == points[j].x && points[i].y == points[j].y) {
					same++;
					continue;
				}

				float slope = ((float) (points[i].y - points[j].y))
						/ (points[i].x - points[j].x);

				if (map.containsKey(slope)) {
					map.put(slope, map.get(slope) + 1);
				} else {
					map.put(slope, 2);
				}
			}

			for (Integer value : map.values()) {
				localMax = Math.max(localMax, value);
			}
			localMax += same;
			max = Math.max(max, localMax);

		}

		return max;
	}
}
