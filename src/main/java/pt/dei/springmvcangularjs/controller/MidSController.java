package pt.dei.springmvcangularjs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pt.dei.insulin_calculator_server.ws_manager.WebServicesManager;
import pt.dei.springmvcangularjs.service.CarService;

@Controller
@RequestMapping("/api/v1/mids")
public class MidSController {

	
    @Autowired
    private CarService carService;
    private static WebServicesManager wsServicesManager;
    
    public MidSController() {
    	wsServicesManager = new WebServicesManager();
	}
	
    @RequestMapping("/")
    public @ResponseBody Integer getMids(){
    	
    	return 1;
    	
    }

	
	
	
}


