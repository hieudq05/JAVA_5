package org.labpoly.lab7.controller;

import jakarta.mail.MessagingException;
import org.labpoly.lab7.service.mailer.MailerService;
import org.labpoly.lab7.service.mailer.MailerServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("email")
public class MailController {

    private final MailerService mailerService;

    public MailController(MailerService mailerService) {
        this.mailerService = mailerService;
    }

    @GetMapping("send")
    @ResponseBody
    public String sendMail() throws MessagingException {
        mailerService.send("hieuu8a@gmail.com", "test for hieuu8a@gmail.com", "This mail hasn't content");
        mailerService.send("duongquochieu2005@gmail.com", "test for duongquochieu2005@gmail.com", "This mail hasn't content");
        mailerService.run();
        return "mail";
    }
}
