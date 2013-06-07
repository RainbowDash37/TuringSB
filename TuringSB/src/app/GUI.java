package app;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GUI extends JFrame {

	public GUI() throws IOException{
		 super("Turing Maschine");							//defining class and running superconstructor
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //what happens when clicking the X
         initGUI();											//calling the method for initializing the GUI-objects
	}
	
	public void initGUI() throws IOException {
		
        JPanel panel = new JPanel(new GridBagLayout());			//Main Panel
        this.getContentPane().add(panel);
        
        JPanel controlPanel = createControlPanel();				//SubPanel for Control, Play - Step - Stop
        JPanel outputPanel = createOutput();					//OutputPanel, contains the output box
        JPanel edit = createEditor();							//Only contains editor window
        JPanel helpPanel = createHelp();						//contains the Help and Check Button
        
        GridBagConstraints gbc = new GridBagConstraints();  	//setting up an easy GridBagConstraint to add the panels

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(edit, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(helpPanel, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.SOUTH;
        panel.add(controlPanel, gbc);
        gbc.anchor = GridBagConstraints.CENTER;
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(outputPanel, gbc);
        
        this.pack();
        this.setVisible(true);
	}
	
	private JPanel createEditor() throws IOException{
		JPanel panel = new JPanel(new GridBagLayout());
		
		JTextArea edit = new JTextArea("Hello good people and welcome to the editor!", 20, 40);
		
		JButton open = new JButton();
		open.setIcon(new ImageIcon(ImageIO.read(new File("open.png"))));
		open.setBorderPainted(false);
		open.setContentAreaFilled(false);
		
		JButton save = new JButton();
		save.setIcon(new ImageIcon(ImageIO.read(new File("save.png"))));
		save.setBorderPainted(false);
		save.setContentAreaFilled(false);
		
		JButton clear = new JButton();
		clear.setIcon(new ImageIcon(ImageIO.read(new File("clear.png"))));
		clear.setBorderPainted(false);
		clear.setContentAreaFilled(false);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
		panel.add(edit, gbc);
		
		gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5,5,5,5);
		panel.add(open, gbc);
		
		gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
		panel.add(save, gbc);
		
		gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
		panel.add(clear, gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		
		return panel;
	}
	
	private JPanel createHelp() throws IOException{
		JPanel panel = new JPanel();
		
		JButton check = new JButton();
		check.setIcon(new ImageIcon(ImageIO.read(new File("check.png"))));
		check.setBorderPainted(false);
		check.setContentAreaFilled(false);
		
		JButton help = new JButton();
		help.setIcon(new ImageIcon(ImageIO.read(new File("help.png"))));
		help.setBorderPainted(false);
		help.setContentAreaFilled(false);
		
		panel.add(check);
		panel.add(help);
		
		return panel;
	}
	
	
	private JPanel createControlPanel() throws IOException{
		JPanel panel = new JPanel();
		
		JButton play = new JButton();
		play.setIcon(new ImageIcon(ImageIO.read(new File("play3.png"))));
		play.setBorderPainted(false);
		play.setContentAreaFilled(false);
		
		JButton step = new JButton();
		step.setIcon(new ImageIcon(ImageIO.read(new File("step.png"))));
		step.setBorderPainted(false);
		step.setContentAreaFilled(false);
		
		JButton stop = new JButton();
		stop.setIcon(new ImageIcon(ImageIO.read(new File("stop.png"))));
		stop.setBorderPainted(false);
		stop.setContentAreaFilled(false);
		
		panel.add(play);
		panel.add(step);
		panel.add(stop);
		
		return panel;
	}
	
	private JPanel createOutput(){
		JPanel panel = new JPanel();
		
		JTextArea out = new JTextArea("Output irgendwann mal...", 5, 40);
		
		panel.add(out);
		
		return panel;
	}
	

}
