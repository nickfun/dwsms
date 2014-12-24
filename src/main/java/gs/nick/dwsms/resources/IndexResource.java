/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gs.nick.dwsms.resources;

import com.codahale.metrics.annotation.Timed;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import gs.nick.dwsms.views.BasicView;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author nick
 */
@Path("/")
public class IndexResource {

    private Logger log;

    public IndexResource() {
        log = LoggerFactory.getLogger(IndexResource.class);
    }

    @GET
    @Timed
    public String getPage() {
        log.info("getPage happened");
        return "Welcome to the index!";
    }

    @GET
    @Path("/sms")
    @Timed
    public void sendMessage() throws TwilioRestException {
        String ACCOUNT_SID = "abc";
        String AUTH_TOKEN = "123";
        
        TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
        // Build a filter for the MessageList
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("Body", "Jenny please?! I love you <3"));
        params.add(new BasicNameValuePair("To", "+14159352345"));
        params.add(new BasicNameValuePair("From", "+14158141829"));
        MessageFactory messageFactory = client.getAccount().getMessageFactory();
        Message message = messageFactory.create(params);
        System.out.println(message.getSid());
    }
    
    @GET
    @Path("/with-view")
    @Timed
    @Produces(MediaType.TEXT_HTML)
    public BasicView getWithView() {
        return new BasicView();
    }
}
