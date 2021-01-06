package t3;

import java.util.Arrays;
import java.util.Scanner;

/***********************************************************
 * @author SuBonan
 * 2020Äê11ÔÂ9ÈÕ
 * ProgrammingHomework.problems.TheThirdTask.java
 ***********************************************************/

class Solution{
	
	static String getAverage(int[] array){
		float ans = 0;
		for (int i = 0;i < array.length;i++)	ans += array[i];
		ans /= (double) array.length;
		return Integer.toString((int)Math.floor(ans));
	}
	
	static String sort(int[] array){
		Arrays.sort(array);
		String ans = Integer.toString(array[0]);
		for (int i = 1;i < array.length;i++)	ans = ans + "," + Integer.toString(array[i]);
		return ans;
	}
	
	static String ans = "";
	static void dfs(int u, int[] array){
		if (u > array.length)	return;
		dfs(u * 2, array);
		dfs(u * 2 + 1, array);
		if (ans != "")	ans += ",";
		ans += Integer.toString(array[u - 1]);
	}
	
	static String solve(int[] array){
		dfs(1, array);
		return getAverage(array) + "#" + sort(array) + "#" + ans;
	}
}

public class StrangeTask {
	public static void main(String[] args){
		Scanner ipt = new Scanner(System.in);
		int n = ipt.nextInt();
		int[] array = new int[n];
		for (int i = 0;i < n;i++)	array[i] = ipt.nextInt();
		System.out.println(Solution.solve(array));
	}
}
