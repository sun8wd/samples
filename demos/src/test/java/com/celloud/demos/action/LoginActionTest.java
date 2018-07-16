package com.celloud.demos.action;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.celloud.demos.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class LoginActionTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testLogin2() throws Exception {
		MvcResult result = mockMvc.perform(post("/login2").param("username", "123").param("password", "celloud"))// .andExpect(status().isOk())
				.andReturn();
		System.out.println(result.getResponse().getContentAsString());
	}

	@Test
	public void testLogin1() throws Exception {
		User user = new User();
		user.setUsername("lihh");
		user.setPassword("celloud");
		MvcResult result = mockMvc.perform(post("/login").contentType(MediaType.APPLICATION_JSON_UTF8).content(""))// .andExpect(status().isOk())
				.andReturn();
		System.out.println(result.getResponse().getContentAsString());
	}
}
