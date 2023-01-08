package ChainOfResponsibilty.Register;


import ChainOfResponsibilty.Chain;
import ChainOfResponsibilty.Database.DatabaseConnection;
import ChainOfResponsibilty.getUserDetails.Consumer;

public class checkStatus implements Chain {
    Chain nextInChain;

    @Override
    public void setNextChain(Chain nextChain) {
        this.nextInChain = nextChain;
    }

    @Override
    public void procedure(Consumer consumer, DatabaseConnection db) throws InterruptedException {
        try {
            nextInChain.procedure(consumer, db);
        } catch ( Exception e ){
            System.out.print("User Already Exist...");
        }
    }
}
