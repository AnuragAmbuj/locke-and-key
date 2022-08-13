package com.superlocks.beans;


import com.superlocks.structures.BinarySemaphore;
import com.superlocks.structures.CountingSemaphore;
import com.superlocks.structures.Semaphore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfigurations {

    @Bean(name = "defaultBinarySemaphore") 
    public Semaphore getBinarySemaphore(){
        return new BinarySemaphore();
    }

    @Bean(name = "defaultCountingSemaphore")
    public Semaphore getCountingSemaphore(){
        return new CountingSemaphore();
    }
}
