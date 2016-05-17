package pt.dei.springmvcangularjs.models;

public class Response {

	private int numberOfWebServicesUsed = 0;
	private int[] resultsFromWebServices = {};
	private int finalResult = -1;
	
	public Response() {}
	
	public Response(int numberOfWebServicesUsed, int[] resultsFromWebServices, int finalResult) {
		this.numberOfWebServicesUsed = numberOfWebServicesUsed;
		this.resultsFromWebServices = resultsFromWebServices;
		this.finalResult = finalResult;
	}

	public int getNumberOfWebServicesUsed() {
		return numberOfWebServicesUsed;
	}

	public void setNumberOfWebServicesUsed(int numberOfWebServicesUsed) {
		this.numberOfWebServicesUsed = numberOfWebServicesUsed;
	}

	public int[] getResultsFromWebServices() {
		return resultsFromWebServices;
	}

	public void setResultsFromWebServices(int[] resultsFromWebServices) {
		this.resultsFromWebServices = resultsFromWebServices;
	}

	public int getFinalResult() {
		return finalResult;
	}

	public void setFinalResult(int finalResult) {
		this.finalResult = finalResult;
	}
	
	
}
