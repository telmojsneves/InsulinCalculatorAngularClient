package pt.dei.springmvcangularjs.models;

import java.util.List;

public class MidpModel {


	private List<Integer> physicalsamples;
	private List<Integer> bloodsamples;
	private int physicalActivityLevel;
	
	public MidpModel(int physicalActivityLevel,
				List<Integer> physicalsamples,
				List<Integer> bloodsamples
				) {
					this.setPhysicalActivityLevel(physicalActivityLevel);
					this.setPhysicalsamples(physicalsamples);
					this.setBloodsamples(bloodsamples);

	}

	public String toString(){
		return
			" physicalActivityLevel = " + this.physicalActivityLevel +
			" physicalsamples = " + this.physicalsamples.toString() +
			" bloodsamples = " + this.bloodsamples.toString();
	}
	

	public List<Integer> getPhysicalsamples() {
		return physicalsamples;
	}


	public void setPhysicalsamples(List<Integer> physicalsamples) {
		this.physicalsamples = physicalsamples;
	}


	public List<Integer> getBloodsamples() {
		return bloodsamples;
	}


	public void setBloodsamples(List<Integer> bloodsamples) {
		this.bloodsamples = bloodsamples;
	}


	public int getPhysicalActivityLevel() {
		return physicalActivityLevel;
	}


	public void setPhysicalActivityLevel(int physicalActivityLevel) {
		this.physicalActivityLevel = physicalActivityLevel;
	}


}
