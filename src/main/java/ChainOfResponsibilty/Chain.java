package ChainOfResponsibilty;

import ChainOfResponsibilty.Database.DatabaseConnection;
import ChainOfResponsibilty.getUserDetails.Consumer;

public interface Chain {
    void setNextChain (Chain nextChain);
    void procedure (Consumer consumer, DatabaseConnection db) throws InterruptedException;
}
