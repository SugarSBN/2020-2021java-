package t5;

/***********************************************************
 * @author SuBonan
 * 2020Äê11ÔÂ20ÈÕ
 * zy202000460020.t5.Course.java
 ***********************************************************/

class Course {
	String name;
	double credit;
	
	Course(){}
	Course(String name, double credit){
		this.name = name; this.credit = credit;
	}
	
	@Override
	public boolean equals(Object course){
		return name.equals(((Course)course).name);
	}
	
	@Override
	public int hashCode(){
		return name.hashCode();
	}
}
