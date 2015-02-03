package gs.nick.dwsms.models;

import java.util.Objects;
import org.joda.time.LocalDateTime;

/**
 *
 * @author nick
 */
public class TxtMessage {

    public String to;
    public String from;
    public String body;
    public LocalDateTime send;

    public boolean isValid() {
        return send != null
                && to != null
                && from != null
                && body != null
                && body.length() <= 160;
    }

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 47 * hash + Objects.hashCode(this.to);
		hash = 47 * hash + Objects.hashCode(this.from);
		hash = 47 * hash + Objects.hashCode(this.body);
		hash = 47 * hash + Objects.hashCode(this.send);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final TxtMessage other = (TxtMessage) obj;
		if (!Objects.equals(this.to, other.to)) {
			return false;
		}
		if (!Objects.equals(this.from, other.from)) {
			return false;
		}
		if (!Objects.equals(this.body, other.body)) {
			return false;
		}
		if (!Objects.equals(this.send, other.send)) {
			return false;
		}
		return true;
	}
	
}
