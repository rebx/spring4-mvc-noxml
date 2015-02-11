package com.rebx.spring.mvc.controller;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.rebx.spring.config.AppConfig;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class,
    classes = {AppConfig.class})
public class HomeControllerTest extends AbstractJUnit4SpringContextTests {


  @Autowired
  private WebApplicationContext webappContext;

  private MockMvc mockMvc;


  @Before
  public void setUp() throws Exception {
    this.mockMvc =
        MockMvcBuilders.webAppContextSetup(this.webappContext).build();
  }

  @After
  public void tearDown() throws Exception {}


  @Test
  public void testHome() throws Exception {
    final String testRoute = "/";
    MvcResult mvcResult =
        mockMvc
            .perform(
                get(testRoute).accept(
                    MediaType.parseMediaType("text/html;charset=UTF-8")))
            .andExpect(status().isOk()).andDo(print()).andReturn();
    assertNotNull(mvcResult);
  }

}
