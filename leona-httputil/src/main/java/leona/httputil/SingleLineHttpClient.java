/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leona.httputil;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author Raghu
 */
public class SingleLineHttpClient implements SingleLineHttpClientSpec {

    private static SingleLineHttpClient i;

    public static SingleLineHttpClient instance() {
        if (i == null) {
            i = new SingleLineHttpClient();
        }
        return i;
    }

    private SingleLineHttpClient() {
    }

    @Override
    public String post(String url, String data) {
        try {
            HttpPost httpPost = new HttpPost(url);
            //        httpPost.addHeader("User-Agent", "");

            httpPost.setEntity(new StringEntity(data));
            return httpMethod(httpPost);
        } catch (IOException ex) {
            Logger.getLogger(SingleLineHttpClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public String httpMethod(HttpUriRequest method) throws IOException {

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {

            HttpResponse resp = httpClient.execute(method);
            resp.getEntity().getContent();
            String respString = IOUtils.toString(resp.getEntity().getContent());
            return respString;
        }
        //        httpPost.addHeader("User-Agent", "");

    }

    public String delete(String url, String string) {
        try {
            HttpDelete httpDelete = new HttpDelete(url);
            //        httpPost.addHeader("User-Agent", "");

            return httpMethod(httpDelete);
        } catch (IOException ex) {
            Logger.getLogger(SingleLineHttpClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
