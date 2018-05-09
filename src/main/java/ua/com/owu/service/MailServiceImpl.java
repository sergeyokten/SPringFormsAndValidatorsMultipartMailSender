package ua.com.owu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import ua.com.owu.entity.User;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements MainService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(User user) {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        try {
            helper.setTo(user.getEmail());
            helper.setText("<h3>hello dear user with email " + user.getEmail() + " </h3>," +
                    "visit our <a href = 'http://owu.com.ua'>SITE </a> ", true);
            helper.setFrom("sergey.okten@gmail.com"); //!!!!!

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        javaMailSender.send(mimeMessage);

    }
}

