package com.danielvalencia.repositories;

import com.danielvalencia.model.Comment;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;
import rx.Observable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Daniel Valencia (daniel@tacitknowledge.com)
 */
public class CommentsRepository implements Repository<Comment>
{

    private static final String COMMENTS = "comments";
    private MongoDatabase database;

    public CommentsRepository()
    {
        MongoClient mongoClient = new MongoClient();
        database = mongoClient.getDatabase("mydb");
    }

    @Override
    public Observable<Comment> findAll(Integer limit)
    {
        return Observable.create(subscriber -> {
            MongoCollection<Document> collection = database.getCollection(COMMENTS);

            for (final Document doc: collection.find()) {
                subscriber.onNext(new Comment(doc.getString("author"), doc.getString("text")));
            }
            subscriber.onCompleted();
        });
    }

    @Override
    public Observable<Comment> findByName(String name)
    {
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    @Override
    public Boolean add(Comment comment)
    {
        if (comment.getAuthor() == null || comment.getText() == null) {
            return false;
        }

        MongoCollection<Document> commentsCollection = database.getCollection(COMMENTS);
        Document commentDocument = new Document();
        commentDocument.put("author", comment.getAuthor());
        commentDocument.put("text", comment.getText());
        commentsCollection.insertOne(commentDocument);
        return true;
    }

    @Override
    public Observable<Comment> findById(String id)
    {
        throw new UnsupportedOperationException("Not Implemented Yet");
    }
}
