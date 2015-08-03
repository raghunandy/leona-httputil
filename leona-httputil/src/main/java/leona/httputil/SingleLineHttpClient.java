/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leona.httputil;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
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
            try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
                HttpPost httpPost = new HttpPost(url);
                //        httpPost.addHeader("User-Agent", "");

                httpPost.setEntity(new StringEntity(data));

                HttpResponse resp = httpClient.execute(httpPost);
                resp.getEntity().getContent();
                String respString=IOUtils.toString(resp.getEntity().getContent());
                return respString;
            }
            //        httpPost.addHeader("User-Agent", "");
        } catch (IOException ex) {
            Logger.getLogger(SingleLineHttpClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
