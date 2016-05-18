package pt.dei.insulin_calculator_server.ws_manager.ws_pool.callable;

import java.util.List;
import java.util.concurrent.Callable;

import pt.dei.insulin_calculator_server.ws_manager.ws_client.ClientQCS05;
import pt.dei.insulin_calculator_server.ws_manager.ws_client.ClientQCS07;
import pt.dei.insulin_calculator_server.ws_manager.ws_client.ClientQCSID02;
import pt.dei.insulin_calculator_server.ws_manager.ws_client.ClientQCSID03;
import pt.dei.insulin_calculator_server.ws_manager.ws_client.ClientQCSID04;
import pt.dei.insulin_calculator_server.ws_manager.ws_client.ClientRuler;
import pt.dei.springmvcangularjs.models.MidpModel;
import pt.dei.springmvcangularjs.models.MidsModel;

public class MealtimeAndPersonalSensitivityToInsulin implements Callable<Integer>{

    private int physicalActivityLevel;
    private List<Integer> physicalActivitySamples;
    private List<Integer> bloodSugarDropSamples;
    private int carbohydrateAmount;
    private int carbohydrateToInsulinRatio;
	private int preMealBloodSugar;
	private int targetBloodSugar;
	private int personalSensitivity;

    private ClientRuler clientWS;

    public MealtimeAndPersonalSensitivityToInsulin(	MidpModel midpModel,
    												MidsModel midsModel,
    												ClientRuler clientWS){

    	this.clientWS = clientWS;
        this.carbohydrateAmount = midsModel.getTotalGramsCarboMeal();
        this.carbohydrateToInsulinRatio = midsModel.getTotalGramsCarboUnit();
        this.preMealBloodSugar = midsModel.getActualBloodSugar();
        this.targetBloodSugar = midsModel.getTargetBloodSugar();
        this.personalSensitivity = midsModel.getIndividualSensitivity();

        this.physicalActivityLevel = midpModel.getPhysicalActivityLevel();
        this.physicalActivitySamples = midpModel.getPhysicalsamples();
        this.bloodSugarDropSamples = midpModel.getBloodsamples();

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

    	int psens = client.getProxy().personalSensitivityToInsulin(	this.physicalActivityLevel,
    																this.physicalActivitySamples,
    																this.bloodSugarDropSamples);

        this.personalSensitivity = psens;

        
        int shot = client.getProxy().mealtimeInsulinDose(	this.carbohydrateAmount,
														this.carbohydrateToInsulinRatio,
												        this.preMealBloodSugar,
												        this.targetBloodSugar,
												        this.personalSensitivity
													);

        return shot;

    }

    private int callWS(ClientQCS07 client){

    	int psens = client.getProxy().personalSensitivityToInsulin(	this.physicalActivityLevel,
																	this.physicalActivitySamples,
																	this.bloodSugarDropSamples);
        
    	this.personalSensitivity = psens;

        int shot = client.getProxy().mealtimeInsulinDose(	this.carbohydrateAmount,
														this.carbohydrateToInsulinRatio,
												        this.preMealBloodSugar,
												        this.targetBloodSugar,
												        this.personalSensitivity
													);

        return shot;

    }

    private int callWS(ClientQCSID02 client){

    	int psens = client.getProxy().personalSensitivityToInsulin(	this.physicalActivityLevel,
																	this.physicalActivitySamples,
																	this.bloodSugarDropSamples);
        this.personalSensitivity = psens;
        
        int shot = client.getProxy().mealtimeInsulinDose(	this.carbohydrateAmount,
														this.carbohydrateToInsulinRatio,
												        this.preMealBloodSugar,
												        this.targetBloodSugar,
												        this.personalSensitivity
													);

        return shot;

    }

    private int callWS(ClientQCSID03 client){

    	int psens = client.getProxy().personalSensitivityToInsulin(	this.physicalActivityLevel,
																	this.physicalActivitySamples,
																	this.bloodSugarDropSamples);
        this.personalSensitivity = psens;
        
    	
        int shot = client.getProxy().mealtimeInsulinDose(	this.carbohydrateAmount,
														this.carbohydrateToInsulinRatio,
												        this.preMealBloodSugar,
												        this.targetBloodSugar,
												        this.personalSensitivity
													);

        return shot;

    }

    private int callWS(ClientQCSID04 client){

    	int psens = client.getProxy().personalSensitivityToInsulin(	this.physicalActivityLevel,
																	this.physicalActivitySamples,
																	this.bloodSugarDropSamples);
        this.personalSensitivity = psens;
        
        
    	
        int shot = client.getProxy().mealtimeInsulinDose(	this.carbohydrateAmount,
														this.carbohydrateToInsulinRatio,
												        this.preMealBloodSugar,
												        this.targetBloodSugar,
												        this.personalSensitivity
													);

        return shot;

    }



}
