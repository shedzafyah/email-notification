package zw.co.afrosoft.emailnotification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import zw.co.afrosoft.emailnotification.domain.Mail;

import javax.mail.MessagingException;

@Service
public class SendMailServiceImpl implements SendMailService{

    private final JavaMailSender javaMailSender;

    @Autowired
    public SendMailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendMail(Mail mail) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(mail.getRecipient());
        msg.setSubject(mail.getSubject());
        msg.setText(mail.getMessage());
        javaMailSender.send(msg);

    }

    @Override
    public void sendMailAttachment(Mail mail) throws MessagingException {

    }
}
