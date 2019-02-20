import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collection;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class CloseButton extends JButton{
	
	Component obj;
	Container objParent;

	public CloseButton(Component obj, Container parent) {
		super("Close");
		this.obj = obj;
		this.objParent = parent;
		this.setBorder(BorderFactory.createEmptyBorder());
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				objParent.remove(obj);
				objParent.revalidate();
				objParent.repaint();
				((PanelOfInputs)objParent).plane.repaint();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.RED);
		g2.setStroke(new BasicStroke(3));
		g2.drawLine(5, 5, 20, 20);
		g2.drawLine(20, 5, 5,20);
		paintBorder(g2);
	}
	
	
}
