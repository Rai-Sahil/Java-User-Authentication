package ChainOfResponsibilty.getUserDetails;

import ChainOfResponsibilty.Chain;
import ChainOfResponsibilty.Database.DatabaseConnection;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Consumer implements Chain {

    private static String name;
    private static String email = "";
    private static String password;
    Chain nextInChain;


    public String getName() { return name; }

    public void setName(String name) { Consumer.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { Consumer.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { Consumer.password = password; }


    @Override
    public void setNextChain(Chain nextChain) {
        this.nextInChain = nextChain;
    }

    public boolean checkUserEmail (String email) {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";

        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(email);
        return match.matches();
    }

    @Override
    public void procedure(Consumer consumer, DatabaseConnection db) throws InterruptedException {
        Scanner scan = new Scanner(System.in);

        //Get User Name
        System.out.println("Please Type Your Name...");
        consumer.setName(scan.nextLine());

        //Get User Email
        while (!consumer.checkUserEmail(consumer.getEmail())){
            System.out.println("Please Type Your Email...");
            consumer.setEmail(scan.nextLine());
        }

        //Get User password
        System.out.println("Please Type Your Password...");
        consumer.setPassword(scan.nextLine());

        nextInChain.procedure(consumer, db);
    }
}
