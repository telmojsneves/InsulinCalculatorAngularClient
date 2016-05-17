package pt.dei.springmvcangularjs.models;


public class MidpModel {

	private int totalGramsCarboMeal;
	private int totalGramsCarboUnit;
	private int actualBloodSugar;
	private int targetBloodSugar;
	private int totalActivityLevel;

	public MidpModel(String totalGramsCarboMeal,
				String totalGramsCarboUnit,
				String actualBloodSugar,
				String targetBloodSugar,
				String totalActivityLevel
				) {



		this.setTotalGramsCarboMeal(convertString(totalGramsCarboMeal));
		this.setTotalGramsCarboUnit(convertString(totalGramsCarboUnit));
		this.setActualBloodSugar(convertString(actualBloodSugar));
		this.setTargetBloodSugar(convertString(targetBloodSugar));
		this.settotalActivityLevel(convertString(totalActivityLevel));

	}

	public String toString(){
		return
			" totalGramsCarboMeal = " + this.totalGramsCarboMeal +
			" totalGramsCarboUnit = " + this.totalGramsCarboUnit +
			" actualBloodSugar = " + this.actualBloodSugar +
			" targetBloodSugar = " + this.targetBloodSugar +
			" totalActivityLevel = " + this.totalActivityLevel;
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
		if (	this.totalGramsCarboMeal ==-1  ||
				this.totalGramsCarboUnit ==-1  ||
				this.actualBloodSugar ==-1  ||
				this.targetBloodSugar ==-1  ||
				this.totalActivityLevel ==-1 ){
			return false;
		}
		return true;
	}


	public int getTotalGramsCarboMeal() {
		return totalGramsCarboMeal;
	}

	public void setTotalGramsCarboMeal(int totalGramsCarboMeal) {
		this.totalGramsCarboMeal = totalGramsCarboMeal;
	}

	public int getTotalGramsCarboUnit() {
		return totalGramsCarboUnit;
	}

	public void setTotalGramsCarboUnit(int totalGramsCarboUnit) {
		this.totalGramsCarboUnit = totalGramsCarboUnit;
	}

	public int getActualBloodSugar() {
		return actualBloodSugar;
	}

	public void setActualBloodSugar(int actualBloodSugar) {
		this.actualBloodSugar = actualBloodSugar;
	}

	public int getTargetBloodSugar() {
		return targetBloodSugar;
	}

	public void setTargetBloodSugar(int targetBloodSugar) {
		this.targetBloodSugar = targetBloodSugar;
	}

	public int gettotalActivityLevel() {
		return totalActivityLevel;
	}

	public void settotalActivityLevel(int totalActivityLevel) {
		this.totalActivityLevel = totalActivityLevel;
	}

}
