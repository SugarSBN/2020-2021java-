package t6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/***********************************************************
 * @author SuBonan
 * 2021Äê1ÔÂ1ÈÕ
 * zy202000460020.t6.Main.java
 ***********************************************************/

public class Main {
	static List<Person> per = new ArrayList();
	public static void main(String[] args) throws FileNotFoundException{
		Scanner ipt = new Scanner(new FileInputStream(new File("./test.txt")));
		while(ipt.hasNext()){
			StringTokenizer str = new StringTokenizer(ipt.nextLine());
			if (str.countTokens() == 4)		per.add(new Staff((String)str.nextElement(), (String)str.nextElement(), Integer.valueOf((String)str.nextElement()), Double.valueOf((String)str.nextElement())));
			else	per.add(new Student((String)str.nextElement(), (String)str.nextElement(), Integer.valueOf((String)str.nextElement()), Double.valueOf((String)str.nextElement()),  Double.valueOf((String)str.nextElement()),  Double.valueOf((String)str.nextElement())));
		}
		
		per.sort(new Comparator<Person>(){
			public int compare(Person o1, Person o2) {
				if (o1.age == o2.age){
					if (o1.number.equals(o2.number))	return 0;
					return o1.number.compareTo(o2.number);
				}else	return o1.age < o2.age ? -1 : 1;
			}
		});
		
		for (int i = 0;i < per.size();i++)	per.get(i).print();
		System.out.println();
		
		per.sort(new Comparator<Person>(){
			public int compare(Person o1, Person o2) {
				if	(Math.abs(o1.getCompareValue() - o2.getCompareValue()) <= 1e-9)	return 0;
				return o1.getCompareValue() < o2.getCompareValue() ? -1 : 1;
			}
		});						// sorted by age and id
		
		System.out.println("Students:");
		for (int i = 0;i < per.size();i++){
			String name = per.get(i).getClass().getName();
			name = name.substring(name.lastIndexOf('.') + 1);
			if (name.equals("Student"))	per.get(i).print();
		}
		
		System.out.println("Staff:");
		for (int i = 0;i < per.size();i++){
			String name = per.get(i).getClass().getName();
			name = name.substring(name.lastIndexOf('.') + 1);
			if (name.equals("Staff"))	per.get(i).print();
		}
	}
}
