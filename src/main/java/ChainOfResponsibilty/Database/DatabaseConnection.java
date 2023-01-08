package ChainOfResponsibilty.Database;

import ChainOfResponsibilty.getUserDetails.Consumer;
import com.mongodb.*;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.mongodb.reactivestreams.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class DatabaseConnection {

    public MongoCollection<Document> connect() throws InterruptedException {
        ConnectionString connectionString = new ConnectionString("mongodb+srv://rai-sahil:Tkdcrc987@cluster0.dibrkuh.mongodb.net/?retryWrites=true&w=majority");

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .serverApi(ServerApi.builder()
                        .version(ServerApiVersion.V1)
                        .build())
                .build();

        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("User-Auth");
        MongoCollection<Document> collection = database.getCollection("UserDetails");

        Thread.sleep(5000);
        return collection;
    }

    public void insertDoc (Consumer consumer) throws InterruptedException {
        MongoCollection<Document> collection = connect();

        Document doc = new Document("name", consumer.getName())
                .append("password", consumer.getPassword())
                .append("email", consumer.getEmail());

        collection.insertOne(doc)
                .subscribe(new SubscriberHelpers.OperationSubscriber<InsertOneResult>());
    }

    public void findUser (Consumer consumer) throws InterruptedException {
        MongoCollection<Document> collection = connect();

//        Document doc = (Document) collection.find(eq("email", consumer.getEmail()))
//                .sort(Sorts.ascending(consumer.getName()))
//                .first();


    }
}