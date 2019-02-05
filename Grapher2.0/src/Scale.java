public class Scale {

	private int size;
	
	Scale(int size) {
		this.size = size;
	}
	
	Scale(Scale scale) {
		this.size = scale.getSize();
	}
	
	int getSize() {
		return this.size;
	}
	
	void setSize(int size) {
		this.size = size;
	}
	
	void setSize(Scale scale) {
		this.size = scale.getSize();
	}
	
}
