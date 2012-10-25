package com.communityslaagent.services;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailService {

    private static MailService ms = null;

    public MailService() {
        ms = new MailService();
    }
    
    public void sendEmail(String mailToAddress, String subject, String messageText) {
        
        Properties props = PropertiesService.getInstance().getProperties();
        String host = props.getProperty("smtp.host"), 
                username = props.getProperty("smtp.username"), 
                password = props.getProperty("smtp.password"), 
                addressFrom = props.getProperty("smtp.sentfrom.address"),result = "";
        int port = Integer.parseInt(props.getProperty("smtp.port"));
   
        Session session = Session.getInstance(props);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username, addressFrom));
            message.setSubject(subject);
            message.setText(messageText);
            Transport transport = session.getTransport("smtp");
            try {
                transport.connect(host, port, username, password);
            } catch (Exception e) {
                e.printStackTrace();
                result = e.toString();
                System.out.println("connection refused");
            }

            transport.sendMessage(message, InternetAddress.parse(mailToAddress));

            result = "Ok";

        } catch (UnsupportedEncodingException ex) {
            result = ex.toString();
        } catch (MessagingException e) {
            result = e.toString();
            throw new RuntimeException(e);
        } finally {
            System.out.println("mailto: " + mailToAddress + "   result: " + result);
        }
    }

    public static MailService getInstance() {
        if (ms == null){
            new MailService();
        }
        return ms;
    }
    
    
}