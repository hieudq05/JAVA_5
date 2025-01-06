package org.labpoly.lab7.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.labpoly.lab7.service.mailer.MailConstant;

import java.io.File;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mailer {
    String from;
    String to;
    String[] cc;
    String[] bcc;
    String subject;
    String body;
    File[] attachments;

    public Mailer(String to, String subject, String body) {
        this.from = MailConstant.MAIL_FROM;
        this.to = to;
        this.subject = subject;
        this.body = body;
    }
}
