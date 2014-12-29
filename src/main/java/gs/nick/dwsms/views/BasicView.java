package gs.nick.dwsms.views;

import io.dropwizard.views.View;

/**
 *
 * @author nick
 */
public class BasicView extends View {

    private String dateFormat;

    public BasicView() {
        super("basic-view.ftl");
    }

    public BasicView(String file) {
        super(file);
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

}
