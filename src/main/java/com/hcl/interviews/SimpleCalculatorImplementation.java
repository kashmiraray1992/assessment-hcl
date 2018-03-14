/**
 * 
 */
package com.hcl.interviews;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.hcl.interviews.inputs.MultipleCalculationInputs;
import com.hcl.interviews.inputs.SimpleCalculatorInput;
import org.apache.log4j.Logger;

import javax.naming.OperationNotSupportedException;

/**
 *
 */
public class SimpleCalculatorImplementation implements SimpleCalculator {

	Logger logger = Logger.getLogger(SimpleCalculatorImplementation.class);
	public double add(int operand1, int operand2) {
		return (double) operand2 + operand1;
	}

	
	public double substract(int operand1, int operand2) {

		return (double) operand1-operand2;
	}

	
	public double multiply(int operand1, int operand2) {

		return (double)  operand1*operand2;
	}

	
	public double divide(int operand1, int operand2) {

        try {
           return (double) operand1/operand2;
        } catch (ArithmeticException e) {
           logger.fatal("Cannot Divide by 0 : " + e.getMessage());
        }
        return 0;
	}

    /**
     *
     * @param multipleCalculationInputs
     * @return
     */
	@Override
	public List<Double> calculateMultipleOperations (
			MultipleCalculationInputs multipleCalculationInputs) {


		List<Double> resultList= new ArrayList<>();
		double result;
		SimpleCalculatorInput simpleCalculatorInput;
		try {
			while (( simpleCalculatorInput=multipleCalculationInputs.next()) != null) {


				switch (simpleCalculatorInput.getOperator()) {
					case '+':
						result=add(simpleCalculatorInput.getOperand1(),simpleCalculatorInput.getOperand2());
						resultList.add(result);
						break;
					case '-':

						result=substract(simpleCalculatorInput.getOperand1(),simpleCalculatorInput.getOperand2());
						resultList.add(result);
						break;
					case '*':

						result=multiply(simpleCalculatorInput.getOperand1(),simpleCalculatorInput.getOperand2());
						resultList.add(result);
						break;
					case '/':

						result=divide(simpleCalculatorInput.getOperand1(),simpleCalculatorInput.getOperand2());
						resultList.add(result);
						break;
					default:
                        logger.fatal("Operation Not Supported Exception; Operator  " +  simpleCalculatorInput.getOperator()+
                        "Is not a standard. Only  + - * / are supported for now");


				}

			}
			 Collections.reverse(resultList);
			return resultList;
		}
		catch ( ArithmeticException e){
            logger.fatal("Operation Not Supported Exception; Operator  " +
                    "Is not a standard. Only  + - * / are supported for now" + e.getMessage());
		}
		return new ArrayList<>();
	}

}
