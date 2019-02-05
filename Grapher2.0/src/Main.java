import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

	public static void main(String[] args) {

		// frame set-up
		JFrame frame = new JFrame("Grapher 2.0");
		frame.setPreferredSize(new Dimension(1200, 900));
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		//frame.setLayout(new BorderLayout());

		// plane set-up
		Plane xy = new Plane(new Scale(50));
		xy.addVector(new Vector(1, 1));
		xy.addVector(new Vector(3, 6));
		xy.addVector(new Vector(3, -1, 7, 4));
		xy.addVector(new Vector(-2, -3));
		xy.addVector(new Vector(-7, 5));
		xy.addVector(new Vector(-1, 2, -5, -2));
		
		JPanel outerPanel = new JPanel(new BorderLayout());
		
//		JPanel planePanel = new JPanel();
//		planePanel.add(xy);

		Controls ctrls = new Controls();
		ctrls.setPreferredSize(new Dimension(200,0));
		outerPanel.add(ctrls, BorderLayout.WEST);
		
		outerPanel.add(xy, BorderLayout.CENTER);
		frame.add(outerPanel);
		frame.pack();
		frame.setVisible(true);
	}

}
