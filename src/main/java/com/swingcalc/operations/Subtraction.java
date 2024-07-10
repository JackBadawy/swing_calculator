package com.swingcalc.operations;

public class Subtraction implements Operation<Float>{
	@Override
    public Float apply(Float a, Float b) {
        return a - b;
    }
}
