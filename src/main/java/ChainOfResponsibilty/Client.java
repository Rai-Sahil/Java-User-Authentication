package ChainOfResponsibilty;

import ChainOfResponsibilty.Database.DatabaseConnection;
import ChainOfResponsibilty.Register.RegisterUser;
import ChainOfResponsibilty.getUserDetails.Consumer;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Chain getDetails = new Consumer();
        Chain register = new RegisterUser();

        getDetails.setNextChain(register);

        Consumer consumer = new Consumer();
        DatabaseConnection db = new DatabaseConnection();
        getDetails.procedure(consumer, db);
    }
}
