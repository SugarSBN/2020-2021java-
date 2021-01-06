package t6;

/***********************************************************
 * @author SuBonan
 * 2020Äê12ÔÂ22ÈÕ
 * zy202000460020.t6.Person.java
 ***********************************************************/

public abstract class Person {
	String number, name;
	int age;
	
	Person(){}
	
	Person(String number, String name, int age){
		this.number = number;
		this.name = name;
		this.age = age;
	}
	
	abstract double getCompareValue();
	
	abstract void print();
}
