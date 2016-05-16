package pt.dei.insulin_calculator_server.ws_manager.ws_client;

import pt.dei.services.qcs07.InsulinCalculatorService;
import pt.dei.services.qcs07.InsulinCalculator;

public class ClientQCS07 extends ClientRuler{

	private InsulinCalculatorService service;
	private InsulinCalculator proxy;
	
	
	public ClientQCS07() {
		
		service = new InsulinCalculatorService();
		setProxy(service.getInsulinCalculatorPort());
		
		
		
	}


	public InsulinCalculator getProxy() {
		return proxy;
	}


	public void setProxy(InsulinCalculator proxy) {
		this.proxy = proxy;
	}
	
	
	
	
	
}
