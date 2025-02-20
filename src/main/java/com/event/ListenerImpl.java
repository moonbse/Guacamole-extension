package com.event;


import org.apache.guacamole.GuacamoleException;
import org.apache.guacamole.net.event.AuthenticationFailureEvent;
import org.apache.guacamole.net.event.AuthenticationSuccessEvent;
import org.apache.guacamole.net.event.TunnelCloseEvent;
import org.apache.guacamole.net.event.listener.Listener;

import java.util.logging.Logger;



public class ListenerImpl implements Listener {

    public ListenerImpl(){
        System.out.println("....initialising BastillionGuacamoleListener....");
    }

    private static final Logger logger = Logger.getLogger(ListenerImpl.class.getName());

    @Override
    public void handleEvent(Object event) throws GuacamoleException {
        System.out.println("handlingEvent::"+event);
        if (event instanceof AuthenticationSuccessEvent) {
            System.out.println("Session starting....");
            AuthenticationSuccessEvent authEvent = (AuthenticationSuccessEvent) event;
            String username = authEvent.getCredentials().getUsername();
            logger.info("Session started - User: {}, Time: {}" +  username + new java.util.Date());
        }
        else if (event instanceof AuthenticationFailureEvent) {
            AuthenticationFailureEvent failureEvent = (AuthenticationFailureEvent) event;
            logger.info("Failed authentication for user {}" + failureEvent.getCredentials().getUsername());
        }
        else if (event instanceof TunnelCloseEvent) {
            TunnelCloseEvent closeEvent = (TunnelCloseEvent) event;
            logger.info("logging:: closeEvent::"+closeEvent.toString());
            String username = closeEvent.getCredentials().getUsername();
            logger.info("username::"+username);

            // Extract session details


            // Log event details
//            logger.info("Session ended - Details:" +
//                    "\nUser: {}" +
//                    "\nFrom IP: {}" +
//                    "\nUser Agent: {}" +
//                    "\nTarget Host: {}" +
//                    "\nProtocol: {}" +
//                    "\nEnd Time: {}" +
//                    username+ clientIP+ userAgent+targetHost+ protocol+ new java.util.Date());
        }
    }
}
