package com.utils;

import java.util.Map;

import com.bettercloud.vault.Vault;
import com.bettercloud.vault.VaultConfig;
import com.bettercloud.vault.VaultException;
import com.bettercloud.vault.response.LogicalResponse;

public class VaultUtil {

	private static VaultConfig config;
	private static Vault vault;
	
	
	public static  String getValue(String key)
	{Map<String,String> map = null;
	
		try {
			//System.getenv("Vault_server_URL"), System.getenv("vault_server_token")
		config = new VaultConfig().address("http://13.48.204.242:8200").token("root").build();
		
	vault=new Vault(config);
	
	LogicalResponse res=vault.logical().read("secret/phoenix/qa/database");
	
 map=res.getData();
 return map.get(key);
	
			
	} catch (VaultException e) {

		System.out.println("Vault is DOWN!!!!!");
	}
		

return null;
		
	}
	
	
	

}
