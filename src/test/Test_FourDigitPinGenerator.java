package test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.westpac.assessment.FourDigitPinGenerator;

public class Test_FourDigitPinGenerator {

	private FourDigitPinGenerator fourDigitPinGenerator = new FourDigitPinGenerator(); 
	
	@Test
	void testGeneratedPinsReturnsNotNullSet() {		
		List<String> pinsList = fourDigitPinGenerator.generateUniquePins(); 
        Assert.assertNotNull(pinsList);
    }
	
	@Test
	void testGeneratedPinsListSizeIsOneThousand() {
		List<String> pinsList = fourDigitPinGenerator.generateUniquePins(); 
        Assert.assertEquals(1000, pinsList.size());
    }
	
	@Test
	void testGeneratedPinsList_element_Is_unique_OneThousand() {
		List<String> pinsList = fourDigitPinGenerator.generateUniquePins();
		Set<Integer> pinsSet = new HashSet<Integer>(0);
		for(String strNumber : pinsList){
			pinsSet.add(Integer.valueOf(strNumber));
		}		
        Assert.assertEquals(1000, pinsSet.size());
    }
}
