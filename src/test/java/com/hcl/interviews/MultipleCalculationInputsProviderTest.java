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

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * MultipleCalculationInputsProvider Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Mar 14, 2018</pre>
 */
public class MultipleCalculationInputsProviderTest {


    List<SimpleCalculatorInput> simpleCalculatorList = new ArrayList<>();

    @Before
    public void before() throws Exception {

        SimpleCalculatorInput simpleCalculatorInput1 = new SimpleCalculatorInput(1,1, Constant.ADD);
        SimpleCalculatorInput simpleCalculatorInput2 = new SimpleCalculatorInput(2,2, Constant.MULTIPLY);
        SimpleCalculatorInput simpleCalculatorInput3 = new SimpleCalculatorInput(3,3, Constant.SUBSTRACT);
        SimpleCalculatorInput simpleCalculatorInput4 = new SimpleCalculatorInput(4,4, Constant.DIVIDE);

        simpleCalculatorList.add(simpleCalculatorInput1);
        simpleCalculatorList.add(simpleCalculatorInput2);
        simpleCalculatorList.add(simpleCalculatorInput3);
        simpleCalculatorList.add(simpleCalculatorInput4);

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: next()
     */
    @Test
    public void testNext() throws Exception {

        MultipleCalculationInputsProvider multipleCalculationInputsProviderMock =
                mock(MultipleCalculationInputsProvider.class) ;
        multipleCalculationInputsProviderMock.setSimpleCalculatorList(simpleCalculatorList);
        SimpleCalculatorInput simpleCalculatorInput = new SimpleCalculatorInput(1,1, Constant.ADD);
        when(multipleCalculationInputsProviderMock.next()).thenReturn(simpleCalculatorInput);


        MultipleCalculationInputsProvider multipleCalculationInputsProvider = new MultipleCalculationInputsProvider();
        multipleCalculationInputsProvider.setSimpleCalculatorList(simpleCalculatorList);

        simpleCalculatorInput= multipleCalculationInputsProvider.next();
        Assert.assertEquals(Constant.DIVIDE,simpleCalculatorInput.getOperator());

        simpleCalculatorInput= multipleCalculationInputsProvider.next();
        Assert.assertEquals(Constant.SUBSTRACT,simpleCalculatorInput.getOperator());

        simpleCalculatorInput= multipleCalculationInputsProvider.next();
        Assert.assertEquals(Constant.MULTIPLY,simpleCalculatorInput.getOperator());

        simpleCalculatorInput= multipleCalculationInputsProvider.next();
        Assert.assertEquals(Constant.ADD,simpleCalculatorInput.getOperator());

        simpleCalculatorInput= multipleCalculationInputsProvider.next();
        Assert.assertEquals(null,simpleCalculatorInput);

    }


} 
