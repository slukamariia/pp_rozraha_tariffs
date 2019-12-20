package tariffs.metaInf;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;


public class EmailSender {

    private static final String MAIL_PROPERTIES = "mail.properties";
    private static final String FILE_PATH = "log/application.log";
    private static final String SUBJECT = "Tax logs";
    private static final String USER = "java_developer_tester_2019@yahoo.com";
    private static final String PASSWORD = "uberhurqemrixxxt";
    private static final String RECIPIENT = "<recipient>@gmail.com";

    public void sendLogEmail() {

        try {
            final Properties properties = new Properties();
            properties.load(this.getClass().getClassLoader().getResourceAsStream(MAIL_PROPERTIES));

            Session mailSession = Session.getDefaultInstance(properties);
            MimeMessage message = new MimeMessage(mailSession);
            message.setFrom(new InternetAddress(USER));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(RECIPIENT));
            message.setSubject(SUBJECT);

            DataSource source = new FileDataSource(FILE_PATH);
            message.setDataHandler(new DataHandler(source));
            message.setFileName(FILE_PATH);

            Transport transport = mailSession.getTransport();
            transport.connect(USER, PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

        } catch (IOException | MessagingException e) {
            e.printStackTrace();
        }


    }

}