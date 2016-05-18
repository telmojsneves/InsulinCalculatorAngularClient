package pt.dei.springmvcangularjs.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pt.dei.insulin_calculator_server.ws_manager.WebServicesManager;
import pt.dei.springmvcangularjs.models.MidpModel;
import pt.dei.springmvcangularjs.models.MidsModel;
import pt.dei.springmvcangularjs.models.Response;

@Controller
@RequestMapping("/api/v1/midp")
public class MidPController {


    @Autowired
    private static WebServicesManager wsServicesManager;

    public MidPController() {
    	wsServicesManager = new WebServicesManager();
	}

    @RequestMapping("/")
    public @ResponseBody Response getMidp(@RequestParam Map<String,String> params){
    	
    	
    	MidsModel midsObject = new MidsModel(params.get("input_a"), params.get("input_b"), params.get("input_c"), params.get("input_d"), "-1000");
    	
       	List<Integer> physicalsamples= treatParams(params, "physical_");
    	List<Integer> bloodsamples = treatParams(params, "drops_");
    	
    	MidpModel midpObject = new MidpModel(convertString(params.get("input_e")), physicalsamples, bloodsamples);    	
    	
    	if (!midsObject.validate()){
    		return new Response();
    	}
    	
    	Response response = wsServicesManager.execute(midpObject, midsObject);
    	
    	return response;

    }

    
    private List<Integer> treatParams(Map<String,String> params,String type){
    	int size = (params.size() - 5) / 2; 
    	
    	List<Integer> list = new ArrayList<Integer>();
    	
    	for (int i = 0;i < size ;i++){
    		list.add(convertString(params.get(type + i)));
    	}
    	
    	return list;
    }
    
    private int convertString(String s){

		try {
			return Integer.parseInt(s);
		}
		catch (NumberFormatException e) {
			return -1;
		}
	}

    @RequestMapping("/layout")
    public String getMidsPartialPage() {
        return "midp/layout";
    }



}


