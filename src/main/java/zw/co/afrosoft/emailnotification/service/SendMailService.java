package zw.co.afrosoft.emailnotification.service;

import zw.co.afrosoft.emailnotification.domain.Mail;

import javax.mail.MessagingException;
public interface SendMailService {

    void sendMail(Mail mail);

    void sendMailAttachment(Mail mail) throws MessagingException;

}
