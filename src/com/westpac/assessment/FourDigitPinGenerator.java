package com.westpac.assessment;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class FourDigitPinGenerator{
    
    private final int BOUND_NUMBER=10000;
    private final int MAX_PADDING=4;
    private final int MAX_PINS=1000;

    public static void main(String[] args) {
        FourDigitPinGenerator pinGenerator = new FourDigitPinGenerator();
        pinGenerator.generateUniquePins().stream().forEach(System.out::println);;
    }

    public List<String> generateUniquePins() {
        Set<Integer> pinsSet = new HashSet<>();
        Random random = new Random();
        while (pinsSet.size() < MAX_PINS) { 
            int pin = random.nextInt(BOUND_NUMBER);
            if(pin>=0){
            	pinsSet.add(pin);
            }            
        }
        return getLeftPaddedPins(pinsSet);
    }
    
    private List<String> getLeftPaddedPins(Set<Integer> pinsSet){
    	List<String> retrunStringPinList = new ArrayList<String>(1000);
    	for(Integer pin : pinsSet) {
    		String strPin = String.valueOf(pin);
    		if((MAX_PADDING - strPin.length()) > 0){
    			StringBuilder sb = new StringBuilder();
    			for(int i = 0; i < (MAX_PADDING - strPin.length()); i++){
    		        sb.append("0");
    		    }    		
    			retrunStringPinList.add(sb.append(strPin).toString());
    		}else {
    			retrunStringPinList.add(strPin);
    		}    		
    	}    				
    	return retrunStringPinList;
    }    
}

