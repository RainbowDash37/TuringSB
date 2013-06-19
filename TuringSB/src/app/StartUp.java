package app;

import java.io.IOException;

import javax.swing.JOptionPane;

import algo.Machine;

public class StartUp {
	/**
	 * @param args
	 * @throws IOException 
	 */
	
	public static void main(String[] args) throws IOException {
	    Machine m = new Machine();
	    m.setStart();
	    while (m.ended == false){
	    	m.allonsy();
	    	System.out.println("One Time Run: " + m.head);
	    	System.out.println("-----");
	    }
	    System.out.println("FINISHED!!!");
	}

}
