package oss.concurrent.structures.beans;


import oss.concurrent.structures.structures.BinarySemaphore;
import oss.concurrent.structures.structures.CountingSemaphore;
import oss.concurrent.structures.structures.Semaphore;

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
