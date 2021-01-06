package t1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/***********************************************************
 * @author SuBonan
 * 2020Äê11ÔÂ9ÈÕ
 * ProgrammingHomework.problems.PrintCalender.java
 ***********************************************************/

class Month{
	protected String[][] table = new String[8][7];
	
	boolean check(int year){
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}
	
	Month(int year, int month){
		for (int i = 0;i < 8;i++)	for(int j = 0;j < 7;j++)	table[i][j] = "\t";
		LocalDate d1 = LocalDate.of(2020, 11, 9);
		LocalDate d2 = LocalDate.of(year, month, 1);
		int firstDay = (int)((ChronoUnit.DAYS.between(d1, d2) % 7 + 7) % 7) + 1;
		int days = 0;
		switch (month){
			case 1:
				days = 31;	table[0][3] = "Jan.\t"; break;
			case 2:
				days = check(year) ? 29 : 28;	table[0][3] = "Feb.\t"; break;
			case 3:
				days = 31;	table[0][3] = "Mar.\t"; break;
			case 4:
				days = 30;	table[0][3] = "Apr.\t"; break;
			case 5:
				days = 31;	table[0][3] = "May.\t"; break;
			case 6:
				days = 30;	table[0][3] = "Jun.\t"; break;
			case 7:
				days = 31;	table[0][3] = "Jul.\t"; break;
			case 8:
				days = 31;	table[0][3] = "Aug.\t"; break;
			case 9:
				days = 30;	table[0][3] = "Sept.\t"; break;
			case 10:
				days = 31;	table[0][3] = "Oct.\t"; break;
			case 11:
				days = 30;	table[0][3] = "Nov.\t"; break;
			case 12:
				days = 31;	table[0][3] = "Dec.\t"; break;
		}
		table[1] = new String[]{"MON\t", "TUE\t", "WED\t", "THU\t", "FRI\t", "SAT\t", "SUN\t"};
		int x = 2, y = firstDay - 1;
		for (int i = 1;i <= days;i++){
			table[x][y] = String.format("%d\t", i);  
			y++;
			if (y == 7){
				y = 0;x++;
			}
		}
	}
}
class Year{
	String[][] table = new String[27][31];
	Month[] month = new Month[13];
	Year(int year){
		for (int i = 1;i <= 12;i++)	month[i] = new Month(year, i);
		for (int x = 0;x < 27;x++) for (int y = 0;y < 31;y++)	{
			if (x == 8 || x == 17 || x == 26)	table[x][y] = "-----------\t";
			else table[x][y] = "|\t";
		}
		int count = 0;
		for (int x = 0;x < 27;x += 9) for (int y = 0;y < 31;y += 8){
			count++;
			for (int i = 0;i < 8;i++) for(int j = 0;j < 7;j++)	table[x + i][y + j] = month[count].table[i][j];
		}
	}
}
public class PrintCalender {
	public static void main(String[] args) throws IOException{
		System.out.println("Please enter year = ");
		Scanner ipt = new Scanner(System.in);
		int year = ipt.nextInt();
		
		File file = new File("out.txt");  
        file.createNewFile();  
        FileOutputStream fileOutputStream = new FileOutputStream(file);  
        PrintStream printStream = new PrintStream(fileOutputStream);  
        System.setOut(printStream);  
        
		Year y = new Year(year);
		for (int i = 0;i < 27;i++)	{
			for (int j = 0;j < 31;j++)	System.out.print(y.table[i][j]);
			System.out.println();
		}
	}
}
