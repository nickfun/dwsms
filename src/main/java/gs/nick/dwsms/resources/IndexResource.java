package gs.nick.dwsms.resources;

import com.codahale.metrics.annotation.Timed;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import gs.nick.dwsms.MyConfig;
import gs.nick.dwsms.models.MessageDatabase;
import gs.nick.dwsms.models.TxtMessage;
import gs.nick.dwsms.views.BasicView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.map.ObjectMapper;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author nick
 */
@Path("/")
public class IndexResource {

    private Logger log;
    private MyConfig config;
    private DateTimeFormatter dateFormatter;
    private MessageDatabase txtDb;

    public IndexResource(MyConfig appConfig, MessageDatabase db) {
        log = LoggerFactory.getLogger(IndexResource.class);
        config = appConfig;
        dateFormatter = DateTimeFormat.forPattern(config.getDateFormatPattern());
        txtDb = db;
    }

    @GET
    @Timed
    @Produces(MediaType.TEXT_HTML)
    public BasicView getPage() {
        log.info("getPage happened");
        BasicView view = new BasicView("submit.ftl");
        view.setDateFormat(config.getDateFormatPattern());
        return view;
    }

    @POST
    @Path("/submit")
    @Timed
    @Produces(MediaType.TEXT_HTML)
    public Response onSubmit(
            @FormParam("to") String to,
            @FormParam("date") String date,
            @FormParam("body") String body
    ) throws IOException {
        log.info("/submit happened");
        log.debug("to is: " + to);
        log.debug("date is: " + date);
        log.debug("body is: " + body);
        ObjectMapper oMapper = new ObjectMapper();
        TxtMessage msg = new TxtMessage();
        msg.body = body;
        msg.from = "+15104612710";
        msg.to = to;
        if (date != null) {
            msg.send = LocalDateTime.parse(date, dateFormatter);
        }
        int status=200;
        String responseBody;
        if (msg.isValid()) {
            responseBody = oMapper.writeValueAsString(msg);
            try {
                txtDb.add(msg);
            } catch (Exception ex) {
                log.error("Trying to add when database full", ex);
                responseBody = "{\"msg\":\"the database is full\"}";
                status=500;
            }
        } else {
            responseBody = "{\"msg\":\"msg object is not valid\"}";
            status=400;
        }
        return Response.status(status).entity(responseBody).build();
    }

    @GET
    @Path("/sms")
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    public String getMessages() throws IOException {
        return txtDb.toJson();
    }

    @GET
    @Path("/with-view")
    @Timed
    @Produces(MediaType.TEXT_HTML)
    public BasicView getWithView() {
        return new BasicView();
    }
}
