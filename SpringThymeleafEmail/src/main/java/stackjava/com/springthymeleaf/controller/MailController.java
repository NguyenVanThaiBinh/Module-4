package stackjava.com.springthymeleaf.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import stackjava.com.springthymeleaf.entities.MailBox;
import stackjava.com.springthymeleaf.service.MailService;

@Controller
public class MailController {

	@Autowired
	MailService mailService;

	@RequestMapping("/")
	public String index(final Model model) throws MessagingException {
		model.addAttribute("mailBox", new MailBox());
		return "index";
	}

	@RequestMapping("/sendEmail")
	public String sendEmail(@ModelAttribute("mailBox") MailBox mailBox, final Model model) throws MessagingException {
		System.out.println("AAAAAAAAAAA");
		mailService.sendEmail(mailBox.getSubject(), mailBox.getMessage(), mailBox.getRecipientEmail());
		return "redirect:/";
	}

}
