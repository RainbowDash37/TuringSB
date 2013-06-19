package algo;

import java.util.LinkedList;

public class InfiniteBand {
	
	LinkedList<String> b = new LinkedList<String>();
	
	public InfiniteBand(){
		b.add("#");
	}
	
	public void add(String a){
		b.add(a);
	}
	
	public void set(int i, String a){
		b.set(i, a);
	}
	
	public void remove(int i){
		b.remove(i);
	}
	
	public String get(int i){
		//System.out.println(i);
		String tmp = b.get(i);
		return tmp;
	}
	
	public String[]	getArray(){
		String[] temp = b.toArray(new String[b.size()]);
		return temp;
	}
	
}
