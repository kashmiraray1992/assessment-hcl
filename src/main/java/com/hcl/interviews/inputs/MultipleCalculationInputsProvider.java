package com.hcl.interviews.inputs;

import com.hcl.interviews.SimpleCalculator;

import java.util.ArrayList;
import java.util.List;

public class MultipleCalculationInputsProvider implements
		MultipleCalculationInputs {

	List<SimpleCalculatorInput> simpleCalculatorList = new ArrayList<>();
	@Override
	public SimpleCalculatorInput next() {
		// TODO Auto-generated method stub
        SimpleCalculatorInput simpleCalculatorInput;
        if(simpleCalculatorList.size()>=1) {
             simpleCalculatorInput=simpleCalculatorList.get(simpleCalculatorList.size() - 1);
             simpleCalculatorList.remove(simpleCalculatorList.size()-1);
             return simpleCalculatorInput;
        }
        return null;
	}

    public void setSimpleCalculatorList(List<SimpleCalculatorInput> simpleCalculatorList) {
        this.simpleCalculatorList = simpleCalculatorList;
    }


}
