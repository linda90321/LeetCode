/*The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
Hide Tags String
 */
public class ZigZagConversion6 {
	public String convert(String s, int numRows) {
		if (numRows == 1)
			return s;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numRows; i++) {
			int j = i;
			while (j < s.length()) {
				if (i == 0 || i == numRows - 1) {
					sb.append(s.charAt(j));
					j += 2 * (numRows - 1);
				} else {
					sb.append(s.charAt(j));

					int temp = j + 2 * (numRows - 1) - 2 * i;
					if (temp < s.length())
						sb.append(s.charAt(temp));

					j += 2 * (numRows - 1);

				}
			}

		}

		return sb.toString();
	}
}
