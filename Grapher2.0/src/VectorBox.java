import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class VectorBox extends InputBox {

	JPanel inputs = new JPanel(new GridLayout(2, 2));
	JPanel buttons = new JPanel(new BorderLayout());
	Vector vector = new Vector(0, 0);
	
	CloseButton closeButton;

	VectorBox(Plane plane) {
		super(plane);
		initComponents();
	}

	private void initComponents() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(190,100));

		JSpinner lengthEntry = new JSpinner(
				new SpinnerNumberModel(0, -Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0.05));
		lengthEntry.setPreferredSize(new Dimension(100, 40));

		JSpinner xEntry = new JSpinner(
				new SpinnerNumberModel(0, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 0.05));
		xEntry.setPreferredSize(new Dimension(100, 40));

		inputs.add(xEntry); // adds across rows
		xEntry.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				vector = new Vector((Double) xEntry.getValue(), vector.getYComponent(), vector.getColor());
				lengthEntry.setValue(vector.getLength());
				plane.repaint();
			}
		});

		JSpinner yEntry = new JSpinner(
				new SpinnerNumberModel(0, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 0.05));
		yEntry.setPreferredSize(new Dimension(100, 40));

		inputs.add(yEntry); // adds across rows
		yEntry.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				vector = new Vector(vector.getXComponent(), (Double) yEntry.getValue(), vector.getColor());
				lengthEntry.setValue(vector.getLength());
				plane.repaint();
			}
		});

		JLabel lengthText = new JLabel("Length: ");
		inputs.add(lengthText);

		inputs.add(lengthEntry); // adds across rows
		lengthEntry.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				double origLength = Math.hypot(vector.getXComponent(), vector.getYComponent());
				if (origLength <= 0.025) {
					lengthEntry.setValue(new Double(0));
				}
				double newLength = (Double) lengthEntry.getValue();
				if (newLength <= 0.025) {
					xEntry.setValue(new Double(0));
					yEntry.setValue(new Double(0));
				}
				if (Math.abs(newLength - origLength) > 0.01) {
					xEntry.setValue(vector.getXComponent() / origLength * newLength);
					yEntry.setValue(vector.getYComponent() / origLength * newLength);
				}
				//vector = new Vector(vector.getXComponent() / origLength * newLength,
						//(Double) yEntry.getValue() / origLength * newLength, vector.getColor());
				plane.repaint();
			}
		});
		
		JButton flipButton = new JButton("Negate Vector");
		flipButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {
				xEntry.setValue(-vector.getXComponent());
				yEntry.setValue(-vector.getYComponent());
			}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {}
		});

		this.add(inputs);
		buttons.add(flipButton, BorderLayout.WEST);
		//buttons.add(closeButton, BorderLayout.EAST);
		//this.add(buttons);
		//this.add(errorMessage);	
		//this.hideError();
		//this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, true));
		this.setBorder(BorderFactory.createRaisedBevelBorder());
	}

	Vector getVector() {
//		System.out.println((Double) ((JSpinner) inputs.getComponent(0)).getValue());
//		System.out.println((Double) ((JSpinner) inputs.getComponent(1)).getValue());
//		try {
//			System.out.println(((JSpinner) inputs.getComponent(0)).getValue());
//			System.out.println((Double) ((JSpinner) inputs.getComponent(1)).getValue());
//			return new Vector((Double) ((JSpinner) inputs.getComponent(0)).getValue(),
//					(Double) ((JSpinner) inputs.getComponent(1)).getValue());
//		} catch (Exception e) {
//			this.showError();
//			throw new IllegalArgumentException();
//
//		}
		closeButton = new CloseButton(this, this.getParent());
		buttons.add(closeButton, BorderLayout.EAST);
		this.add(buttons);
		this.revalidate();
		this.repaint();
		return this.vector;

	}
}
