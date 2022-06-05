package pl.emailSender.SpringEmailDemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;


@Slf4j
@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(String toEmail,String subject,String body)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("java.bank.system@gmail.com"); //Password: JavaBankSystem*
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);
        log.info("Mail sent successfully. Mail body: ");
        log.info(body);
    }

    public void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);

        mimeMessageHelper.setFrom("java.bank.system@gmail.com");
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(text);



        FileSystemResource fileSystem = new FileSystemResource(pathToAttachment);

        File outputFile = fileSystem.getFile();
        if(outputFile.exists())
        {
            mimeMessageHelper.addAttachment(outputFile.getName(), outputFile);
            mailSender.send(mimeMessage);
            log.info("Mail with attachment sent successfully. Mail body: ");
            log.info(text);
        } else {
            log.info("Mail with attachment was not sent. Wrong attachment path");
        }
    }
}
