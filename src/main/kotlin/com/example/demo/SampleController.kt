package com.example.demo

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute

@Controller
class SampleController (
        private val sampleService: SampleService
) {
    @GetMapping("/")
    fun default(model: Model): String {
        val sampleModel = SampleModel(0, 0)
        model.addAttribute("sampleModel", sampleModel)
        return "sample"
    }

    @GetMapping("/square")
    fun square(@ModelAttribute sampleModel: SampleModel, model: Model): String {
        model.addAttribute("sampleModel",
                SampleModel(
                        value = sampleModel.value,
                        value_square = sampleService.square(sampleModel.value)
                )
        )
        return "sample"
    }

    @ExceptionHandler
    fun errorHandler(): String {
        return "500"
    }
}
