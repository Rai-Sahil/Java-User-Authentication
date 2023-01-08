package org.example;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.mongodb.reactivestreams.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class DatabaseConnection {

    String name;
    String email;
    String password;

    DatabaseConnection (String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void connect() throws InterruptedException {
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

    }

    public boolean findUser (String email) throws InterruptedException {
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

        Document doc = null;
        doc = (Document) collection.find(eq("email", email))
                .first();

        if(doc == null)return false;
        else return true;
    }
}