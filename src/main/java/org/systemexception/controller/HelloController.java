package org.systemexception.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leo
 * @date 22/08/15 00:11
 */
@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return ("SpringBoot working");
	}
}
