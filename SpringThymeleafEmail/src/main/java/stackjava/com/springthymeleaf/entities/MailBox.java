package stackjava.com.springthymeleaf.entities;

public class MailBox {
	private String subject;
	private String message;
	private String recipientEmail;

	public MailBox() {
	}

	public MailBox(String subject, String message, String recipientEmail) {
		this.subject = subject;
		this.message = message;
		this.recipientEmail = recipientEmail;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRecipientEmail() {
		return recipientEmail;
	}

	public void setRecipientEmail(String recipientEmail) {
		this.recipientEmail = recipientEmail;
	}

}
