package com.hls.qrcode.controller;

import com.hls.qrcode.service.QRCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.OutputStream;

/**
 * @Package: com.hls.qrcode.controller
 * @Author: helishi
 * @CreateDate: 2017/12/7
 * @Description:
 */
@Controller
public class QRCodeController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private QRCodeService qrCodeService;

    /**
     * 根据URL生成二维码
     * @param modelMap
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/getQRCode")
    public void getQRCode(ModelMap modelMap, HttpServletRequest request,
                          HttpServletResponse response)throws Exception{
        String shopURL = request.getParameter("shopURL");
        //二维码图片输出流
        OutputStream out = null;
        try {
            response.setContentType("image/jpeg/png;charset = UTF-8");
            BufferedImage image = qrCodeService.createQRCode(shopURL);
            //实例化输出流对象
            out = response.getOutputStream();
            //画图
            ImageIO.write(image,"png",response.getOutputStream());
            out.flush();
            out.close();
        }catch (Exception e ){
            logger.error("生成二维码出现异常："+e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                if (null != response.getOutputStream()){
                    response.getOutputStream().close();
                }
                if (null != out){
                    out.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
