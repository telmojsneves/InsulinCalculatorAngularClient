package pt.dei.insulin_calculator_server;

import pt.dei.insulin_calculator_server.ws_manager.WebServicesManager;

public class ClientLauncher {

	
	private WebServicesManager webServicesManager;  
	
	
	
	public ClientLauncher() {		
		webServicesManager = new WebServicesManager();
	}
	
	public void start(){
		
		//receive response from spring and angular
        
		
		webServicesManager.execute();	

		//TODO Empty parameters for now
		//execute webservices manager and do requests to obtain the response
        	
        	
        //execute voter to choose the result 
        	
	}
		
}
	
	
