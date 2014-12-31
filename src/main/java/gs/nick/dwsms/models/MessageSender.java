package gs.nick.dwsms.models;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.LoggerFactory;

/**
 * Utility class to handle the sending of text messages via Twilio
 *
 * @author nick
 */
public class MessageSender {

    private static final Logger log = LoggerFactory.getLogger(MessageSender.class);

    private static TwilioRestClient client = null;

    public static void setAuth(String ACCOUNT_SID, String AUTH_TOKEN) {
        if (ACCOUNT_SID == null || AUTH_TOKEN == null) {
            log.error("AUTH NOT SET, this is probally what you want since I'm offline and cant talk to twilio API");
            return;
        }
        client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
        log.debug("Twilio Client created");
    }

    public static boolean dummy_sendMessage(TxtMessage msg) {
        log.info("MESSAGE SENT!! " + msg.body);
        return true;
    }

    public static boolean sendMessage(TxtMessage msg) {
        // copy pasta from 
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("Body", msg.body));
        params.add(new BasicNameValuePair("To", msg.to));
        params.add(new BasicNameValuePair("From", msg.from));
        MessageFactory messageFactory = client.getAccount().getMessageFactory();
        Message message;
        try {
            message = messageFactory.create(params);
            log.info("message sent, SID: " + message.getSid());
            return true;
        } catch (TwilioRestException ex) {
            log.error("Can not send message!", ex);
            return false;
        }
    }

}
