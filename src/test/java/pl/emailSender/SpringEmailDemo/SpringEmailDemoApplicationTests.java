package pl.emailSender.SpringEmailDemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

@SpringBootTest
class SpringEmailDemoApplicationTests  {

	@Test
	public void emailContentMessagesTest() {
		EmailContent emailContent = new EmailContent();
		long miliseconds = System.currentTimeMillis();
		Timestamp timestamp = new Timestamp(miliseconds);
		assert(emailContent.getDebtMessage("Janusz",-500) == "Hello Janusz.\n\n" +
				"Your account balance is currently -500zł. Our bank will charge interest " +
				"for debit bigger than -1000zł. The amount of interest is 10% per year for every amount of "+
				"money that exceeds our debit limit of -1000zł.\nIf you have any questions feel free to contact " +
				"our support department at java.bank.system@gmail.com.\n\n" + "Message was generated at " + timestamp +
				" by JavaBankSystem");
	}

}
