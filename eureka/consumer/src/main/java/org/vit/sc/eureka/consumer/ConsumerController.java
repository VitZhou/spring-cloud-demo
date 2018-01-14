package org.vit.sc.eureka.consumer;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    private static Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    ComputeClient computeClient;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add(int a, int b) {
        return computeClient.add(a, b);
    }
//
//    @RequestMapping(value = "excel.json")
//    public String getExcel(HttpServletResponse response) {
//        byte[] excel = computeClient.getExcel();
//        InputStream inputStream = null;
//        ServletOutputStream outputStream = null;
//        try {
//            inputStream = new ByteInputStream(excel, excel.length);
//            outputStream = response.getOutputStream();
//            response.setHeader("Content-Type", "application/force-download");
//            response.setHeader("Content-Type", "application/vnd.ms-excel");
//            response.setHeader("Content-disposition", "attachment; filename=test.xlsx");
//            int byteReader;
//            byte[] bytes = new byte[1024];
//            while ((byteReader = inputStream.read(bytes)) != -1) {
//                outputStream.write(bytes, 0, byteReader);
//            }
//
//            outputStream.flush();
//        } catch (Exception e) {
//            logger.error("reader excel error", e);
//        } finally {
//            try {
//                if (inputStream != null) {
//                    inputStream.close();
//                }
//                if (outputStream != null) {
//                    outputStream.close();
//                }
//            } catch (Exception e) {
//                logger.error("fail to close stream", e);
//            }
//        }
//        return "SUCCESS";
//    }
}
