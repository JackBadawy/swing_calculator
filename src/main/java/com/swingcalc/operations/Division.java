package com.swingcalc.operations;

public class Division implements Operation<Float> {
	 @Override
	    public Float apply(Float a, Float b) {
	        if (b == 0) {
	            throw new ArithmeticException("Cannot divide by zero");
	        }
	        return a / b;
	    }
}
