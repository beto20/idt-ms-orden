package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class OrderControllerTest {
    @Autowired
    WebApplicationContext context;

    @Test
    void registeredOrderAppearsWithCalculatedAmount() throws Exception {
        MockMvc mvc = MockMvcBuilders.webAppContextSetup(context).build();

        mvc.perform(post("/api/v1/orders/register")
                        .contentType("application/json")
                        .content("""
                                {"clientName":"Eva","clientLastname":"Rojas","products":[{"name":"Teclado","quantity":2,"price":45.5}]}
                                """))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));

        mvc.perform(get("/api/v1/orders/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[4].clientName").value("Eva"))
                .andExpect(jsonPath("$[4].amount").value(91.0));

        mvc.perform(options("/api/v1/orders/register")
                        .header("Origin", "http://localhost:5500")
                        .header("Access-Control-Request-Method", "POST"))
                .andExpect(status().isOk())
                .andExpect(header().string("Access-Control-Allow-Origin", "http://localhost:5500"));
    }
}
