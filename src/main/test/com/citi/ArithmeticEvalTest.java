package com.citi;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArithmeticEvalTest {

	@Test
	public void testArithmeticEval() {

		assertEquals("Expression evaluated correctly ",
				EvalArithmeticExp.evaluateExpression("2 * 3 + 4 * 5"), new Double(
						(2 * 3) + (4 * 5)), 0.0);
		
		assertEquals("Expression evaluated correctly",
				EvalArithmeticExp.evaluateExpression("2+3*3*4/2^4"), new Double( 2 + ((3 * 3 * 4) / Math.pow(2 , 4)) ), 0.0);
		
		
		assertEquals("Expression evaluated correctly",
				EvalArithmeticExp.evaluateExpression("2+36/6-9+5%3"), new Double( 2 + (36/6) - 9 + 5 % 3), 0.0);
		
	}
	
	@Test
	public void testArithmeticExpr(){
		
		//assertTrue("Pattern is valid",)
	}

}
