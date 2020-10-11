package org.sicnusc.team_project.config;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号,开发时使用沙箱提供的APPID，生产环境改成自己的APPID
    public static String APP_ID = "2016102500756127";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String APP_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCYPD4CVjvjeq4PNuYIKQnsMPk2uwU2YZJX33JuVdyt3d80wPwdGZ8Wjg3o340hGIKL0zdtGtiMIy3xOmjOanNB8fkCcwM5movjTyIddIc76fOUkjU1uPm+Jjhnm1XR0judd3yymbCj4qrGsGskb55I9wIXlMRSJ8iME3v7plfKGsZ1UxS6/zU+/jGNWcqMP/M731SliQj2+6ST7mE10xpColo9dvWzY2AsVSx35h5fpuDmBzGxq0TP5sWbwZUmKsyclpNST5Z/zPaSVlRXQO6HxfHh8tk2QOBSSsjls5RQ0Rnl0vIDgMpUxpSVrTNDeT/4HPQKdSi+o2vj6DLg0mkrAgMBAAECggEAV0jzJNPcsqj8c6y+Z59gGRRbT44bhvqatddf/PMt/GJiQBUGeIjgNkZso0DJ4lfzQchw1xW1Y2QoS096GB/gxca/RzA6gSSjYElW/hx6DVguWNkbuRm919CCNqVRp2Qq2jZQQPbt2Il18UXlqJZ24s79XBfoGFLHIclqJPdTDoU5LLdCtLLdUfktgYzCCGN7D/z2fTsRNahwdGOEaNYHq3VzJmZDh6ksslSOepqf6GAq44Wtx3LCvZxs2mhrc2rRmgUFl8/cD/XloT8lgzHGrfkfn0fI3EDMY5TACook5lcGxzl1gtejnFFvr0w5RaZlk+QnU7y+k1yasDmnn6SagQKBgQDIcIqnucwQFiofWzgTcZ5l6A8sd+jh5m3YbxUdTbIqQhNmcZF4AicYL49pD6AChD9+AfcQsT39BUpR1c1tZTviLMzxEZO4wAfyjcM3ktkdMQh5vPtzQm0F4fG/Z2J65nxL/flDltP+eJKLwojgL8QNY3PD3IuSgyuemow0buHzMwKBgQDCbw+AYXfp/awfv5sRmSYwRHFw+qehT0aFQd8laPTzQyBEN2vF3kb9E5nGI1/tErlIKMmJ8HQv+J4EGtVSPWAHkBAN3PTZjbj8qnLo3VF1ct1spDwSJ24zd3rb0ymykKyuve+dHiff1fSez8pkEbGGHjbfrel2SvrJHIdFLlOyKQKBgCNILB/6BIGQZTm/xM8nYMpvXrxlHwkklpFSfFT8KDBoESInO4P0XQ1U0dmcdn366XI0xliZ2l9/XuWozNBE0ZWubSTCA06x/rQjYAmYP79zsho7ucdAGhC/BN68RAl+KML3objUA9z3PFR9mbpcrhXtO6NuXuMbU8JHUgaovf0hAoGBAI6DIPWUe3RCvvq2Uk7f1iHiyNNqpZuSo7ngwlKFT6VOOkRF6vSpK5cr2rZkD1eRNcUyQCae3EqdDBUuJdWVruFcMqg2oDEls8VemcMdFSvk+W88IduckyWeGasuZ42+hRO/m/WpuMhT5mzRGSOn5FrNoqLosgpGgvMNugh3IFmhAoGBAIcIqPLTI+q/Epjbh3POvylfEI1lpc6Q4GW7CaCzQqAGzfiSVbp9Gg0J1PXDTOO6b8Prxgw0HrG9IN0lZRZtVHkaAh1yieaiFLYnCPrKRpJZCqkEGHpksp+vJiVVoGjFmVhmEh23DgRXJ88Kw3gnF3YXROOo4KFEdGMazuVK5aGx";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxtHnIPu9Vci1x/4SSEHjkFqZPqOW7xV4Qa+DENOrwfYUFWirs1BXUtJnZMiSSuycDBDTZTVoMZhUmKP5CDcqsHW3uZLMtKm65F66VbRt2XVpi8+o+44CnI+EiJqbwtsEUumj08gK/fkyXq6VqmK4jg/OoPOazaw895L2uWusQjJQ5LzzONZMfUOKuvqWDcaW+OQXPxd3JE+bpt0rgZTtIDXIZEdeEr/pU7YEb3HaM2ihYCKAujiF6pJaR0fd1PZe63bhr8A4kKcPNfGoQRRli3CFRdc8BbqI+EUU5WmJtw+y5csuNTmc2ioyN8WRX2DVYpeKh/GNgvHbD4u9nEFKFwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问(其实就是支付成功后返回的页面)
    public static String return_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String CHARSET = "utf-8";

    // 支付宝网关，这是沙箱的网关
    //正式网关https://openapi.alipay.com/gateway.do
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
//    public static void logResult(String sWord) {
//        FileWriter writer = null;
//        try {
//            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
//            writer.write(sWord);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (writer != null) {
//                try {
//                    writer.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
}
