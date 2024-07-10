package com.swingcalc.operations;

public class SqrRoot implements Operation<Float>{
	@Override
	public Float apply(Float a, Float b){
		
	if (b == 0 || b == 1) {
        return b;
	} 
	
     return (float) Math.sqrt(b);
}
}
