package pt.dei.insulin_calculator_server.ws_manager.ws_client;

import pt.dei.services.qcs05.InsulinDoseCalculatorInterface;
import pt.dei.services.qcs05.InsulinDoseCalculatorService;


public class ClientQCS05 extends ClientRuler{


	private InsulinDoseCalculatorService service;
	private InsulinDoseCalculatorInterface proxy;
	
	public ClientQCS05() {
		
		service = new InsulinDoseCalculatorService();
		setProxy(service.getInsulinDoseCalculatorPort());
	
	}

	public InsulinDoseCalculatorInterface getProxy() {
		return proxy;
	}

	public void setProxy(InsulinDoseCalculatorInterface proxy) {
		this.proxy = proxy;
	}
	
	
	
}


