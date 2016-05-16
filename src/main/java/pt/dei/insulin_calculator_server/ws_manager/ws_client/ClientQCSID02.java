package pt.dei.insulin_calculator_server.ws_manager.ws_client;

import pt.dei.services.qcsID02.InsulinDoseCalculatorService;
import pt.dei.services.qcsID02.InsulinDoseCalculator;


public class ClientQCSID02 extends ClientRuler{


	private InsulinDoseCalculatorService service;
	private InsulinDoseCalculator proxy;
	
	public ClientQCSID02() {
		
		service = new InsulinDoseCalculatorService();
		setProxy(service.getInsulinDoseCalculatorPort());
	
	}

	public InsulinDoseCalculator getProxy() {
		return proxy;
	}

	public void setProxy(InsulinDoseCalculator proxy) {
		this.proxy = proxy;
	}
	
	
	
}


