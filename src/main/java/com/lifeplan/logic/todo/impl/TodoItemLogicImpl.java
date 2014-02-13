package com.lifeplan.logic.todo.impl;

import com.lifeplan.dao.todo.TodoItemDao;
import com.lifeplan.logic.todo.TodoItemLogic;
import com.lifeplan.logic.util.DateUtil;
import com.lifeplan.models.TodoItem;
import com.lifeplan.models.exception.DocumentNotFoundException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * Created on 2/10/14.
 */
@Service
public class TodoItemLogicImpl implements TodoItemLogic {
    private final static Logger log = Logger.getLogger(TodoItemLogicImpl.class);
    @Autowired
    TodoItemDao todoItemDao;

    @Override
    public List<TodoItem> getTodoItems() {
        return todoItemDao.getAllTodoItems();
    }

    @Override
    public TodoItem getTodoItem(String id) {
        return todoItemDao.getTodoItem(id);
    }

    @Override
    public void createTodoItems(TodoItem item) {
        if (item != null) {
            if (null == item.getCreatedOn()) {
                item.setCreatedOn(DateUtil.getCurrentDateTimeInString());
            }
            todoItemDao.createTodoItems(item);
        } else {
            log.error("Todo item found null!");
        }
    }

    @Override
    public void deleteTodoItem(String id) {
        if (StringUtils.isEmpty(id)) {
            throw new IllegalArgumentException("id cannot be null when deleting todo item");
        }
        todoItemDao.deleteTodoItem(id);

    }

    @Override
    public void markItemAsComplete(String id) {
        if (StringUtils.isEmpty(id)) {
            throw new IllegalArgumentException("id cannot be null when completing todo item");
        }
        TodoItem item = todoItemDao.getTodoItem(id);
        if (item != null) {
            item.markCompleted();
            todoItemDao.markItemAsComplete(item);
        } else {
            throw new DocumentNotFoundException(new Date().toString(), "id=" + id, TodoItem.class, id + " not found for todo item");
        }
    }
}
