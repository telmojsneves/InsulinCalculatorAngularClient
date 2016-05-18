package pt.dei.insulin_calculator_server.ws_manager;

import pt.dei.insulin_calculator_server.voter.Voter;
import pt.dei.insulin_calculator_server.ws_manager.ws_client.ClientManager;
import pt.dei.insulin_calculator_server.ws_manager.ws_pool.ThreadPoolService;
import pt.dei.springmvcangularjs.models.BidModel;
import pt.dei.springmvcangularjs.models.MidpModel;
import pt.dei.springmvcangularjs.models.MidsModel;
import pt.dei.springmvcangularjs.models.Response;


public class WebServicesManager {

	private ThreadPoolService threadPoolService;
	

	
	public WebServicesManager() {

		ClientManager clientManager = new ClientManager();
		clientManager.createClientsConnectorsList();
		
		threadPoolService = new ThreadPoolService(clientManager);
		
	
	}
	
	public Response execute(MidsModel midsModel){
		
		threadPoolService.wsResponses(midsModel);
				
		int[] results = threadPoolService.getResultsFromDifferentWS();
		
		if (results.length == 0){
			return new Response();
		}
		
		int finalResult = Voter.vote(results);
		
		return new Response(results.length, results, finalResult);

		
	}
	
	public Response execute(BidModel bidModel){
		
		threadPoolService.wsResponses(bidModel);
			
		int[] results = threadPoolService.getResultsFromDifferentWS();
		
		if (results.length == 0){
			return new Response();
		}
		
		int finalResult = Voter.vote(results);
		
		return new Response(results.length, results, finalResult);
		
	}
	
	
	public Response execute(MidpModel midpModel, MidsModel midsModel){

		System.out.println(midpModel);
		System.out.println(midsModel);
		
		threadPoolService.wsResponses(midpModel, midsModel);
					
		int[] results = threadPoolService.getResultsFromDifferentWS();
		
		if (results.length == 0){
			return new Response();
		}
		
		int finalResult = Voter.vote(results);
		
		return new Response(results.length, results, finalResult);
		

	}
	
	
	
	public int execute(){
		
		//receive object to treat 
		
		threadPoolService.wsResponses();
		
		int[] results = threadPoolService.getResultsWSList();
		
		for (int i = 0; i < results.length; i++){
			System.out.println(results[i]);
		}

		System.out.println(results);
		int finalResult = Voter.vote(results);
		return finalResult;
		
		
	}
	
	
	
}
