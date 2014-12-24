package gs.nick.dwsms;

import gs.nick.dwsms.models.MessageDatabase;
import gs.nick.dwsms.models.TxtMessage;
import org.joda.time.LocalDateTime;

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
    }
    
    public void assertz(boolean test, String msg) {
        if (!test) {
            throw new RuntimeException("assert fail: " + msg);
        }
    }

    public void testDbOrder() throws Exception {
        System.out.println("testDbOrder");
        MessageDatabase db = new MessageDatabase(4);
        TxtMessage m1 = new TxtMessage();
        m1.send = LocalDateTime.now();
        TxtMessage m2 = new TxtMessage();
        m2.send = LocalDateTime.now().minusMinutes(400);
        TxtMessage m3 = new TxtMessage();
        m3.send = LocalDateTime.now().minusYears(2);

        db.add(m2);
        db.add(m3);
        // i expect m2 to be returned on pop
        TxtMessage top = db.pop(LocalDateTime.now());
        assert(top.send.equals(m2));
        
    }
}
