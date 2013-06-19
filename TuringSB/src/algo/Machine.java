package algo;

public class Machine {

	InfiniteBand b = new InfiniteBand();
	Programm p = new Programm();
	public int head = 0;
	public boolean ended = false;
	public String endValue;
	
	public Machine(){
		b.add("h");
		b.add("a");
		b.add("b");
		b.add("c");
		b.add("a");
		b.add("e");
		b.add("*");
		b.add("0");
		//b.add("1");
		//b.add("2");
	}
	
	public void setStart(){
		head = p.getStart();
	}
	
	public void allonsy(){
		System.out.println(b.get(head) + " head aktuell");
		String[] next = p.sendNext(b.get(head));
		
		for (int i = 0; i < next.length; i++){
			if (next[i].contains("goto") == true){
				String str = (String) next[i].subSequence(5, next[i].length());
				p.changeState(str);
				ended = false;
			}
			else if (next[i] == "l"){
				head--;
				ended = false;
			}
			else if (next[i] == "r"){
				head++;
				ended = false;
			}
			else if (next[i].contains("write") == true){
				String str = (String) next[i].subSequence(6, next[i].length());
				b.set(head, str);
				ended = false;
			}
			else if (next[i].contains("add") == true){
				System.out.println(b.get(head) + " head bei add");
				String str = (String) next[i].subSequence(4, next[i].length());
				System.out.println(str + " str");
				int t = Integer.parseInt(b.get(head)) + Integer.parseInt(str);
				b.set(head, Integer.toString(t));
				System.out.println("Aktueller Head: " + b.get(head));
				ended = false;
			}
			else if (next[i].contains("sub") == true){
				String str = (String) next[i].subSequence(5, next[i].length());
				int t = Integer.parseInt(b.get(head)) - Integer.parseInt(str);
				b.set(head, Integer.toString(t));
				ended = false;
			}
			else if (next[i].contains("print")){
				System.out.println("printing");
				String[] temp = b.getArray();
				for(int j = 0; j < b.b.size(); j++)
				{
					System.out.println(temp[j]);
				}
				ended = true;
				
			}
			else if (next[i].contains("END") == true){
				ended = true;
				break;
			}
				
		}
		
		for (int j = 0; j < next.length; j++){
			System.out.println("next step: " + next[j]);
		}
	}
		
}
