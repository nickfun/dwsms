/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gs.nick.dwsms.models;

import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import org.codehaus.jackson.map.ObjectMapper;
import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author nick
 */
public class MessageDatabase {

    static class TxtMessageComparator implements Comparator<TxtMessage> {

        public TxtMessageComparator() {
        }

        @Override
        public int compare(TxtMessage t, TxtMessage t1) {
            return t1.send.compareTo(t.send);
        }
    }

    private PriorityQueue<TxtMessage> msgQueue;
    private Logger log;
    private final int max;

    /**
     * Constructor
     * @param max
     */
    public MessageDatabase(int max) {
        msgQueue = new PriorityQueue<>(10, new TxtMessageComparator());
        log = LoggerFactory.getLogger(MessageDatabase.class);
        log.debug("new database object, max is " + max);
        this.max = max;
    }
    
    /**
     * Enqueue a TxtMessage as long as the db is not full
     * @param msg
     * @throws Exception 
     */
    public void add(TxtMessage msg) throws Exception {
        if (msgQueue.size() > max) {
            throw new Exception("Database is full");
        }
        msgQueue.add(msg);
    }
    
    /**
     * Remove a message & return the message if it happens after the passed in date.
     * @param now
     * @return 
     */
    public TxtMessage pop(LocalDateTime now) {
        if (msgQueue.isEmpty()) {
            return null;
        }
        TxtMessage top = msgQueue.peek();
        if (top.send.isAfter(now)) {
            return msgQueue.poll();
        }
        return null;
    }
    
    public Iterator<TxtMessage> iterator() {
        return msgQueue.iterator();
    }
    
    public int size() {
        return msgQueue.size();
    }
    
    public String toJson() throws IOException {
        ObjectMapper oMapper = new ObjectMapper();
        return oMapper.writeValueAsString(msgQueue);
    }
    
    public void saveToFile(String fileName) {
        log.error("database save is not implemented");
    }
    
    public void loadFromFile(String filename) {
        log.error("database load hasnt been written yet sorry buddy");
    }

}
