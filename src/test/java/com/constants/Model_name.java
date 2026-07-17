package com.constants;

public enum Model_name {

	Nexus2_blue(1),
	Galaxy(2);
	
	int code;
	private Model_name(int code)
	{
		this.code=code;
	}
	

	public int getCode()
	{
		return code;
	}
	
}
