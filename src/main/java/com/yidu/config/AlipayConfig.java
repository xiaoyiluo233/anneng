package com.yidu.config;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号,开发时使用沙箱提供的APPID，生产环境改成自己的APPID
    public static String APP_ID ="2021000117615370"; //测试

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String APP_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCvymW8atBxpC3djcm1yIVubpUv6YTmXohTT82SR0i6FtMHCuhaGSuyHmu5aTX7km4q8fIpunNccomCNh08BhgnwQ9D4+NGUwHaY6Ife+5GvLxgM0wPlnH49twcpkZWJx43vMjJHr1IfkS9hOyaJZDnsaC1OaihBV2SIMgxzMEBom7W2zR918a+It+u7r1Tf0O5AjqLoNoDx/23sChsF2V9L+NQIOtqZjAM1TzwMmOq2SKbo8lWn9/e29S3dd8dnwgRr2mKmYxwYYUN+iPALb2LwYmkjCgyXrSwTOLjjarqTn8SoBiJS0CoUp57KQIgolS8a2X8nc8igJ9EZltCI8MdAgMBAAECggEAY40hVDTBWrn5Z3C2fIXUWpexUPLT2opKdbPJ3T8VRp1KYMCimPOMNVDY/KVCdveUACoIU+1NC1up193BbI6e+1Rvyqixus+jSwQFegL7C4AyxeAHAQTYAn/6Yxce2gdJK5NzucH4u6cWUqWGQD1p9Gw5cKf4gUfCl9CMzvb/jmZ4NS5QPhAGOV12V4oKpZDOhFYKYur0Nu30v87SUZZmQKceUIUyay6vxzuIBiujVnrrUZX6VETYLROt6/DMGkoiR+OxsoDCCGUvuYtFgDi5GBR8mEoFbLaVZv2z5F4IZutWyNVSi11dzMnpMEpgMMlpYJBBCO4ZLtQtF/V3gzH6WQKBgQDaFBs8AjZEs8hY0V4iNmEuewWmg4au6f1aym0aegxJwL3P0L60N9DMZS7kM57Y0tiPbIWBpfo8ndZvwOjZrMuSeEFm97ZpHx7kmmqjCYanVuyYO2Gz6W5vv/ckyGrG+REqQrdRnKDy4pgB+4rQRTM6bfR9gYAYpOf6aaKAbdqHSwKBgQDOW9G+NXdK0mpryslp76NYZ1rgz1M+4lHACV2xQHcEPEOCnxo9J5E3ae8p3LU/bIHaNnZWE6z1wCjsnX89SmB1IVBd4jwgweB/7kbnj6pf79ggBRcZ8rCogK6CbUm7lZzds7mEvldUpDHKE6+vFUtboKjdIguq84l4OciQCkjWNwKBgQDV8vPlI6ZqMJdVy9I2bnNZToh0nIT+BcHx2LbBSwvTL60IvRrbZAcNABfI+nvU7MZZr3Yrg9LEtXUznmbTZ5swz5oaktv6tfVxAa2s1iOs+LKVh2yLPXCDYinthFJ9cs1MULfY8XlV0Mig6U9+lOV1ZXp/xxUNGHweSJSMuzmxkQKBgQCZ6DN7yMarIFpNANbN0vQiKBvIlfjBauyL7LBbVfguSYAUePOJ7uvIx5Kfx0PLBPOoO3xw4IXcWDBtoV3X6ZQdZ/ZXvzcXO2JkJ+PsKuNoYCryXrmHGdGWKzt8fWRDqudvFu9jyM67iyazT5F1ZM1qjl3DZ/QJ0U+TQo2KmJEQawKBgEnOE0PfSow4zfq6n57lgN4NE2/MGx+JsPB5jfPZ8QcqkAjwWNgZOc/f9ve65Gr40UyTOvVJMT9UU2Nlg74I29S10rjl9c4NR+UNXgALQrxsqdqHj+hWugpAd5f3RCIRMbUxZGuCHeakyDEXbWEKi3/lpk7vF/pCTVvXfjc/ZdhW";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAi88CDfoAeYXD7W2d9WPkfrfJ/pJOg/XZCPU0/n1aKIKuoXy1d8+I8xgOiEEgyLq7kvnIpcQj4icQDIU8QbmfLmiwOnRbOUBHMyc/YkJUP26kROTPXTDkjVB94fseuTYFgJupVgEPDRqRGXkP7AyKKFC+6ndb0EhQPL0ufCKSqwqMTPhqIQb9fmGxw062TEKpUA9qnEXtEgz1Oa+Ykr8e3cnoCEp96VOtTI7fNjcvmL+FYG5MhipBOBmoV9tT2093AYiGgbT01vbo3bb9xdjFiaNhu6qi8fv6CqD3BgyHEgdEG5ddBa++d8g6Naao+z9mu5DCWEaE0avt8QdI7d7SXwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/anneng/Alipay/notifyUrl";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问(其实就是支付成功后返回的页面)
    public static String return_url = "http://localhost:8080/anneng/Alipay/returnUrl";
    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String CHARSET = "UTF-8";

    // 支付宝网关，这是沙箱的网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do"; //测试

    // 支付宝网关
    public static String log_path = "E:\\";

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
