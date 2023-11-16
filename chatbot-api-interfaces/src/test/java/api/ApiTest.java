package api;


import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * @author：yangJunfeng
 * @create：2023-11-17 20:41
 * @Description:
 */
public class ApiTest {
    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//        设置请求信息
        HttpGet httpGet = new HttpGet("https://api.zsxq.com/v2/topics/211241228241421/info");
        httpGet.addHeader("cookie","zsxq_access_token=D22051BB-85D6-0225-ED9A-C385487B0946_2E74F7106B824829; zsxqsessionid=7d54dd8c1173a7e85f18d31a30fd35ba; abtest_env=product; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22812851254442482%22%2C%22first_id%22%3A%2218bdd21b55a37c-0b56bced636146-26031051-1327104-18bdd21b55bc38%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThiZGQyMWI1NWEzN2MtMGI1NmJjZWQ2MzYxNDYtMjYwMzEwNTEtMTMyNzEwNC0xOGJkZDIxYjU1YmMzOCIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjgxMjg1MTI1NDQ0MjQ4MiJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22812851254442482%22%7D%2C%22%24device_id%22%3A%2218bdd21b55a37c-0b56bced636146-26031051-1327104-18bdd21b55bc38%22%7D");
        httpGet.addHeader("Content-Type","application/json; charset=UTF-8" );
//        发送请求
        CloseableHttpResponse response = httpClient.execute(httpGet);
//        判断请求回来的信息是否正确
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
//            将返回来的实体信息转化为字符串
            String s = EntityUtils.toString(response.getEntity());
            System.out.println(s);
        }else {
            System.out.println(response.getEntity());
        }

    }
    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/211241228241421/comments");
        post.addHeader("cookie","zsxq_access_token=D22051BB-85D6-0225-ED9A-C385487B0946_2E74F7106B824829; zsxqsessionid=7d54dd8c1173a7e85f18d31a30fd35ba; abtest_env=product; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22812851254442482%22%2C%22first_id%22%3A%2218bdd21b55a37c-0b56bced636146-26031051-1327104-18bdd21b55bc38%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThiZGQyMWI1NWEzN2MtMGI1NmJjZWQ2MzYxNDYtMjYwMzEwNTEtMTMyNzEwNC0xOGJkZDIxYjU1YmMzOCIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjgxMjg1MTI1NDQ0MjQ4MiJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22812851254442482%22%7D%2C%22%24device_id%22%3A%2218bdd21b55a37c-0b56bced636146-26031051-1327104-18bdd21b55bc38%22%7D");
        post.addHeader("content-Type","application/json; charset=UTF-8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"\\n\",\n" +
                "    \"image_ids\": [\n" +
                "      181554182248212\n" +
                "    ],\n" +
                "    \"mentioned_user_ids\": []\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
//            将返回来的实体信息转化为字符串
            String s = EntityUtils.toString(response.getEntity());
            System.out.println(s);
        }else {
            System.out.println(response.getEntity());
        }
    }
}
