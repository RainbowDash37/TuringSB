package algo;

public class State {
	
	String c;
	String t;
	String[] p;
	String[] pn;
	
	public State(){
		
	}

	public void init(String t, String[] p, String[] pn){
		this.t = t;
		this.p = p;
		this.pn = pn;
	}
	
	public String[] giveNext(String parse){
		if (parse == t) {
			return p;
		}
		else {
			return pn;
		}
	}
	
}
