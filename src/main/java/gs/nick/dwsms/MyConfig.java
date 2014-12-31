package gs.nick.dwsms;

import io.dropwizard.Configuration;
import javax.validation.constraints.NotNull;
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

    @NotNull
    private Integer frequency;

    @NotNull
    private Integer maxLength;

    @NotEmpty
    private String fromPhoneNumber;

    @NotNull
    private String twilioApiAccount;

    @NotNull
    private String twilioApiToken;

    @JsonProperty
    public String getTwilioApiToken() {
        return twilioApiToken;
    }

    @JsonProperty
    public void setTwilioApiToken(String token) {
        twilioApiToken = token;
    }

    @JsonProperty
    public String getTwilioApiAccount() {
        return twilioApiAccount;
    }

    @JsonProperty
    public void setTwilioApiAccount(String account) {
        twilioApiAccount = account;
    }

    @JsonProperty
    public Integer getFrequency() {
        return frequency;
    }

    @JsonProperty
    public void setFrequency(Integer fromfile) {
        frequency = fromfile;
    }

    @JsonProperty
    public String getFromPhoneNumber() {
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

    public Integer getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }
}
