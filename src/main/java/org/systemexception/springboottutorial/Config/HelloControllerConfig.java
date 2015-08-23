package org.systemexception.springboottutorial.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author leo
 * @date 23/08/15 17:46
 */
@Component
@Configuration
public class HelloControllerConfig {

	@Value("${hello.message}")
	private String helloMessage;

	public String getHelloMessage() {
		return helloMessage;
	}

	public void setHelloMessage(String helloMessage) {
		this.helloMessage = helloMessage;
	}
}
