package ChainOfResponsibilty.Register;

import ChainOfResponsibilty.Chain;
import ChainOfResponsibilty.Database.DatabaseConnection;
import ChainOfResponsibilty.getUserDetails.Consumer;

public class RegisterUser implements Chain {

    Chain nextInChain;

    @Override
    public void setNextChain(Chain nextChain) {
        this.nextInChain = nextChain;
    }

    @Override
    public void procedure(Consumer consumer, DatabaseConnection db) throws InterruptedException {
        db.insertDoc(consumer);
    }
}
