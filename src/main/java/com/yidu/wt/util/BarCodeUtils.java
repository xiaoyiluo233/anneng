package com.yidu.wt.util;

import org.apache.commons.lang.StringUtils;
import org.krysalis.barcode4j.HumanReadablePlacement;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @version 1.0
 * @description:条形码生成的工具
 * @author: WT
 * @date 2021/3/2 9:28
 */
public class BarCodeUtils {
    /**
     * 条形码生成
     * @param msg 条形码的内容
     * @param path 生成图片要保存的路径
     */
    public static void getBarCode(String msg,String path){
        try {
            //打开输出文件
            File file=new File(path);
            //创建文件输出流
            OutputStream ous=new FileOutputStream(file);
            //若是条形码的内容为空或者文件输出流为空
            if(StringUtils.isEmpty(msg) || ous==null) {
                //跳出
                return;
            }
            //选择条形码类型(好多类型可供选择)
            Code128Bean bean=new Code128Bean();
            //设置长宽
            final double moduleWidth=0.40;
            //设置分辨率
            final int resolution=100;
            //设置条形码宽度
            bean.setModuleWidth(moduleWidth);
            //
            bean.doQuietZone(false);
            //设置隐藏文字和数字
            bean.setMsgPosition(HumanReadablePlacement.HRP_NONE);
            //设置图片格式
            String format = "image/png";
            // 输出流
            BitmapCanvasProvider canvas = new BitmapCanvasProvider(ous, format,
                    resolution, BufferedImage.TYPE_BYTE_BINARY, false, 0);
            //生成条码
            bean.generateBarcode(canvas,msg);
            //结束绘制
            canvas.finish();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
