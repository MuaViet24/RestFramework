package com.API.TestsetUp;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.*;
import org.aeonbits.owner.Config.Key;
import org.aeonbits.owner.Config.Sources;



@Sources({
	"file:E:\\Softwares\\Reetu\\workspace\\RestAssuredFrameworkTest\\src\\main\\java\\com\\API\\Config\\config.properties"
})

public interface ConfigJSON extends Config {
	
	@Key("BaseURL")
	public String getBaseURL();
	
	@Key("BasePath")
	public String getBasePath();
	
	@Key("CustomerEndPoint")
	public String getCustomerEndPoint();
	
	@Key("validSecretKey")
	public String getValidSecretKey();

}
