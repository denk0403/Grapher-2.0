import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FunctionBox extends InputBox {
	
	JPanel inputs = new JPanel();

	FunctionBox(Plane plane) {
		super(plane);
		errorMessage.setPreferredSize(new Dimension(90,20));
		initComponents();
	}

	private void initComponents() {
		this.setPreferredSize(new Dimension(200,100));
		this.setLayout(new BorderLayout(0, 0));
		inputs.add(new JTextField(15));
		//this.add(Box.createHorizontalStrut(25), BorderLayout.WEST);
		this.add(inputs, BorderLayout.NORTH);
		this.add(errorMessage, BorderLayout.EAST);
	}
	
	
}
