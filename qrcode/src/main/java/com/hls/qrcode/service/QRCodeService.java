package com.hls.qrcode.service;

import com.google.zxing.WriterException;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Package: com.hls.qrcode.service
 * @Author: helishi
 * @CreateDate: 2017/12/7
 * @Description:
 */
public interface QRCodeService {
    public BufferedImage createQRCode(final String url)throws WriterException,IOException;
}
