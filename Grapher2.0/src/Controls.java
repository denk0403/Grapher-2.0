import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Controls extends JPanel {

	public Controls() {
		// TODO Auto-generated constructor stub
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		//this.setSize(new Dimension(100, 900));
		this.setLayout(new GridLayout(5,1));
		this.add(new JButton("Click here!"));
		JTextArea text = new JTextArea("\n\nText here doesn't do anything, \nbut vectors will go here \neventually!");
		this.add(text);
	}

	
	
	
	
}
