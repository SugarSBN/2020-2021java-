package t7;

/***********************************************************
 * @author SuBonan
 * 2021Äê1ÔÂ1ÈÕ
 * zy202000460020.t7.MyNode.java
 ***********************************************************/

public class MyNode {
	MyNode pre, nxt;
	String key, val;
	boolean start;
	
	MyNode(String key, String val, boolean start){
		this.key = key;
		this.val = val;
		pre = this;
		nxt = this;
		this.start = start;
	}
	
	void insertNext(String key, String val){
		MyNode newNode = new MyNode(key, val, false);
		nxt.pre = newNode;
		newNode.nxt = nxt;
		newNode.pre = this;
		this.nxt = newNode;
	}
	
	void insert(String key, String val){
		if (start){
			if (this.key.equals(key))	this.val = val;
			else	insertNext(key, val);
		}else{
			if (this.key.equals(key))	this.val = val;
			else	nxt.insert(key, val);
		}
	}
	
	String print(){
		String res = key + ":" + val + ",\n";
		if (start)	return res;
		res = res + nxt.print();
		return res;
	}
}
