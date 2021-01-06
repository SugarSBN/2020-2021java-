package t2;

import java.util.Scanner;

/***********************************************************
 * @author SuBonan
 * 2020Äê11ÔÂ9ÈÕ
 * ProgrammingHomework.problems.T2.java
 ***********************************************************/
class Solution{
	
	static String baseConvention(int x){
		return Integer.toBinaryString(x);
	}
	
	static String primeFactors(int x){
		String ans = "";
		for (int i = 2;i * i <= x;i++){
			while(x % i == 0){
				if (!ans.equals(""))	ans = ans + ",";
				ans = ans + i;
				x /= i;
			}
		}
		if (x != 1){
			if (!ans.equals(""))	ans = ans + ",";
			ans = ans + x;
		}
		return ans;
	}
	
	static String solve(int x){
		return baseConvention(x) + "#" + primeFactors(x);
	}
}
public class BaseConventionAndPrimeFactors {
	public static void main(String[] args){
		Scanner ipt = new Scanner(System.in);
		int x = ipt.nextInt();
		while(x != -1){
			System.out.println(Solution.solve(x));
			x = ipt.nextInt();
		}
	}
}
