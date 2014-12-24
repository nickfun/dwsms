
package gs.nick.dwsms;

import io.dropwizard.Configuration;
import org.codehaus.jackson.annotate.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author nick
 */
public class MyConfig extends Configuration {
    
    @NotEmpty
    private String appName;

    @JsonProperty
    public String getAppName() {
        return appName;
    }

    @JsonProperty
    public void setAppName(String appName) {
        this.appName = appName;
    }
    
}
