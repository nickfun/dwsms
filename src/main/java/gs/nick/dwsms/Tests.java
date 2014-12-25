package gs.nick.dwsms;

import gs.nick.dwsms.models.MessageDatabase;
import gs.nick.dwsms.models.TxtMessage;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Hey guess who forgot to add jUnit to the pom before he went out of town & has
 * no internet?
 *
 * yay
 *
 * @author nick
 */
public class Tests {

    public static void main(String[] args) throws Exception {
        Tests t = new Tests();
        t.testDbOrder();
        t.testRemoval();
        t.testDateFormats();
    }

    public void testDateFormats() {
        System.out.println("testDateFormats");
        DateTimeFormatter frm = DateTimeFormat.forPattern("YYYY-MM-dd HH:mm:ss");
        String testDateStr = "2014-12-24 17:58:57";
        LocalDateTime date = frm.parseLocalDateTime(testDateStr);
        TEST(date.getYear() == 2014, "year is 2014");
        TEST(date.getMonthOfYear() == 12, "month is 12 -- " + date.getMonthOfYear());
        TEST(date.getDayOfMonth() == 24, "day is 24");
        TEST(date.getHourOfDay() == 17, "hour is 17");
        TEST(date.getMinuteOfHour() == 58, "minute is 58");
        TEST(date.getSecondOfMinute() == 57, "second is 57");
    }

    public static void TEST(boolean result, String msg) {
        if (result) {
            System.out.println("PASS: ___ " + msg);
        } else {
            System.out.println("FAIL: *** " + msg);
            throw new RuntimeException("TEST failed: " + msg);
        }
    }

    public void testRemoval() throws Exception {
        System.out.println("testRemoval");
        MessageDatabase db = new MessageDatabase(20);
        TxtMessage msg;
        msg = new TxtMessage();
        msg.send = LocalDateTime.now();
        db.add(msg);
        msg = new TxtMessage();
        msg.send = LocalDateTime.now().minusDays(20);
        db.add(msg);
        msg = new TxtMessage();
        msg.send = LocalDateTime.now().minusDays(30);
        db.add(msg);
        msg = new TxtMessage();
        msg.send = LocalDateTime.now().minusDays(40);
        db.add(msg);
        TEST(4 == db.size(), "size should be 4");
        db.pop(LocalDateTime.now());
        TEST(3 == db.size(), "size should be 3");
    }

    public void testDbOrder() throws Exception {
        System.out.println("testDbOrder");
        MessageDatabase db = new MessageDatabase(4);
        TxtMessage m1 = new TxtMessage();
        m1.send = LocalDateTime.now();
        TxtMessage m2 = new TxtMessage();
        m2.send = LocalDateTime.now().minusMinutes(30);
        TxtMessage m3 = new TxtMessage();
        m3.send = LocalDateTime.now().minusYears(2);

        db.add(m2);
        db.add(m3);
        // i expect m2 to be returned on pop
        TxtMessage top = db.pop(LocalDateTime.now());
        TEST(top != null, "Top should not be null");
        System.out.println("m2 date is: " + m2.send.toString());
        System.out.println("top date is: " + top.send.toString());
        TEST(m2.send.equals(top.send), "top should be m2");

    }
}
