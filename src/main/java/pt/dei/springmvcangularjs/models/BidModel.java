package pt.dei.springmvcangularjs.models;


public class BidModel {

	private int weight;

	public BidModel(String weight) {

		this.setWeight(convertString(weight));
		
	}

	public String toString(){
		return " Weight = " + this.getWeight();
	}

	public int convertString(String s){

		try {
			return Integer.parseInt(s);
		}
		catch (NumberFormatException e) {
			return -1;
		}
	}

	public boolean validate(){
		if (this.weight == -1){
			return false;
		}
		return true;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}



}
