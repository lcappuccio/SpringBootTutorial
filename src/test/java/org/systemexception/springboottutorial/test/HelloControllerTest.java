package org.systemexception.springboottutorial.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.systemexception.springboottutorial.config.HelloControllerConfig;
import org.systemexception.springboottutorial.controller.HelloController;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author leo
 * @date 22/08/15 00:35
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {MockServletContext.class, HelloController.class, HelloControllerConfig
		.class})
@WebAppConfiguration
public class HelloControllerTest {

	// This test mocks the servlet request and response of the endpoint
	@Autowired
	private HelloControllerConfig helloControllerConfig;
	@Autowired
	private HelloController helloController;
	private MockMvc sut;

	@Before
	public void setUp() {
		sut = MockMvcBuilders.standaloneSetup(helloController).build();
	}

	@Test
	public void get_a_message() throws Exception {
		sut.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().string(containsString(helloControllerConfig.getHelloMessage())));
	}
}