package gs.nick.dwsms;

import gs.nick.dwsms.resources.IndexResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebApplication extends Application<MyConfig> {
    
    private static Logger log;

    public static void main(String[] args) throws Exception {
        log = LoggerFactory.getLogger(WebApplication.class);
        new WebApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<MyConfig> btstrp) {
        btstrp.addBundle(new ViewBundle());
        btstrp.addBundle(new AssetsBundle("/public"));
    }

    @Override
    public void run(MyConfig t, Environment e) throws Exception {
        log.info("app begins");
        log.info("java is" + System.getProperty("java.version"));
        e.jersey().register(new IndexResource());
    }
}
