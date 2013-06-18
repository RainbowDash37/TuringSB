package algo;

public class Programm {

	State def = new State();
	State back = new State();
	State parse = new State();
	State count = new State();
	State check = new State();
	
	int currentState = 0;
	
	public Programm(){
		String[] bp = {"goto check"};
		String[] bpn = {"l"};
		back.init("#", bp, bpn);
		
		String[] pp = {"write #", "goto count"};
		String[] ppn = {"r"};
		parse.init("a", pp, ppn);
		
		String[] cp = {"r", "add 1", "back"};
		String[] cpn = {"r"};
		count.init("*", cp, cpn);
		
		String[] chp = {"END"};
		String[] chpn = {"goto Parse"};
		check.init("#", chp, chpn);
		
	}
	
	public String[] sendNext(String parseIn){
		String[] defa = {""};
		switch (currentState){
		case 0: {return back.giveNext(parseIn);}
		case 1: {return parse.giveNext(parseIn);}
		case 2: {return count.giveNext(parseIn);}
		case 3: {return check.giveNext(parseIn);}
		default: {return defa;}
		}
	}
	
	public void changeState(int i){
		currentState = i;
	}
	
}
