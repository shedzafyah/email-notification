package zw.co.afrosoft.emailnotification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zw.co.afrosoft.emailnotification.domain.Mail;
import zw.co.afrosoft.emailnotification.service.SendMailService;

@RestController
@RequestMapping("/api/v1/email")
public class EmailController {

    SendMailService mailService;

    @Autowired
    public EmailController(SendMailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendMail(@RequestBody Mail mail){
        mailService.sendMail(mail);
        return new ResponseEntity<>("Email was successfully sent", HttpStatus.OK);
    }
}
