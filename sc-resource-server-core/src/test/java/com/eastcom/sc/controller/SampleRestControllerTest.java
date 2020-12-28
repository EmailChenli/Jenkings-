package com.eastcom.sc.controller;

import com.eastcom.sc.Application;
import com.eastcom.sc.dto.SampleDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class SampleRestControllerTest {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setupMockMvc() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void getById() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/v1/sample").contentType(MediaType.APPLICATION_JSON).param("id", "67258679-91a4-48f1-85f1-3cfd91389430"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void page() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/v1/sample/page").contentType(MediaType.APPLICATION_JSON).content("{\"page\": 1, \"limit\": 20}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void save() throws Exception {
        SampleDTO sample = new SampleDTO("test", "测试数据");
        String json = mapper.writeValueAsString(sample);

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/v1/sample/create").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andDo(MockMvcResultHandlers.print());
    }

}
