package com.example.demo

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute

@Controller
class SampleController {
    @GetMapping("/")
    fun default(model: Model): String {
        val sampleModel = SampleModel(0, 0)
        model.addAttribute("sampleModel", sampleModel)
        return "sample"
    }

    @GetMapping("/square")
    fun default(@ModelAttribute sampleModel: SampleModel, model: Model): String {
        model.addAttribute("sampleModel",
                SampleModel(
                        value = sampleModel.value,
                        value_square = sampleModel.value?.times(sampleModel.value!!)
                )
        )
        println(sampleModel.value)
        return "sample"
    }
}
