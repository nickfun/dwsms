/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gs.nick.dwsms.resources;

import com.codahale.metrics.annotation.Timed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
}
