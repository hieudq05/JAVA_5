package org.labpoly.lab7.service.mailer;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.labpoly.lab7.model.Mailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class MailerServiceImp implements MailerService{

    @Autowired
    private JavaMailSender mailSender;
    Queue<MimeMessage> queue = new ConcurrentLinkedQueue<MimeMessage>();

    @Override
    public void send(Mailer mailer) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setTo(mailer.getTo());
        helper.setFrom(mailer.getFrom());
        helper.setSubject(mailer.getSubject());
        helper.setText(mailer.getBody(), true);
        helper.setReplyTo(mailer.getFrom());

        if(mailer.getCc() != null) {
            for(String email: mailer.getCc()){
                helper.addCc(email);
            }
        }

        if(mailer.getBcc() != null) {
            for(String email: mailer.getBcc()){
                helper.addBcc(email);
            }
        }

        if(mailer.getAttachments() != null) {
            for (File file : mailer.getAttachments()) {
                helper.addAttachment(file.getName(), file);
            }
        }

        queue.add(mimeMessage);
    }

    @Async
    @Override
    public void send(String to, String subject, String body) throws MessagingException {
        Mailer m = new Mailer(to, subject, body);
        this.send(m);
    }

    @Override
    @Scheduled(fixedRate = 1000)
    public void run(){
        int success = 0, error = 0;
        while(!queue.isEmpty()){
            MimeMessage mimeMessage = queue.poll();
            try {
                mailSender.send(mimeMessage);
                success++;
            } catch (Exception e) {
                error++;
            }
        }
        System.out.println("Success: " + success + " error: " + error);
    }
}
