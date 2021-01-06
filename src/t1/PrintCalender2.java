package t1;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
class T1
{
	String[][] biao=new String[8][7];
	boolean isrn(int year)
	{
		if ((year%4==0&&year%100!=0)||(year%400==0))	return true;
		else return false;
	}
	
	T1(int year, int month)
	{
		for (int i=0;i < 8;i++)	for(int j=0;j < 7;j++)	biao[i][j]="\t";
		LocalDate d1=LocalDate.of(2020, 11, 23);
		LocalDate d2=LocalDate.of(year, month, 1);
		int st=(int)((ChronoUnit.DAYS.between(d1, d2)%7+7)%7)+1;
		int days=0;
		switch (month)
		{
			case 1:				days=31;
			case 2:
				days=isrn(year) ? 29 : 28;break;
			case 3:
				days=31;break;
			case 4:
				days=30;break;
			case 5:
				days=31;break;
			case 6:
				days=30;break;
			case 7:
				days=31;break;
			case 8:
				days=31;break;
			case 9:
				days=30;break;
			case 10:
				days=31;break;
			case 11:
				days=30;break;
			case 12:
				days=31;break;
		}
		int x=2,y=st-1;
		for (int i=1;i<=days;i++)
		{
			biao[x][y]=String.format("%d\t", i);  
			y++;
			if (y==7)
			{
				y=0;x++;
			}
		}
	}
	void print(){
		for(int i=2;i<8;i++)
		{
			for(int j=0;j<7;j++)System.out.print(biao[i][j]+" ");
			System.out.println();
		}
	}
}
public class PrintCalender2 {
	public static void main(String[] args) throws IOException{
		Scanner ipt=new Scanner(System.in);
		int year=ipt.nextInt(),month=ipt.nextInt();
		T1 a=new T1(year,month);
		a.print();
	}
}
