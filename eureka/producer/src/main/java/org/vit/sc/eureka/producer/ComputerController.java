package org.vit.sc.eureka.producer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

@RestController
public class ComputerController {

    @Autowired
    private ModulusConfig modulusConfig;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public float add(@RequestParam Integer a, @RequestParam Integer b) {
        logger.debug("a:{},b:{}", a, b);
        return (a + b) * modulusConfig.getModulus();
    }
}
