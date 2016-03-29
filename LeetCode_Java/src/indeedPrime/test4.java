package indeedPrime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class test4 {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int numOfCommands = Integer.parseInt(input.readLine());
		PrintWriter output = new PrintWriter(System.out);
		long[] superStack = new long[numOfCommands];
		long[] addition=new long[numOfCommands];
		int len=0;

		for (int i = 0; i < numOfCommands; i++) {
			String[] command = input.readLine().split(" ");
			if (command[0].equals("push")) {
				superStack[len++]=Integer.parseInt(command[1]);
				output.println(superStack[len-1]);
			} else if (command[0].equals("pop") && len > 0) {
				len--;
				if ((len-1)>=0){
					addition[len-1]+=addition[len];
					addition[len]=0;
				}
				if (len==0){
					output.println("EMPTY");
				}else{
					output.println(superStack[len-1]+addition[len-1]);
				}
			} else if (command[0].equals("inc")) {
				int x = Integer.parseInt(command[1]);
				long d = Long.parseLong(command[2]);
				x = Math.min(len, x);
				addition[x-1]+=d;
				output.println(superStack[len-1]+addition[len-1]);
			}
		}
		output.close();
    }
}
