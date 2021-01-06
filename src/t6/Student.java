package t6;

/***********************************************************
 * @author SuBonan
 * 2020Äê12ÔÂ22ÈÕ
 * zy202000460020.t6.Student.java
 ***********************************************************/

public class Student extends Person{
	double englishScore, mathScore, programScore;
	final int ENG = 6, MAT = 5, PRO = 4;
	
	Student(){
		super();
	}
	
	Student(String number, String name, int age, double englishScore, double mathScore, double programScore){
		super(number, name ,age);
		this.englishScore = englishScore;
		this.mathScore = mathScore;
		this.programScore = programScore;
	}
	
	@Override
	double getCompareValue() {
		return (englishScore + mathScore + programScore) / (double)(ENG + MAT + PRO);
	}

	@Override
	void print() {
		System.out.println("number:" + number + " name:" + name + " age:" + age + " English Score:" + englishScore + " Math Score:" + mathScore + " Program Score:" + programScore + " GPA:" + getCompareValue());
	}
}
