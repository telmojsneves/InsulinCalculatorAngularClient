package pt.dei.insulin_calculator_server.ws_manager.ws_client;

import pt.dei.services.qcsID03.InsulinDoseCalculator_Service;
import pt.dei.services.qcsID03.InsulinDoseCalculator;


public class ClientQCSID03 extends ClientRuler{


	private InsulinDoseCalculator_Service service;
	private InsulinDoseCalculator proxy;
	
	public ClientQCSID03() {
		
		service = new InsulinDoseCalculator_Service();
		setProxy(service.getInsulinDoseCalculatorPort());
	
	}

	public InsulinDoseCalculator getProxy() {
		return proxy;
	}

	public void setProxy(InsulinDoseCalculator proxy) {
		this.proxy = proxy;
	}
	
	
	
}


