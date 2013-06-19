package algo;

public class Programm {

	State def = new State();
	State back = new State();
	State parse = new State();
	State count = new State();
	State check = new State();
	
	int currentState = 1;
	
	public Programm(){
		String[] bp = {"r", "goto check"};
		String[] bpn = {"l"};
		back.init("#", bp, bpn);
		
		String[] pp = {"write #", "goto count"};
		String[] ppn = {"r", "goto check"};
		parse.init("a", pp, ppn);
		
		String[] cp = {"r", "add 1", "goto back"};
		String[] cpn = {"r"};
		count.init("*", cp, cpn);
		
		String[] chp = {"print", "END"};
		String[] chpn = {"goto parse"};
		check.init("*", chp, chpn);
		
	}
	
	public String[] sendNext(String parseIn){
		String[] defa = {""};
		System.out.println("letzter State: " + stateName());
		switch (currentState){
		case 0: {return back.giveNext(parseIn);}
		case 1: {return parse.giveNext(parseIn);}
		case 2: {return count.giveNext(parseIn);}
		case 3: {return check.giveNext(parseIn);}
		default: {return defa;}
		}
	}
	
	public String stateName(){
		switch (currentState){
		case 0: {return "back";}
		case 1: {return "parse";}
		case 2: {return "count";}
		case 3: {return "check";}
		default : {return "NULL";}
		}
	}
	
	public int getStart(){
		return 1;
	}
	
	public void changeState(String i){
		switch(i){
		case "back": {currentState = 0; break;}
		case "parse": {currentState = 1; break;}
		case "count": {currentState = 2; break;}
		case "check": {currentState = 3; break;}
		}
	}
	
}
