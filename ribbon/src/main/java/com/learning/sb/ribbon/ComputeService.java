package com.learning.sb.ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ComputeService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String addService(int a, int b) {
        return restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a="+a+"&b="+b, String.class).getBody();
    }
    public String addServiceFallback(int a, int b) {
        return "error";
    }
}
