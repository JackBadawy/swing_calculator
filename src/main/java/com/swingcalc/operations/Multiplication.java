package com.swingcalc.operations;

public class Multiplication implements Operation<Float> {
	 @Override
	    public Float apply(Float a, Float b) {
	        return a * b;
	    }
}
