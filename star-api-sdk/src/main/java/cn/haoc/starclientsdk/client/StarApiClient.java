package cn.haoc.starclientsdk.client;

import cn.haoc.starclientsdk.utils.SignUtils;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * 调用第三方接口的客户端
 *
 */
@Slf4j
@Data
public class StarApiClient {

    public static String GATEWAY_HOST = "http://localhost:8090";


    private String accessKey;

    private String secretKey;

    public StarApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public void setGatewayHost(String gatewayHost) {
        GATEWAY_HOST = gatewayHost;
    }

    /**
     * 生成新的请求头，里面包含accessKey，并且为了安全，使用签名密钥
     * @param body 调用接口所需要的原参数
     * @param method 调用接口所需要的method
     * @return 新的请求头
     */
    private Map<String, String> getHeaderMap(String body, String method) throws UnsupportedEncodingException {
        HashMap<String, String> map = new HashMap<>();
        map.put("accessKey", accessKey);
        map.put("nonce", RandomUtil.randomNumbers(10));
        map.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        map.put("sign", SignUtils.genSign(body, secretKey));
        body = URLUtil.encode(body, CharsetUtil.CHARSET_UTF_8);
        map.put("body", body);
        map.put("method", method);
        return map;
    }

    /**
     * 支持调用任意接口，把请求导向网关
     * @param params 接口参数
     * @param url 接口地址
     * @param method 接口使用方法
     * @return 接口调用结果
     */
    public String invokeInterface(String params, String url, String method) throws UnsupportedEncodingException {

        String result;
        log.info("SDK正在转发至GATEWAY_HOST:{}",GATEWAY_HOST);
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST + url)
                // 处理中文编码
                .header("Accept-Charset", CharsetUtil.UTF_8)
                .addHeaders(getHeaderMap(params, method))
                .body(params)
                .execute();

        result=JSONUtil.formatJsonStr(httpResponse.body());
        log.info("SDK调用接口完成，响应数据：{}",result);

        return result;
    }

}
