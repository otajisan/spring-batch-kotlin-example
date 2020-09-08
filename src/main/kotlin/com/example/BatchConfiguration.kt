package com.example

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@EnableBatchProcessing
@Configuration
class BatchConfiguration(
    private val jobBuilderFactory: JobBuilderFactory,
    private val stepBuilderFactory: StepBuilderFactory,
    private val helloTasklet: HelloTasklet
) {
    @Bean
    fun helloJob(helloStep: Step): Job {
        return jobBuilderFactory.get("helloStep")
            .flow(helloStep)
            .end()
            .build()
    }

    @Bean
    fun helloStep(): Step {
        return stepBuilderFactory.get("helloStep")
            .tasklet(helloTasklet)
            .build()
    }
}
