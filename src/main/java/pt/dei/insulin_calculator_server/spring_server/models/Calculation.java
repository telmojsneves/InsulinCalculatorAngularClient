package pt.dei.insulin_calculator_server.spring_server.models;

public class Calculation {

	private int result = -1;

	public Calculation(int result) {
		super();
		this.setResult(result);
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
}
