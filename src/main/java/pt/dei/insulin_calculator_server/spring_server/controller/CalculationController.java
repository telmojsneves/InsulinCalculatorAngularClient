package pt.dei.insulin_calculator_server.spring_server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pt.dei.insulin_calculator_server.spring_server.models.Calculation;

@RestController
public class CalculationController {
	
	@RequestMapping("/api/v1/mids")
	public Calculation calcMealtimeInsulinDoseStandart(
			@RequestParam(value="value", defaultValue="1") int value) {
		int i = 10;
		Calculation calculation = new Calculation(i+value);
		return calculation;
	}
	
	@RequestMapping("/api/v1/midp")
	public Calculation calcMealtimeInsulinDosePersonal(
			@RequestParam(value="value", defaultValue="1") int value) {
		int i = 20;
		Calculation calculation = new Calculation(i+value);
		return calculation;
	}
	
	@RequestMapping("/api/v1/bid")
	public Calculation calcBackgroundInsulinDose(
			@RequestParam(value="value", defaultValue="1") int value) {
		int i = 30;
		Calculation calculation = new Calculation(i+value);
		return calculation;
	}
}
