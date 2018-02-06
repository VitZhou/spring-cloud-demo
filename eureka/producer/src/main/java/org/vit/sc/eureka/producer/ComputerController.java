package org.vit.sc.eureka.producer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
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
