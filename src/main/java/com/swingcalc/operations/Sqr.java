package com.swingcalc.operations;

public class Sqr implements Operation<Float> {
	@Override 
	public Float apply(Float a, Float b) {
		return b*b;
	}
}
