import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Plane extends JComponent {

	private ArrayList<Vector> vectors = new ArrayList<>();
	private ArrayList<Function> functions = new ArrayList<>();
	private Scale scale;
	private AffineTransform transform = new AffineTransform(new double[] { 1, 0, 0, -1, 0, 0 });

	public PanelOfInputs inputBoxes;

	public Plane(Scale scale) {
		// TODO Auto-generated constructor stub
		this.scale = scale;
		// this.setPreferredSize(new Dimension(300,300));
		this.inputBoxes = new PanelOfInputs(this);
	}

	public Plane(Scale scale, PanelOfInputs inputBoxes) {
		this.scale = scale;
		this.inputBoxes = inputBoxes;
	}

	public Plane addVector(Vector v) {
		this.vectors.add(v);
		return this;
	}

	public Plane addFunction(Function f) {
		this.functions.add(f);
		return this;
	}

	@Override
	protected void paintComponent(Graphics g) {

		this.updateInputs();
		this.revalidate();

		Graphics2D g2 = (Graphics2D) g;

		AffineTransform original = g2.getTransform();

		AffineTransform center = new AffineTransform(
				new double[] { 1, 0, 0, -1, this.getWidth() / 2, this.getHeight() / 2 });
		center.concatenate(original);

		// converts image to standard coordinate plane centered at the center of the
		// window
		g2.setTransform(center);

		// draws standard grid
		g2.setColor(Color.BLACK);
		for (int i = -100; i <= 100; i++) {
			if (i == 0) {
				g2.setStroke(new BasicStroke(2));
				g2.drawLine(-100000, i * scale.getSize(), 100000, i * scale.getSize());
				g2.drawLine(i * scale.getSize(), -100000, i * scale.getSize(), 100000);
			} else {
				g2.setStroke(new BasicStroke(1));
				g2.drawLine(-100000, i * scale.getSize(), 100000, i * scale.getSize());
				g2.drawLine(i * scale.getSize(), -100000, i * scale.getSize(), 100000);
			}
		}

		// converts image to whatever linear transformation is applied on this
		this.centerAtFrame();
		g2.setTransform(center);

		// draw all vectors
		for (Vector v : this.vectors) {
			v.paint(g2, this.scale);
		}

		// plots all functions
		for (Function f : this.functions) {
			f.paint(g2, this.scale, 0, 0);
		}

	}

	private void updateInputs() {
		vectors = new ArrayList<>();
		for (Component inputBox : inputBoxes.getComponents()) {
			try {
				if (inputBox instanceof VectorBox) {
					vectors.add(((VectorBox) inputBox).getVector());
				}
			} catch (Exception e) {
				continue;
			}

		}

	}

	Plane centerAtFrame() {

		double[] matrix = new double[6];
		this.transform.getMatrix(matrix);
		matrix[4] = this.getWidth() / 2;
		matrix[5] = this.getHeight() / 2;
		this.transform = new AffineTransform(matrix);
		return this;
	}

}
