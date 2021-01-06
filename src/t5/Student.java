package t5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/***********************************************************
 * @author SuBonan
 * 2020Äê11ÔÂ20ÈÕ
 * zy202000460020.t5.Student.java
 ***********************************************************/

class Student implements Comparator<Student>{
	String stuNum, stuName;
	double creditTotal, creditScoreTotal, GPA;
	List<Score> scoreSet = new ArrayList<>();
	
	Student(){}
	Student(String stuName, String stuNum){
		this.stuNum = stuNum; this.stuName = stuName;
	}
	
	private void upd(){
		GPA = creditScoreTotal / creditTotal;
	}
	
	void insert(Score score){
		for (Score c : scoreSet)	
			if (c.course.equals(score.course)){
				creditTotal -= c.course.credit;
				creditScoreTotal -= c.score;
				scoreSet.remove(c);
				break;
			}
		scoreSet.add(score);
		creditTotal += score.course.credit;
		creditScoreTotal += score.score;
		upd();
	}
	
	@Override
	public boolean equals(Object student){
		return stuNum.equals(((Student)student).stuNum);
	}
	
	@Override
	public int hashCode(){
		return stuNum.hashCode();
	}
	
	@Override
	public int compare(Student o1, Student o2) {
		double z = o1.GPA - o2.GPA;
		if(Math.abs(z) <= 1e9) return 0;
		return z > 0 ? 1 : -1;
	}
}