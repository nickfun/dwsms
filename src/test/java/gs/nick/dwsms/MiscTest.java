package gs.nick.dwsms;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author nickf
 */
public class MiscTest {
	
	@Test
	public void testDateFormats() {
		System.out.println("testDateFormats");
        DateTimeFormatter frm = DateTimeFormat.forPattern("YYYY-MM-dd HH:mm:ss");
        String testDateStr = "2014-12-24 17:58:57";
        LocalDateTime date = frm.parseLocalDateTime(testDateStr);
        assertTrue(date.getYear() == 2014);
        assertTrue(date.getMonthOfYear() == 12);
        assertTrue(date.getDayOfMonth() == 24);
        assertTrue(date.getHourOfDay() == 17);
        assertTrue(date.getMinuteOfHour() == 58);
        assertTrue(date.getSecondOfMinute() == 57);
	}

}
