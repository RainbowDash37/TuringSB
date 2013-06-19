package algo;

import java.util.LinkedList;

public class InfiniteBand {
	
	LinkedList b = new LinkedList();
	
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
		String t;
		t = (String) b.get(i);
		return t;
	}
	
}
