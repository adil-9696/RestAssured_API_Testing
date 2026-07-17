package com.constants;

public enum Problems {

	
	SMARTPHONEISRUNNINGSLOW(1),
	POORBATTERYLIFE(2),
	PHONEORAPPCRASHES(3),
	SYNCISSUE(4),
	OVERHEATING(6);
	
int code;
	
	private Problems(int code)
	{
		this.code=code;
	}

	public int getCode()
	{
		return code;
	}
}
