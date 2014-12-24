package gs.nick.dwsms;

import com.codahale.metrics.health.HealthCheck;
import gs.nick.dwsms.models.MessageDatabase;
import gs.nick.dwsms.models.TimerManager;
import gs.nick.dwsms.resources.IndexResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.lifecycle.Managed;
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
    public void run(MyConfig appConfig, Environment e) throws Exception {
        log.info("app begins");
        log.info("java is" + System.getProperty("java.version"));
        final MessageDatabase db = new MessageDatabase(9999);
        e.jersey().register(new IndexResource(appConfig, db));
        e.healthChecks().register("dummy", new HealthCheck() {
            
            @Override
            protected HealthCheck.Result check() throws Exception {
                log.debug("Dummy health check is run");
                return Result.healthy();
            }
        });
        e.lifecycle().manage(new Managed() {
            
            @Override
            public void start() throws Exception {
                db.loadFromFile("startup-database.txt");
            }
            
            @Override
            public void stop() throws Exception {
                db.saveToFile("shutdown-database.txt");
            }
        });
        e.lifecycle().manage(new TimerManager(appConfig.getFrequency()));
    }
}
