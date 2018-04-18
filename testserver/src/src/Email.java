import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class Email {

public static void main(String [] args) {    
   // Recipient's email ID needs to be mentioned.
   String to = "theater_3@outlook.com";

   // Sender's email ID needs to be mentioned
   String from = "theater_3@outlook.com";

   // Assuming you are sending email from localhost
   String host = "localhost";

   // Get system properties
   Properties properties = System.getProperties();

   properties.setProperty("mail.user", "theater_3@outlook.com");
   properties.setProperty("mail.password", "securePassword");
   
   // Setup mail server
   properties.setProperty("mail.smtp.host", host);

   // Get the default Session object.
   Session session = Session.getDefaultInstance(properties);

   try {
      // Create a default MimeMessage object.
      MimeMessage message = new MimeMessage(session);

      // Set From: header field of the header.
      message.setFrom(new InternetAddress(from));

      // Set To: header field of the header.
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

      // Set Subject: header field
      message.setSubject("Register Confirmation");

      // Now set the actual message
      message.setText("Click this link to confirm registration (add link here)");

      // Send message
      Transport.send(message);
      System.out.println("Sent message successfully....");
   } catch (MessagingException mex) {
      mex.printStackTrace();
   }
}
}