package privat.test;

import org.junit.Assert;
import org.junit.Test;
import privat.client.PubInfoPrivatClient;

import java.io.IOException;

/**
 * Created by sanseyvich on 2/6/18.
 */
public class PubInfoPrivatClientTest {
    private PubInfoPrivatClient client;

    @Test
    public void verifyBaseCCY() throws IOException {
        client = new PubInfoPrivatClient();
        Assert.assertEquals(client.get().get(0).getBase_ccy(), "USD");
    }
}
