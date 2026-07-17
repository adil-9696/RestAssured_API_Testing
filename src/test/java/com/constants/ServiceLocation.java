package com.constants;

public enum ServiceLocation {

	SERVICELOCATION_A(1),
	SERVICELOCATION_B(2);
	
int code;
	
	private ServiceLocation(int code) {
		this.code=code;
	}
	

	public int getCode()
	{
		return code;
	}
	
}
