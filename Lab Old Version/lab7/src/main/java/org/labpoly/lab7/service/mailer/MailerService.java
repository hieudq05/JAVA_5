package org.labpoly.lab7.service.mailer;

import jakarta.mail.MessagingException;
import org.labpoly.lab7.model.Mailer;

public interface MailerService {
    void send(Mailer mailer) throws MessagingException;

    void send(String to, String subject, String body) throws MessagingException;

    void run();
}
