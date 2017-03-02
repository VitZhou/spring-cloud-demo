package com.learning.sb.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by henryz on 17-3-2.
 */
@RestController
public class RibbonController {

        @Autowired
        ComputeService service;

        @RequestMapping(value = "/add", method = RequestMethod.GET)
        public String add(int a,int b) {
            return service.addService(a, b);
        }
}
