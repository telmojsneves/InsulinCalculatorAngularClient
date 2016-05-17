package pt.dei.springmvcangularjs.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pt.dei.insulin_calculator_server.ws_manager.WebServicesManager;
import pt.dei.springmvcangularjs.models.BidModel;

@Controller
@RequestMapping("/api/v1/bid")
public class BidController {


    @Autowired
    private static WebServicesManager wsServicesManager;

    public BidController() {
    	wsServicesManager = new WebServicesManager();
	}

    @RequestMapping("/")
    public @ResponseBody Integer getBids(@RequestParam Map<String,String> params){
    	
    	BidModel bidObject = new BidModel(params.get("input_a"));

    	if (!bidObject.validate()){
    		return -1;
    	}
    	
    	int finalValue= wsServicesManager.execute(bidObject);
    	
    	
    	//call cenas
    	return finalValue;

    }

    @RequestMapping("/layout")
    public String getMidsPartialPage() {
        return "bid/layout";
    }




}
