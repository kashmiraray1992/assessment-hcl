package com.hcl.interviews.inputs;

import com.hcl.interviews.SimpleCalculatorImplementation;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class MultipleCalculationInputsProvider implements
		MultipleCalculationInputs {

    Logger logger = Logger.getLogger(MultipleCalculationInputsProvider.class);
    List<SimpleCalculatorInput> simpleCalculatorList = new ArrayList<>();

    /**
     *
     * @return
     * This mehod implements LIFO Pattern for getting objects.
     */
	@Override
	public SimpleCalculatorInput next() {
        SimpleCalculatorInput simpleCalculatorInput;
        if(simpleCalculatorList.isEmpty()) {
             simpleCalculatorInput=simpleCalculatorList.get(simpleCalculatorList.size() - 1);
             simpleCalculatorList.remove(simpleCalculatorList.size()-1);
             if(logger.isInfoEnabled())
                 logger.info("Popping element from List");
             return simpleCalculatorInput;
        }
        return null;
	}

    public void setSimpleCalculatorList(List<SimpleCalculatorInput> simpleCalculatorList) {
        this.simpleCalculatorList = simpleCalculatorList;
    }


}
