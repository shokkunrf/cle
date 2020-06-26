package com.example.demo

import org.springframework.stereotype.Service

@Service
class SampleService {
    fun square(value: Int): Int {
        return value*value
    }
}
