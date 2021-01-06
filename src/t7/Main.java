package t7;

/***********************************************************
 * @author SuBonan
 * 2021Äê1ÔÂ1ÈÕ
 * zy202000460020.t7.Main.java
 ***********************************************************/

public class Main {
	public static void main(String[] agrs){
		MyHashMap map = new MyHashMap(30);
		map.put("dog", "Bosco");
		map.put("dog", "Spot");
		map.put("cat", "Rags");
		System.out.println(map);
	}
}
