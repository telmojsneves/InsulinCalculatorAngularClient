package pt.dei.insulin_calculator_server.ws_manager.ws_client;

import pt.dei.services.qcsID04.InsulinCalculator;
import pt.dei.services.qcsID04.InsulinCalculator_Service;

public class ClientQCSID04 extends ClientRuler{
		
	private InsulinCalculator_Service service;
	private InsulinCalculator proxy;
	
	public ClientQCSID04() {
		service = new InsulinCalculator_Service();
		setProxy(service.getInsulinCalculatorPort());
	
	}

	public InsulinCalculator getProxy() {
		return proxy;
	}

	public void setProxy(InsulinCalculator proxy) {
		this.proxy = proxy;
	}
	

	
}
