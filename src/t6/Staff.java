package t6;

/***********************************************************
 * @author SuBonan
 * 2020Äê12ÔÂ22ÈÕ
 * zy202000460020.t6.Staff.java
 ***********************************************************/

public class Staff extends Person{
	double salary;
	
	Staff(){
		super();
	}
	
	Staff(String number, String name, int age, double salary){
		super(number, name, age);
		this.salary = salary;
	}

	@Override
	double getCompareValue() {
		return salary;
	}
	
	@Override
	void print() {
		System.out.println("number:" + number + " name:" + name + " age:" + age + " salary:" + salary);
	}
}
