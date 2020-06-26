package com.example.demo

import org.junit.jupiter.api.Test
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders

/**
 * [SampleController] の単体テスト
 */
internal class SampleControllerTest2 {
    private val sampleService = SampleService()

    @Test
    fun checkRecordOverOneYear() {
        MockMvcBuilders.standaloneSetup(SampleController(sampleService))
                .build()
                .perform(MockMvcRequestBuilders
                        .get("/")
                        .queryParam("value", "3"))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.forwardedUrlTemplate("sample"))
    }
}
