package algo;

public class Machine {

	InfiniteBand b = new InfiniteBand();
	Programm p = new Programm();
	int head = 0;
	
	public Machine(){
		b.add("h");
		b.add("a");
		b.add("l");
		b.add("l");
		b.add("a");
		b.add("o");
		b.add("*");
		b.add("0");
		//TO-DO: parse in the retured next files -> split string up
		//		 create a head!!
		//		 switch the code, e.g. l makes the head go left, add adds a param to the current...
	}
	
	public void setStart(){
		head = p.getStart();
	}
	
	public void allonsy(){
		String[] next = p.sendNext(b.get(head));
		for (int i = 0; i <= next.length; i++){
			if (next[i].contains("goto") == true){
				String str = (String) next[i].subSequence(5, next[i].length());
				p.changeState(str);
			}
			else if (next[i] == "l"){
				head++;
			}
			else if (next[i] == "r"){
				head--;
			}
			else if (next[i].contains("write") == true){
				String str = (String) next[i].subSequence(6, next[i].length());
				b.set(head, str);
			}
			else if (next[i].contains("add") == true){
				String str = (String) next[i].subSequence(5, next[i].length());
				int t = Integer.parseInt(b.get(head)) + Integer.parseInt(str);
				b.set(head, Integer.toString(t));
			}
				
		}
	}
		
}
