package com.swingcalc.operations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class OperationsTests {
		@Test
		public void testOperationImplementationTest() {
			Operation<Float> addition = new Addition();
			assertEquals(3, addition.apply(2.0f, 1.0f), 0.0001);
			Operation<Float> subtraction = new Subtraction();
			assertEquals(3, subtraction.apply(5.0f, 2.0f), 0.0001);
			Operation<Float> multiplication = new Multiplication();
			assertEquals(9, multiplication.apply(3.0f, 3.0f), 0.0001);
			Operation<Float> division = new Division();
			assertEquals(3, division.apply(9.0f, 3.0f), 0.0001);
			Operation<Float> sqr = new Sqr();
			assertEquals(9, sqr.apply(3.0f, 3.0f), 0.0001);
			Operation<Float> sqrRoot = new SqrRoot();
			assertEquals(3, sqrRoot.apply(0.0f, 9.0f), 0.0001);
		}
		@Test
		public void zeroOrNullRuntimeExceptionTest() {
			//zeroOrNullRuntimeExceptionTest
			//prime number check
		}
		
	}