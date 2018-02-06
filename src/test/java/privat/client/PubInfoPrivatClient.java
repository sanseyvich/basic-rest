package privat.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import privat.dto.ExchangeRate;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by sanseyvich on 2/6/18.
 */
public class PubInfoPrivatClient {
    private String host = "https://api.privatbank.ua/p24api/pubinfo";
    private String vars = "?json&exchange&coursid=1";

    public PubInfoPrivatClient() {
    }

    public PubInfoPrivatClient(String host, String vars) {
        this.host = host;
        this.vars = vars;
    }

    public List<ExchangeRate> get() throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(host + vars);
        CloseableHttpResponse response1 = httpclient.execute(httpGet);

        List<ExchangeRate> exchangeRate = null;

        try {
            assert response1.getStatusLine().getStatusCode() == 200;

            //convert response to String and to List<ExchangeRate> after
            String output = EntityUtils.toString(response1.getEntity());
            Gson gson = new GsonBuilder().create();
            JSONArray outputJson = new JSONArray(output);

            Type listType = new TypeToken<List<ExchangeRate>>() {}.getType();
            exchangeRate = gson.fromJson(outputJson.toString(), listType);
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            response1.close();
        }
        return exchangeRate;
    }
}
