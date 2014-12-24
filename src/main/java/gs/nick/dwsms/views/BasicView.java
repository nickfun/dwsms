package gs.nick.dwsms.views;

import io.dropwizard.views.View;

/**
 *
 * @author nick
 */
public class BasicView extends View {
    
    public BasicView() {
        super("basic-view.ftl");
    }
    
    public BasicView(String file) {
        super(file);
    }

}
