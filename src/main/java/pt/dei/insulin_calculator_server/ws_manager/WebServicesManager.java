package pt.dei.insulin_calculator_server.ws_manager;

import pt.dei.insulin_calculator_server.voter.Voter;
import pt.dei.insulin_calculator_server.ws_manager.ws_client.ClientManager;
import pt.dei.insulin_calculator_server.ws_manager.ws_pool.ThreadPoolService;
import pt.dei.springmvcangularjs.models.BidModel;
import pt.dei.springmvcangularjs.models.MidsModel;


public class WebServicesManager {

	private ThreadPoolService threadPoolService;
	private Voter voter;

	
	public WebServicesManager() {

		ClientManager clientManager = new ClientManager();
		clientManager.createClientsConnectorsList();
		voter = new Voter();
		
		threadPoolService = new ThreadPoolService(clientManager);
		
	
	}
	
	public int execute(MidsModel midsModel){
		
		threadPoolService.wsResponses(midsModel);
				
		int[] results = threadPoolService.getResultsFromDifferentWS();
		
		if (results.length == 0){
			return -1;
		}
		
		int finalResult = voter.vote(results);
		
		return finalResult;

		
	}
	
	public int execute(BidModel bidModel){
		
		threadPoolService.wsResponses(bidModel);
			
		int[] results = threadPoolService.getResultsFromDifferentWS();
		
		int finalResult = voter.vote(results);
		
		return finalResult;
		
	}
	
	
	
	
	public int execute(){
		
		//receive object to treat 
		
		threadPoolService.wsResponses();
		
		int[] results = threadPoolService.getResultsWSList();
		
		for (int i = 0; i < results.length; i++){
			System.out.println(results[i]);
		}

		System.out.println(results);
		int finalResult = voter.vote(results);
		return finalResult;
		
		
	}
	
	
	
}
