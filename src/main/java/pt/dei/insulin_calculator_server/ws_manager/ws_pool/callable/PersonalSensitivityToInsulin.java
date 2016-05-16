package pt.dei.insulin_calculator_server.ws_manager.ws_pool.callable;

import java.util.List;
import java.util.concurrent.Callable;

import pt.dei.insulin_calculator_server.ws_manager.ws_client.ClientQCS05;
import pt.dei.insulin_calculator_server.ws_manager.ws_client.ClientQCS07;
import pt.dei.insulin_calculator_server.ws_manager.ws_client.ClientQCSID02;
import pt.dei.insulin_calculator_server.ws_manager.ws_client.ClientQCSID03;
import pt.dei.insulin_calculator_server.ws_manager.ws_client.ClientQCSID04;
import pt.dei.insulin_calculator_server.ws_manager.ws_client.ClientRuler;

public class PersonalSensitivityToInsulin implements Callable<Integer>{

    private int physicalActivityLevel;
    private List<Integer> physicalActivitySamples;
    private List<Integer> bloodSugarDropSamples;
    private ClientRuler clientWS;

    public PersonalSensitivityToInsulin(int physicalActivityLevel,
                                        List<Integer> physicalActivitySamples,
                                        List<Integer> bloodSugarDropSamples,
                                        ClientRuler clientWS){
    	
    	this.clientWS = clientWS;
        this.physicalActivityLevel = physicalActivityLevel;
        this.physicalActivitySamples = physicalActivitySamples;
        this.bloodSugarDropSamples = bloodSugarDropSamples;

    }
    
    
    public Integer call() throws Exception{
        //call web service
    	int shot = checkClientType();
    	return shot;
     
    }

    private int checkClientType(){

    	if (ClientQCS05.class.isInstance(clientWS) == true){
    		ClientQCS05 client = (ClientQCS05) clientWS;
    		return callWS(client);
    	}
    
    	else if (ClientQCS07.class.isInstance(clientWS) == true){
    		ClientQCS07 client = (ClientQCS07) clientWS;
    		return callWS(client);
    	}
    	
    	else if (ClientQCSID02.class.isInstance(clientWS) == true){
    		ClientQCSID02 client = (ClientQCSID02) clientWS;
    		return callWS(client);
    	}
    	
    	else if (ClientQCSID03.class.isInstance(clientWS) == true){
    		ClientQCSID03 client = (ClientQCSID03) clientWS;
    		return callWS(client);
    	}
    	else if (ClientQCSID04.class.isInstance(clientWS) == true){
    		ClientQCSID04 client = (ClientQCSID04) clientWS;
    		return callWS(client);
    	}
    	
    	else 
    		return -1;
    }
    
    
    private int callWS(ClientQCS05 client){
    	
    	int shot = client.getProxy().personalSensitivityToInsulin(	this.physicalActivityLevel, 
    																this.physicalActivitySamples,
    																this.bloodSugarDropSamples);
        return shot;
    
    }

    private int callWS(ClientQCS07 client){
    	
    	int shot = client.getProxy().personalSensitivityToInsulin(	this.physicalActivityLevel, 
																	this.physicalActivitySamples,
																	this.bloodSugarDropSamples);
    	return shot;        
    
    }

    private int callWS(ClientQCSID02 client){
    	
    	int shot = client.getProxy().personalSensitivityToInsulin(	this.physicalActivityLevel, 
																	this.physicalActivitySamples,
																	this.bloodSugarDropSamples);
    	return shot;
    
    }

    private int callWS(ClientQCSID03 client){
    
    	int shot = client.getProxy().personalSensitivityToInsulin(	this.physicalActivityLevel, 
																	this.physicalActivitySamples,
																	this.bloodSugarDropSamples);
    	return shot;
        
    }

    private int callWS(ClientQCSID04 client){
        
    	int shot = client.getProxy().personalSensitivityToInsulin(	this.physicalActivityLevel, 
																	this.physicalActivitySamples,
																	this.bloodSugarDropSamples);
    	return shot;
        
    }
    
    

}
