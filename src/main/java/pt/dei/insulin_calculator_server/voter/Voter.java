package pt.dei.insulin_calculator_server.voter;

import java.util.HashMap;
import java.util.Map;

public class Voter {
	
	private static final int MAX_RESULTS = 300;
	
	
	public static int vote(int[] results) {
		int[] frequencies = Voter.calcFrequenciesBasedInStandardDeviation(results);
		int finalResult = Voter.getAbsolutMaximum(frequencies, results.length);
		System.out.println("Result: " + finalResult);
		return finalResult;
	}
	
	/*
	public static int vote(int[] results) {
		Map<Integer, Integer> frequencies = Voter.calcFrequenciesBasedInStandardDeviation(results);
		int finalResult = Voter.getAbsolutMaximum(frequencies, results.length);
		System.out.println("Result: " + finalResult);
		return finalResult;
	}
	*/
	
	private static int[] calcFrequenciesBasedInStandardDeviation(int[] wsResults) {
		int[] frequencies = new int[MAX_RESULTS];
		int standardDeviantionValue = 1;
		
		for(int i = 0; i < wsResults.length; i++) {
			if(wsResults[i] >= 0)
				frequencies[wsResults[i]]++;
		}
		
		for(int i = 0; i < wsResults.length; i++) {
			int result = wsResults[i];
			
			if(result >= 0) {
				int resultMinusSD = result - standardDeviantionValue;
				if(resultMinusSD >= 0 && frequencies[resultMinusSD] > 0)
					frequencies[resultMinusSD]++;
				
				int resultPlusSD = result + standardDeviantionValue;
				if(resultPlusSD < MAX_RESULTS && frequencies[resultPlusSD] > 0)
					frequencies[resultPlusSD]++;
			}
		}
		
		return frequencies;
	}
	
	/*
	private static Map<Integer, Integer> calcFrequenciesBasedInStandardDeviation(int[] wsResults) {
		Map<Integer, Integer> frequencies = new HashMap<Integer, Integer>();
		int standardDeviantionValue = 1;
		
		// popula o HashMap com os valores que foram retornados pelos WS, criando uma entrada para cada valor único
		for(int i=0; i<wsResults.length; i++) {
			if(!frequencies.containsKey(wsResults[i]))
				frequencies.put(wsResults[i], 0);
		}
		
		// calcula valores baseados no desvio padrão, e incrementa os seus contadores se forem valores retornados pelos WS
		for(int i=0; i<wsResults.length; i++) {
			int result = wsResults[i];
			int currentCounterValue = frequencies.get(result) + 1;
			frequencies.replace(result, currentCounterValue);
			
			int resultMinusSD = result - standardDeviantionValue;
			if(frequencies.containsKey(resultMinusSD)) {
				currentCounterValue = frequencies.get(resultMinusSD) + 1;
				frequencies.replace(resultMinusSD, currentCounterValue);
			}
			
			int resultPlusSD = result + standardDeviantionValue;
			if(frequencies.containsKey(resultPlusSD)) {
				currentCounterValue = frequencies.get(resultPlusSD) + 1;
				frequencies.replace(resultPlusSD, currentCounterValue);
			}
		}
		
		return frequencies;
	}
	*/
	
	private static int getAbsolutMaximum(int[] frequencies, int nResults) {
		int resultWithMaximumAbsolutFrequency = -1;
		int frequencyOfTheResultWithMaximumAbsolutFrequency = 0;
		
		for(int i = 0; i < frequencies.length; i++) {
			if(frequencies[i] > frequencyOfTheResultWithMaximumAbsolutFrequency) {
				frequencyOfTheResultWithMaximumAbsolutFrequency = frequencies[i];
				resultWithMaximumAbsolutFrequency = i;
			}
		}
		
		int absoluteMajorityLimit = (int) (Math.floor(nResults/2) + 1);
		
		if(resultWithMaximumAbsolutFrequency > -1 && frequencyOfTheResultWithMaximumAbsolutFrequency >= absoluteMajorityLimit)
			return resultWithMaximumAbsolutFrequency;
		else return -1;
	}
	
	/*
	private static int getAbsolutMaximum(Map<Integer, Integer> frequencies, int nResults) {
		boolean absolutMaximumFound = false;
		int absolutMaximumResult = -1;
		int maxAbsolutMaximumCounter = -1;
		
		for(int k : frequencies.keySet()) {
			int c = frequencies.get(k);
			
			if(maxAbsolutMaximumCounter < c) {
				maxAbsolutMaximumCounter = c;
				absolutMaximumFound = true;
				absolutMaximumResult = k;
			}
			else if(maxAbsolutMaximumCounter == c) {
				absolutMaximumFound = false;
			}
		}
		
		int absoluteMajorityLimit = (int) (Math.floor(nResults/2) + 1);
		
		if(absolutMaximumFound && maxAbsolutMaximumCounter >= absoluteMajorityLimit)
			return absolutMaximumResult;
		else
			return -1;
	}
	*/
	
}
