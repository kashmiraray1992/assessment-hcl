package com.hcl.interviews;

import com.hcl.interviews.inputs.MultipleCalculationInputsProvider;
import com.hcl.interviews.inputs.SimpleCalculatorInput;
import com.hcl.interviews.util.Constant;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class SimpleCalculatorTest {


    List<SimpleCalculatorInput> simpleCalculatorList = new ArrayList<>();
    MultipleCalculationInputsProvider multipleCalculationInputsProvider ;



    @Before
	public void setUp() throws Exception {

        SimpleCalculatorInput simpleCalculatorInput1 = new SimpleCalculatorInput(1,1, Constant.ADD);
        SimpleCalculatorInput simpleCalculatorInput2 = new SimpleCalculatorInput(2,2, Constant.MULTIPLY);
        SimpleCalculatorInput simpleCalculatorInput3 = new SimpleCalculatorInput(3,3, Constant.SUBSTRACT);
        SimpleCalculatorInput simpleCalculatorInput4 = new SimpleCalculatorInput(4,4, Constant.DIVIDE);

        simpleCalculatorList.add(simpleCalculatorInput1);
        simpleCalculatorList.add(simpleCalculatorInput2);
        simpleCalculatorList.add(simpleCalculatorInput3);
        simpleCalculatorList.add(simpleCalculatorInput4);

        multipleCalculationInputsProvider= new MultipleCalculationInputsProvider();
        multipleCalculationInputsProvider.setSimpleCalculatorList(simpleCalculatorList);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
        SimpleCalculatorImplementation simpleCalculatorImplementation = new SimpleCalculatorImplementation();

        Double result =simpleCalculatorImplementation.
                add(simpleCalculatorList.get(0).getOperand1(),simpleCalculatorList.get(0).
                        getOperand2());

        Assert.assertEquals((Double)2.0,result);
	}

	@Test
	public void testSubstract() {

        SimpleCalculatorImplementation simpleCalculatorImplementation = new SimpleCalculatorImplementation();

        Double result =simpleCalculatorImplementation.
                substract(simpleCalculatorList.get(2).getOperand1(),simpleCalculatorList.get(2).
                        getOperand2());
        Assert.assertEquals((Double)0.0,result);
	}

	@Test
	public void testMultiply() {

        SimpleCalculatorImplementation simpleCalculatorImplementation = new SimpleCalculatorImplementation();

        Double result =simpleCalculatorImplementation.
                multiply(simpleCalculatorList.get(1).getOperand1(),simpleCalculatorList.get(1).
                        getOperand2());

        Assert.assertEquals((Double)4.0,result);
	}

	@Test
	public void testDivide() {

        SimpleCalculatorImplementation simpleCalculatorImplementation = new SimpleCalculatorImplementation();

        Double result =simpleCalculatorImplementation.
                divide(simpleCalculatorList.get(3).getOperand1(),simpleCalculatorList.get(3).
                        getOperand2());
        Assert.assertEquals((Double)1.0,result);
	}

	@Test
	public void testCalculateMultipleOperations() {
        int simpleCalculatorListSize= simpleCalculatorList.size();
        SimpleCalculatorImplementation simpleCalculatorImplementation = new SimpleCalculatorImplementation();
        List<Double> resultsList=simpleCalculatorImplementation.
                calculateMultipleOperations(multipleCalculationInputsProvider);

        Assert.assertEquals(simpleCalculatorListSize,resultsList.size());
        Assert.assertEquals((Double)2.0,resultsList.get(0));
        Assert.assertEquals((Double)4.0,resultsList.get(1));
        Assert.assertEquals((Double)0.0,resultsList.get(2));
        Assert.assertEquals((Double)1.0,resultsList.get(3));


	}

}
