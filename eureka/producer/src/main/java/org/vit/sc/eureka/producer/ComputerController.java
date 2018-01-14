package org.vit.sc.eureka.producer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        logger.debug("a:{},b:{}", a, b);
        return a + b;
    }

    @RequestMapping(value = "/excel")
    public byte[] getExcel(HttpServletResponse response) {
        String fileName = "/home/henryz/javaProject/dede.xls";
        File f = new File(fileName);

        if (!f.exists()) {
            logger.error("can't found file:{}", fileName);
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream((int) f.length());
        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(f));
            int buf_size = 1024;
            byte[] buffer = new byte[buf_size];
            int len = 0;
            while (-1 != (len = in.read(buffer, 0, buf_size))) {
                bos.write(buffer, 0, len);
            }

        } catch (IOException e) {
            logger.error("fail to read file", e);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                bos.close();
            } catch (IOException e) {
                logger.error("fail to close stream", e);
            }
        }
        return bos.toByteArray();
    }
}
