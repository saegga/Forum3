package mypackage;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by sergei on 18.03.2015.
 */
public class SendMail {
    public void sendMail(String name, String pass, String email) {

        PropertiesMy propertiesMy = new PropertiesMy();
        final Properties props = propertiesMy.getProp();
        props.setProperty("email", email);
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(
                                props.getProperty("username"),
                                props.getProperty("passwordSend"));
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(props.getProperty("email")));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(props.getProperty("email")));
            message.setSubject("тест");
            message.setText("Вы зарегестрировались на форуме" + "\n" +
                    "Ваш Логин: " + name + "\n" +
                    "Ваш Пароль " + pass);

            Transport.send(message);
            System.out.println("Done");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}