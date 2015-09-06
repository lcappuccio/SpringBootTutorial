package org.systemexception.springboottutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.systemexception.springboottutorial.config.HelloControllerConfig;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author leo
 * @date 22/08/15 00:11
 */
@ComponentScan(basePackages = {"org.systemexception.springboottutorial.*"})
@RestController
public class HelloController {

	@Autowired
	private HelloControllerConfig helloControllerConfig;

	@RequestMapping("/")
	public String index() {

		String message = helloControllerConfig.getHelloMessage();
		message += "<br>" + LocalDate.now() + " " + LocalTime.now();
		return (message);
	}
}
