package com.danielvalencia;

import java.util.ArrayList;

import static java.util.Arrays.*;

/**
 * @author Daniel Valencia (daniel@tacitknowledge.com)
 */
public class TodoList extends ArrayList<TodoItem>
{
    public TodoList(TodoItem... todoItems)
    {
        super(asList(todoItems));
    }
}
