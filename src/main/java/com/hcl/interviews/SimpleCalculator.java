/**
 * 
 */
package com.hcl.interviews;

import java.util.List;

import com.hcl.interviews.inputs.MultipleCalculationInputs;


/**
 * @author HCL
 *
 */
public interface SimpleCalculator {
	public double add(int operand1, int operand2);
	public double substract(int operand1, int operand2);
	public double multiply(int operand1, int operand2);
	public double divide(int operand1, int operand2);
	public List<Double> calculateMultipleOperations(MultipleCalculationInputs multipleCalculationInputs);


}
