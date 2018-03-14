/**
 * 
 */
package com.hcl.interviews;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.hcl.interviews.inputs.MultipleCalculationInputs;
import com.hcl.interviews.inputs.SimpleCalculatorInput;

import javax.naming.OperationNotSupportedException;

/**
 *
 */
public class SimpleCalculatorImplementation implements SimpleCalculator {

	
	public double add(int operand1, int operand2) {
		// TODO Auto-generated method stub
		return operand1+operand2;
	}

	
	public double substract(int operand1, int operand2) {
		// TODO Auto-generated method stub
		return operand1-operand2;
	}

	
	public double multiply(int operand1, int operand2) {
		// TODO Auto-generated method stub
		return operand1*operand2;
	}

	
	public double divide(int operand1, int operand2) {
		// TODO Auto-generated method stub
		return operand1/operand2;
	}

	@Override
	public List<Double> calculateMultipleOperations (
			MultipleCalculationInputs multipleCalculationInputs) {
		// TODO Auto-generated method stub

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
						throw new OperationNotSupportedException();

				}

			}
			 Collections.reverse(resultList);
			return resultList;
		}
		catch (OperationNotSupportedException | ArithmeticException e){
			e.printStackTrace();
		}
		return null;
	}

}
