import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ControlPanel extends JPanel {
	
	PanelOfInputs inputBoxes;
	Plane plane;

	public ControlPanel(PanelOfInputs inputBoxes, Plane plane) {
		// TODO Auto-generated constructor stub
		this.inputBoxes = inputBoxes;
		this.plane = plane;
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		//this.setSize(new Dimension(100, 900));
		this.setLayout(new BorderLayout());
		this.add(new InputBoxAdder(this, this.plane), BorderLayout.NORTH);
		this.add(inputBoxes, BorderLayout.CENTER);
		//this.add(Box.createVerticalGlue());
//		this.add(new JButton("Click here!"));
//		JTextArea text = new JTextArea("\n\nText here doesn't do anything, \nbut vectors will go here \neventually!");
//		this.add(text);
//		this.add(new MatrixBox());
//		this.add(new VectorBox());
	}
	
	void addInputBox(InputBox box, int index) {
		inputBoxes.add(box, index);
	}
	
	void addInputBox(InputBox box) {
		inputBoxes.add(box);
	}
	

	
	
	
	
}
