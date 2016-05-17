package pt.dei.springmvcangularjs.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pt.dei.insulin_calculator_server.ws_manager.WebServicesManager;
import pt.dei.springmvcangularjs.models.BidModel;
import pt.dei.springmvcangularjs.models.Response;

@Controller
@RequestMapping("/api/v1/bid")
public class BidController {


    @Autowired
    private static WebServicesManager wsServicesManager;

    public BidController() {
    	wsServicesManager = new WebServicesManager();
	}

    @RequestMapping("/")
    public @ResponseBody Response getBids(@RequestParam Map<String,String> params){
    	
    	BidModel bidObject = new BidModel(params.get("input_a"));

    	if (!bidObject.validate()){
    		return new Response();
    	}
    	
    	Response response= wsServicesManager.execute(bidObject);
    	
    	
    	//call cenas
    	return response;

    }

    @RequestMapping("/layout")
    public String getMidsPartialPage() {
        return "bid/layout";
    }




}
