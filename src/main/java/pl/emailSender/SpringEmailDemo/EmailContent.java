package pl.emailSender.SpringEmailDemo;


import java.sql.Timestamp;

public class EmailContent {

    public String getDebtMessage(String User, int accountBalance)
    {
        long miliseconds = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(miliseconds);
        return "Hello " + User + ".\n\n" +
                "Your account balance is currently " + accountBalance +"zł. Our bank will charge interest " +
                "for debit bigger than -1000zł. The amount of interest is 10% per year for every amount of "+
                "money that exceeds our debit limit of -1000zł.\nIf you have any questions feel free to contact " +
                "our support department at java.bank.system@gmail.com.\n\n" + "Message was generated at " + timestamp +
                " by JavaBankSystem";
    }

    public String getLoanMessage(String User)
    {
        long miliseconds = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(miliseconds);
        String text = "Hello " + User + ".\n\n" +
                "We would like to offer you loan in our bank. RRSO of loan is 10%. Maxium amount is 10000zł.\n" +
                "If you have any questions feel free to contact our support department at java.bank.system@gmail.com.\n\n"
                + "Message was generated at " + timestamp + " by JavaBankSystem";
        return text;
    }
}
