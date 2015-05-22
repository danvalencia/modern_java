package com.danielvalencia;


import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Test;
import rx.Observable;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    @Test
    public void shouldTestStreams()
    {
        TodoItem todo1 = new TodoItem("First Item", LocalDateTime.now(), false);
        TodoItem todo2 = new TodoItem("Second Item", LocalDateTime.now(), false);
        TodoItem todo3 = new TodoItem("Third Item", LocalDateTime.now(), false);
        TodoItem todo4 = new TodoItem("Fourth Item", LocalDateTime.now(), false);

        TodoList todoList = new TodoList(todo1, todo2, todo3, todo4);

        Observable.from(todoList).subscribe((todo) -> {
            System.out.println(String.format("Hello %s", todo.getDescription()));
        });

        List<String> descriptions = todoList.stream().map((toDo) -> toDo.getDescription()).collect(toList());

        List<TodoItem> filteredList = todoList.stream().filter((toDo) -> toDo.getDescription().contains("Third")).collect(toList());

        assertEquals(filteredList.get(0), todo3);
    }

    @Test
    public void shouldConnectToMongoDB()
    {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("mydb");
        MongoCollection<Document> collection = database.getCollection("todos");

        assertNotNull(collection);

        collection.find().forEach((Block<Document>) document -> System.out.println(document));
    }

    @Test
    public void futureTest()
    {
        List<String> info = Arrays.asList("Hola");

        ExecutorService executorService = null;

        final Callable<List<String>> task = () ->
          info.stream()
            	.map(String::toUpperCase)
            	.collect(Collectors.toList());

        // submit download task to the executor
        Future<List<String>> images = executorService.submit(task);
    }
}
