package com.learning.sb.feign;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletResponse;

@Component
public class ComputeClientHystrix implements ComputeClient {

    @Override
    public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        return -100000;
    }

    @Override
    public byte[] getExcel() {
        return null;
    }
}
