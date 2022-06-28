package thehv.controller;

import java.util.Arrays;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class ApiController {
    @Autowired
    Environment environment;

    @GetMapping("/testEnv")
    public Object testEnv() {
        Map<String, String> envs = System.getenv();
        return envs;
    }

    @GetMapping("/sayHello")
    public Object sayHello() {
        return "sayHello";
    }

    @Autowired
    public JavaMailSender emailSender;

    @GetMapping("/testSendMail")
    public Object testSendMail() {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            message.setSubject("MAIL_SUBJECT");
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("MY REPORT <report@k-media.vn>");
            for (String mail : Arrays.asList("a1@gmail.com", "a2@gmail.com")) {
                helper.addTo(mail);
            }
            helper.setText("MAIL_CONTENT", true);
            emailSender.send(message);
            return "DONE";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return "FAILURE";
        }
    }
}