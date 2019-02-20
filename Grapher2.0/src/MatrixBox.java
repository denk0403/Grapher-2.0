import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MatrixBox extends InputBox {
	
	JPanel inputs = new JPanel(new GridLayout(2, 2));

	MatrixBox(Plane plane) {
		super(plane);
		initComponents();
	}

	private void initComponents() {
		this.setPreferredSize(new Dimension(200,100));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		for (int i = 0; i < 4; i++) {
			inputs.add(new JTextField("0")); // adds across rows 
		}
		this.add(inputs);
		this.add(errorMessage);
	}
	
	
}
