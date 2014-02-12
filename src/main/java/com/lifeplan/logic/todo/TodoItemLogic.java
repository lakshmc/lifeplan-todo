package com.lifeplan.logic.todo;

import com.lifeplan.models.TodoItem;

import java.util.List;

/**
 * Created on 2/10/14.
 */
public interface TodoItemLogic {
    List<TodoItem> getTodoItems();
    TodoItem getTodoItem(String id);
    void createTodoItems(TodoItem item);

    void deleteTodoItem(String id);

    void markItemAsComplete(String id);
}
