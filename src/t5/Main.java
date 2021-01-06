package t5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/***********************************************************
 * @author SuBonan
 * 2020Äê11ÔÂ20ÈÕ
 * zy202000460020.t5.Main.java
 ***********************************************************/


class Solution{
	List<Student> students = new ArrayList<>();
	List<Course> courses = new ArrayList<>();
	List<Score>	scores = new ArrayList<>();
	
	void input(File A, File B, File C){
		try{
			Scanner ipt = new Scanner(new FileInputStream(A));
			while (ipt.hasNext())	students.add(new Student(ipt.next(), ipt.next()));
			ipt.close();
		} catch (Exception e){
			System.out.println(A.getName() + ":File not Found or Invalid input");
		}
		
		HashSet<Student> s = new HashSet<>(students);   
	    students.clear();   
	    students.addAll(s); 
	    
		try{
			Scanner ipt = new Scanner(new FileInputStream(B));
			while (ipt.hasNext())	courses.add(new Course(ipt.next(), ipt.nextDouble()));
			ipt.close();
		} catch (Exception e){
			System.out.println(B.getName() + ":File not Found or Invalid input");
		}
		
		HashSet<Course> c = new HashSet<>(courses);   
	    courses.clear();   
	    courses.addAll(c); 
	    
		try{
			Scanner ipt = new Scanner(new FileInputStream(C));
			while (ipt.hasNext()){	
				Student student = new Student(ipt.next(), ipt.next());
				Course course = new Course(ipt.next(), ipt.nextDouble());
				scores.add(new Score(student, course, ipt.nextDouble()));
			}
			ipt.close();
		} catch (Exception e){
			System.out.println(C.getName() + ":File not Found or Invalid input");
		}
		
	}

	void updateScores(){
		for (Score score : scores)
			for (Student student : students)
				if (student.stuNum.equals(score.student.stuNum))
					student.insert(score);
	}
	
	void sortAndPrint(){
		students.sort(new Student());
		for (Student student : students)	System.out.println(student.stuName + " " + student.stuNum + " " + student.GPA);
	}
	
	void save(){
		try{
			PrintWriter out = new PrintWriter(new FileOutputStream("S.txt"));
			for (Student student : students)	out.println(student.stuName + " " + student.stuNum);
			out.close();
			out = new PrintWriter(new FileOutputStream("C.txt"));
			for (Course course : courses)	out.println(course.name + " " + course.credit);
			out.close();
			out = new PrintWriter(new FileOutputStream("A.txt"));
			for (Score score : scores)	out.println(score.student.stuName + " " + score.student.stuNum + " " + score.course.name + " " + score.course.credit + " " + score.score);
			out.close();
		} catch (Exception e){}
	}
	
	void solve(String A, String B, String C){
		input(new File("S.txt"), new File("C.txt"), new File("A.txt"));
		input(new File(A), new File(B), new File(C));
		updateScores();
		sortAndPrint();
		save();
	}
}

public class Main {
	public static void main(String[] args){
		Scanner ipt = new Scanner(System.in);
		Solution sol = new Solution();
		sol.solve(ipt.next(), ipt.next(), ipt.next());
		ipt.close();
	}
}
