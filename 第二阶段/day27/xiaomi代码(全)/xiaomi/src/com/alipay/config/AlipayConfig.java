package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓


	//沙箱APPID
	public static final  String app_id = "2016100100635775";
	//沙箱私钥
	public static final  String merchant_private_key = 
			"MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCMyT9r2TCNXA0jNbG6zd06W/fa6uw7jr/LvPugiGPz/YaDBhsJE4j64vrI3sp+k7+gi9SyXComeSlkvKHW3rSkZRrWrSv8BPNrZ/OzeF+VrwBCeEkKW7fptzGFTHfJMDTgC5MPeZsECYat4kfOJOGdAYILlC+Cq/NzIiN2CHNK0UYXq4CToCmBJJrluxe65fI09clLrO94vr1avCJWZz6775UWgi9o6E4N7sdKJ3poQGxmS2f5PREQrYPMFtv+UWulSujhLF+p9PouXkGKgdEfza39p8xw4ZsBWLbAC98a4FEtu8l9xlSW3ri4W6ow0uYmnkEad/NONgdrGDzsP+ElAgMBAAECggEAe7mlFeeyhpieJxJaFlwzDsWiRe7tGs4x+iAkVwlmJhfpLZ6hBdH4MNxnHz7EYIcCAlrA2tqqZFNYsGIiLI5d3JfKBV386KeFMSATCOdBwW8hYEkLj6HZN/k5+Pah0tqdrUQewpvRQrQIeyoAhsbcy7l2iyx4sHLjKYyX83QrtlRzR7TkPbdkx1KrkaXwg4/6Oy+BGxwkCfzzEPrZJxBkn8A+pVQ05LB7RGfpFY6VZtLKR2FBOySXIP4tEm+zAf4K15QCTdLd2z8FLVGloL08qzvKkmdw6oqKU3MoPpdAZ4sVi8EgC/9QkdTtb/o+9Adp+8dKCMOHP+uvOTOu26L2oQKBgQDO0OHBC7BTaViIkN/ENlZFhLeT0cgOlT1qSul0ljzYz/RKqfV94EnK7km4xHzWfYYSFWnaqf2G6b+YjnslSAqhcqJjeAfnCS+qMPInR82I+5ZCnakJITuQk4dRQfu2UxYe20foAc4BF4bus44flQRLyU/B+hOjx+Tn8AKY6jyCCQKBgQCuRGsQi1ItDGYLoto0lqUil17z4Y0EUDwS4hqT5BmCWInMkg9m0Qhe10lctYVlskTTmxAau8Byid2Q60KI/UqWIgERLv+2wL4y5+j69nnaSjMwVn8bIdVte2h5IFm+VQSHtmH+5SjmtIKAtMZvOQluJX3e0/ObgvGMsfqFwUL9PQKBgAOri0YMug1Q4kRSJdZqjG9hYoyZ/W3c0iEvwSLTg7LpRdGJYJTiRQz325EO05RO1/E8NguuVpRtU3wWkzLfK2kgCqevOpyr+g+QHMv7pzcWF92IxLYnw9HV/GHBxQDASrUzePwyBADa9QcJYq1GzLO3l9W+ZVjTtEk1ZiZmibpZAoGAW0XAYbDmwGtvAwcvjD2ejgiEFe37Ytf3Lti3nN/qMGfY/Ik/gdVXsfzGEsWL8aC2BbKAc9AEUrk8j8t4VLF9IDb9IhfgnMJEm/r0/oSbe6ZDOz0CY56L30S0ikRUXKjAr6fpmYxCqNrAQ1LrX5ObCdKfI1cVj0y84LjTAr0fLe0CgYATIul3PpxL4KrP2V27r8PUDpUy9nWPjpEAjF3CcNEV/EMZ/YxbXrvVZTBoaAxSikRoYd+Uc8NwHDCe3Kgh4MS7Ia1IsPQoZWNUMMpL0gGEt0oO+rY3DtrXftLiBWeJGPACXvIAfr7X7C/18KgR6MZQMTfz8lFnqxI54PZIkTgjYQ==";
	//支付宝公钥
	public static final  String alipay_public_key = 
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAntGAurZQ44+D8gMC7/W4q5Q8Qz0k0BwrPpL5tBoZOmL6JwVl/Oyc0MDFnZWHGJ/5lsgmyVeDiDXSMQLRwATyze0oDjGldrNTxStoOGzIW7h3m1mr4J8+rorf2aqFHF8BgUO54CMUu43YyOobSnvfHp0XabgpIAuvUqVnodkHdSP91JnpuMeZwYW1GyUgdApev+yc+XlXSIuy/4gYCXz4mgjCbGed9XN1F/X+I5gNct/CtW9JvJFkSnwdY4+33DUFcL8/psXA8gaxj5xpW8DRmMNgxD/4O+nY7GlDBUCq74WPX8OaWSZanx1WzIGyKTx61ADUVAV17qj74UQZ4Qr6pQIDAQAB";
	//沙箱网关地址
	public static final  String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

//	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/xiaomi/notify_url.jsp";

//	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/xiaomi/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";

	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
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

