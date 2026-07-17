package com.constants;

public enum Warranty {

	INWARRANTY(1),
	OUTWARRANTY(2);
	
	int code;
	
	private Warranty(int code)
	{
		this.code=code;
	}

	public int getCode()
	{
		return code;
	}
}
