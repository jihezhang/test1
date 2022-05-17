package com.itheima;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.client.MockMvcClientHttpRequestFactory;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.HeaderResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

import javax.servlet.http.HttpServletRequest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
public class WebTest {

    @Test
    public void testWeb(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions perform = mvc.perform(builder);
    }

    @Test
    public void testStatus(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions perform = mvc.perform(builder);

        //定义执行状态匹配器
        StatusResultMatchers status = MockMvcResultMatchers.status();
        //定义预期执行状态
        ResultMatcher ok = status.isOk();
        //使用本次真是执行结果与预期结果进行比对
        perform.andExpect(ok);
    }

    @Test
    public void testBody(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions perform = mvc.perform(builder);

        //定义执行状态匹配器
        ContentResultMatchers content = MockMvcResultMatchers.content();
        //定义预期执行结果字符串
        ResultMatcher resultMatcher = content.string("springboot2");
        //使用本次真实执行结果与预期结果进行比对
        perform.andExpect(resultMatcher);
    }

    @Test
    public void testJSON(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions perform = mvc.perform(builder);

        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher json = content.json("{\"id\":1,\"type\":\"springboot\",\"name\":\"springboot\",\"description\":\"springboot\"}");
        perform.andExpect(json);
    }

    @Test
    public void testHeader(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions perform = mvc.perform(builder);

        HeaderResultMatchers header = MockMvcResultMatchers.header();
        ResultMatcher resultMatcher = header.string("Content-type", "application/json");
        perform.andExpect(resultMatcher);
    }
}
