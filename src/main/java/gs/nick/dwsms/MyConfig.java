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

    @NotEmpty
    private String dateFormatPattern;

    @NotEmpty
    private String fromPhoneNumber;

    @JsonProperty
    public String getFromPrhoneNumber() {
        return fromPhoneNumber;
    }

    @JsonProperty
    public void setFromPhoneNumber(String phone) {
        fromPhoneNumber = phone;
    }

    @JsonProperty
    public String getDateFormatPattern() {
        return dateFormatPattern;
    }

    @JsonProperty
    public void setDateFormatString(String format) {
        dateFormatPattern = format;
    }

    @JsonProperty
    public String getAppName() {
        return appName;
    }

    @JsonProperty
    public void setAppName(String appName) {
        this.appName = appName;
    }

}
