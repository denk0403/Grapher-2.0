import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

public class InputBoxAdder extends JMenuBar {
	
	ControlPanel controls;
	Plane plane;

	public InputBoxAdder(ControlPanel controls, Plane plane) {
		this.controls = controls;
		this.plane = plane;
		initComponents();
	}

	private void initComponents() {
		//this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setMinimumSize(new Dimension(400,100));
		JMenu list = new JMenu("Add ...");
		JMenuItem addVector = new JMenuItem("Add Vector");
		JMenuItem addMatrix = new JMenuItem("Add Matrix");
		JMenuItem addFunction = new JMenuItem("Add Function");
		
		addVector.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) { 
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				controls.addInputBox(new VectorBox(plane));
				controls.revalidate();
				controls.plane.repaint();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		addMatrix.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				controls.addInputBox(new MatrixBox(plane));
				controls.revalidate();
				controls.plane.repaint();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		addFunction.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				controls.addInputBox(new FunctionBox(plane));
				controls.revalidate();
				controls.plane.repaint();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		list.add(addVector);
		list.add(addMatrix);
		list.add(addFunction);
		this.add(list);
		this.setVisible(true);
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				list.setVisible(true);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	

}
