package t7;

/***********************************************************
 * @author SuBonan
 * 2021Äê1ÔÂ1ÈÕ
 * zy202000460020.t7.MyHashMap.java
 ***********************************************************/

public class MyHashMap {
	MyNode[] sets;
	int size;
	
	MyHashMap(int size){
		this.size = size;
		sets = new MyNode[size];
	}
	
	void put(String key, String value){
		int id = key.hashCode() % size;
		if (sets[id] == null)	sets[id] = new MyNode(key, value, true);
		else	sets[id].nxt.insert(key, value);
	}
	
	@Override
	public String toString(){
		String res = "[\n";
		for (int i = 0;i < size;i++) if (sets[i] != null)	res = res + sets[i].nxt.print();
		res = res + "]";
		return res;
	}
}
