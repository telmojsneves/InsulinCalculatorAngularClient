package pt.dei.insulin_calculator_server.ws_manager.ws_client;

import java.util.ArrayList;


public class ClientManager {

	
	private ArrayList<ClientRuler> clientsServices;
	
	public ClientManager() {
		
		clientsServices = new ArrayList<ClientRuler>();
		
	}

	public void createClientsConnectorsList(){
		
		clientsServices.add(new ClientQCS05());
		clientsServices.add(new ClientQCS07());
		clientsServices.add(new ClientQCSID02());
		clientsServices.add(new ClientQCSID03());
		clientsServices.add(new ClientQCSID04());
		
	}
	
	
	public ArrayList<ClientRuler> getClientsServices() {
		return clientsServices;
	}

	public void setClientsServices(ArrayList<ClientRuler> clientsServices) {
		this.clientsServices = clientsServices;
	}
	
}
