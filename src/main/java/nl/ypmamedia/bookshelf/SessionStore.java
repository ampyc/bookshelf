/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ypmamedia.bookshelf;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Christiaan
 */
@SessionScoped
@Named
public class SessionStore implements Serializable{
     public static AtomicLong INSTANCE_COUNT = new AtomicLong(0);
    
    private String payload;
    
    @PostConstruct
    public void onNewSession(){
        INSTANCE_COUNT.incrementAndGet();
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    @PreDestroy
    public void onSessionDestruction(){
        INSTANCE_COUNT.decrementAndGet();
    }
}
