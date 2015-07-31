package br.com.java.kernel.util;

import javax.mail.internet.MimeMessage;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

public class EmailUtil {

	private JavaMailSender mailSender;
	
	public EmailUtil(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
	
	
	public boolean sendEmail(final String text, final String subject, final String to) {

        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper mmhelper = new MimeMessageHelper(mimeMessage, true, "ISO-8859-1");
                mmhelper.setTo(to);
                mmhelper.setSubject(subject);
                mmhelper.setText(text, false);
            }
        };

        //Tenta enviar o email 3 vezes, para evitar timeout
        for(int ind = 0; ind < 3; ind++) {
            try {
                mailSender.send(preparator);
                return true;
            } catch (MailException ex) {
                ex.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
	
}
