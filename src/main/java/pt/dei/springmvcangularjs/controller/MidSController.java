package pt.dei.springmvcangularjs.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pt.dei.insulin_calculator_server.ws_manager.WebServicesManager;
import pt.dei.springmvcangularjs.models.MidsModel;
import pt.dei.springmvcangularjs.service.CarService;

@Controller
@RequestMapping("/api/v1/mids")
public class MidSController {


    @Autowired
    private static WebServicesManager wsServicesManager;

    public MidSController() {
    	wsServicesManager = new WebServicesManager();
	}

    @RequestMapping("/")
    public @ResponseBody Integer getMids(@RequestParam Map<String,String> params){

    	MidsModel midsObject = new MidsModel(params.get("input_a"), params.get("input_b"), params.get("input_c"), params.get("input_d"), params.get("input_e"));

    	if (!midsObject.validate()){
    		return -1;
    	}
    	
    	System.out.println(midsObject);
    	System.out.println(midsObject.toString());
    	

    	return 1;

    }

    @RequestMapping("/layout")
    public String getMidsPartialPage() {
        return "mids/layout";
    }




}
