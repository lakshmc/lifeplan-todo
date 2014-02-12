package com.lifeplan.dao.todo;


import com.lifeplan.models.TodoItem;

import java.util.List;

/**
 * Created on 2/10/14.
 */

public interface TodoItemDao {
    List<TodoItem> getAllTodoItems();
    TodoItem getTodoItem(String id);
    void createTodoItems(TodoItem item);

    void deleteTodoItem(String id);

    void markItemAsComplete(TodoItem item);
}
