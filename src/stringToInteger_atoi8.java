/*Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

spoilers alert... click to show requirements for atoi.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */public class stringToInteger_atoi8 {
	/*
	 * 参数str字符串，如果第一个非空格字符存在，是数字或者正负号则开始做类型转换，之后检测到非数字(包括结束符 \0)
	 * 字符时停止转换，返回整型数。否则，返回零。
	 */
	public int myAtoi(String str) {
		if (str.length() == 0 || str == null)
			return 0;
		str = str.trim();
		boolean flag = false;
		int index = 0;
		if (str.charAt(0) == '+') {
			index++;
		} else if (str.charAt(0) == '-') {
			flag = true;
			index++;
		}

		long res = 0;
		for (int i = index; i < str.length(); i++) {
			if (isValid(str.charAt(i))) {
				res = res * 10 + (long) (str.charAt(i) - '0');
			} else
				break;
			if (res >= Integer.MAX_VALUE)
				break;
		}

		if (flag)
			res = -res;

		if (res >= Integer.MAX_VALUE)
			return Integer.MAX_VALUE;

		if (res <= Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		return (int) res;

	}

	public boolean isValid(char c) {
		if (c >= '0' && c <= '9')
			return true;

		return false;
	}
}
