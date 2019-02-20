import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class PanelOfInputs extends JPanel{
	
	Plane plane;
	
	public PanelOfInputs(Plane plane) {
		super();
		this.plane = plane;
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
	}
	
}
