package pt.dei.insulin_calculator_server.ws_manager.ws_pool;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import pt.dei.insulin_calculator_server.ws_manager.ws_client.ClientManager;
import pt.dei.insulin_calculator_server.ws_manager.ws_client.ClientRuler;
import pt.dei.insulin_calculator_server.ws_manager.ws_pool.callable.BackgroundInsulinDose;
import pt.dei.insulin_calculator_server.ws_manager.ws_pool.callable.MealtimeInsulinDose;
import pt.dei.springmvcangularjs.models.BidModel;
import pt.dei.springmvcangularjs.models.MidsModel;



public class ThreadPoolService {

	
	private static final int NUMBEROFTHREADS = 10;
	
    private ClientManager clientManager;
    private ExecutorService executorService;
    private List<Future<Integer>> resultsWSList;
    private Set<Callable<Integer>> callables;
    private ArrayList<ClientRuler> clients;
    private int clientsSize;
    private long timeout = 2000L;
    
    public ThreadPoolService(ClientManager clientManager){

    	this.clientManager = clientManager;
    	this.clients = clientManager.getClientsServices();
    	this.clientsSize = this.clients.size();
    	
        executorService = Executors.newFixedThreadPool(NUMBEROFTHREADS);
    }
    
    private void executeWSs(Set<Callable<Integer>> callablesWS){
    	
    	boolean serviceFailed = false;
    	
    	resultsWSList = new ArrayList<Future<Integer>>();
    	
        try {
			resultsWSList = executorService.invokeAll(callablesWS, timeout, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			serviceFailed = true;
		}
        
        if (serviceFailed){
        	System.out.println("At least one webservice failed... will try again");
        }
        
    }
    
    public void wsResponses(MidsModel midsModel){
    	
    	Set<Callable<Integer>> callablesWS = new HashSet<Callable<Integer>>();
    	
    	
    	this.clientsSize = clients.size();
        //if number of ws is even then restrict to be odd
        //we assume that there are always more than 3 web services 
        if ((clientsSize & 1) == 0) { 
        	clientsSize = clientsSize - 1;
        } 
    	
        for (int i = 0; i < clientsSize; i++){
        
        	callablesWS.add(new MealtimeInsulinDose(midsModel,clients.get(i)));
        
        }
        
        executeWSs(callablesWS);
        
        
    	
    }
    
    
    
    
    
    public void wsResponses(BidModel bidModel){
    	
    	Set<Callable<Integer>> callablesWS = new HashSet<Callable<Integer>>();
    	
    	
    	this.clientsSize = clients.size();
        //if number of ws is even then restrict to be odd
        //we assume that there are always more than 3 web services 
        if ((clientsSize & 1) == 0) { 
        	clientsSize = clientsSize - 1;
        } 
    	
        for (int i = 0; i < clientsSize; i++){
        
        	callables.add(new BackgroundInsulinDose(bidModel, clients.get(i)));
        
        }
        
        executeWSs(callablesWS);
    	
    }
    
    public int[] getResultsFromDifferentWS() {
    	
    	boolean isWaiting= true;
    	int[] results = new int[resultsWSList.size()];
    	
        for (int i = 0; i < resultsWSList.size(); i++) {
    		while (isWaiting){
            	if (resultsWSList.get(i).isDone()) {
                    try {
                    	isWaiting = false;
    					results[i] = resultsWSList.get(i).get();
    				} catch (InterruptedException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				} catch (ExecutionException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
            	}
    		}
    		isWaiting = true;
    		
        }

        return results;
	}
    
    
    public void wsResponses(){
    	
    	
    	execute();
    	
    	
    }
    

    private void execute(){

    	resultsWSList = new ArrayList<Future<Integer>>();
    	
    	int i = 0;
    	
        //callables = new HashSet<Callable<Integer>>();
        
        clientsSize = clients.size();
        
        //if number of ws is even then restrict to be odd
        //we assume that there are always more than 3 web services 
        if ((clientsSize & 1) == 0) { 
        	clientsSize = clientsSize - 1;
        } 
        
        Future<Integer> result;
        
        for (; i < clientsSize; i++){
        	
        	result = this.executorService.submit(new MealtimeInsulinDose(null,clients.get(i)));
        	resultsWSList.add(result);
        	
/*        	result = this.executorService.submit(new BackgroundInsulinDose(40,clients.get(i)));
        	resultsWSList.add(result);
        	result = this.executorService.submit(new PersonalSensitivityToInsulin(12, new ArrayList<Integer>(), new ArrayList<>(), clients.get(i)));      	
        	resultsWSList.add(result);
*/
        	
        }
        
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
        i = 0;
        boolean timeout = true;
        while (i < resultsWSList.size() && timeout){
        	
        	while (timeout){
        		
        		if (resultsWSList.get(i).isDone()){
        			System.out.println("dammit IS DONE");
        			timeout=false;
        		}
        		
        	}
        	
        	
        }
        

/*        
        for (int i = 0 ; i < resultsWSList.size(); i++){
        	
        	try {
				System.out.println(resultsWSList.get(i).get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
        }
*/
    }

	public void shutdown_executionService(){
        executorService.shutdown();
    }
	
    public int[] getResultsWSList() {
    	
    	int[] results = new int[resultsWSList.size()];
    	
        for (int i = 0; i < resultsWSList.size(); i++) {
    		if (resultsWSList.get(i).isDone()) {
                try {
					results[i] = resultsWSList.get(i).get();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
            }
    		else{
    			System.out.println("DAMMIT");
    			
    		}
        }

        return results;
	}


	public void setResultsWSList(List<Future<Integer>> resultsWSList) {
		this.resultsWSList = resultsWSList;
	}


}
