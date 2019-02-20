import javax.swing.JLabel;
import javax.swing.JPanel;

abstract class InputBox extends JPanel {

	JLabel errorMessage = new JLabel("Invalid Input!");
	Plane plane;
	
	public InputBox(Plane plane) {
		this.plane = plane;
	}
	
	void hideError() {
		errorMessage.setVisible(false);
	}
	
	void showError() {
		errorMessage.setVisible(true);
	}
	
}
