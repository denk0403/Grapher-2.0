import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

import javax.swing.Painter;

public class Vector {

	private Point2D.Double initial = new Point2D.Double(0, 0);
	private Point2D.Double terminal;
	private double direction; // angle of vector in radians with respect to positive x-axis
	private Color color;
	
	// -- Needs Improvement --
	private int arrowSize = 1;

	Vector(double x, double y) {
		this(0,0,x,y);
	}
	
	Vector(double x1, double y1, double x2, double y2) {
		this(new Point2D.Double(x1,y1), new Point2D.Double(x2,y2));
	}

	Vector(Point2D.Double initial, Point2D.Double terminal) {
		this.initial = initial;
		this.terminal = terminal;
		this.direction = Math.atan2(terminal.y - initial.y, terminal.x - initial.x);
		this.color = new Color((int) (201 * Math.random()) + 50, (int) (201 * Math.random()) + 50,
				(int) (201 * Math.random()) + 50);
	}

	public void paint(Graphics2D g, Scale scale) {

		// sets paintbrush to this vector's corresponding characteristics
		g.setColor(this.color);
		g.setStroke(new BasicStroke(2));

		// draws arrow stem
		g.drawLine((int) (initial.x * scale.getSize()), (int) (initial.y * scale.getSize()),
				(int) (terminal.x * scale.getSize()), (int) (terminal.y * scale.getSize()));

		// draws arrow head PI/8 radians from terminal line
		g.drawLine((int) (terminal.x * scale.getSize()), (int) (terminal.y * scale.getSize()),
				(int) ((terminal.x * scale.getSize())
						+ this.arrowSize * scale.getSize() / 3 * Math.cos(this.direction + Math.PI - (Math.PI / 8))),
				(int) ((terminal.y * scale.getSize())
						+ this.arrowSize * scale.getSize() / 3 * Math.sin(this.direction + Math.PI - (Math.PI / 8))));
		g.drawLine((int) (terminal.x * scale.getSize()), (int) (terminal.y * scale.getSize()),
				(int) ((terminal.x * scale.getSize())
						+ this.arrowSize * scale.getSize() / 3 * Math.cos(this.direction + Math.PI + (Math.PI / 8))),
				(int) ((terminal.y * scale.getSize())
						+ this.arrowSize * scale.getSize() / 3 * Math.sin(this.direction + Math.PI + (Math.PI / 8))));
	}

	/* 
	 * -- Needs Improvement --
	 */
	// Changes the size of the arrow head
	public Vector setArrowSize(int newArrowSize) {
		this.arrowSize = newArrowSize;
		return this;
	}

	// Translates the vector's initial point to the origin (0,0)
	// Vector's magnitude and direction do not change
	public Vector translateToOrigin() {
		this.terminal = new Point2D.Double(this.terminal.x - this.initial.x, this.terminal.y - this.initial.y);
		this.initial = new Point2D.Double(0, 0);
		return this;
	}

}
