package com.belle.springsecurityjwt.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith (SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private final String jsonTest = "/json_test";

    private final String jsonTest2 = "/json_test2";

    private final String easyuiData = "/easyui_data";

    @Test
    public void jsonTest() throws Exception {
        mockMvc
                .perform(
                        get(jsonTest)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(0))
        ;
    }

    @Test
    public void jsonTest2() throws Exception {
        mockMvc
                .perform (
                        get (jsonTest2)
                )
                .andExpect (status().isOk ())
                .andExpect (jsonPath ("$.code").value (0));
    }

    @Test
    public void easyUiData() throws Exception {
        mockMvc
                .perform (
                        get (easyuiData)
                )
                .andExpect (status().isOk ())
                .andExpect (jsonPath ("$.code").value (0));
    }
}