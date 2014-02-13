package com.lifeplan.dao.todo.impl;

import com.lifeplan.dao.AbstractMongoHelper;
import com.lifeplan.dao.todo.TodoItemDao;
import com.lifeplan.models.TodoItem;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created on 2/10/14.
 */
@Repository
public class TodoItemDaoImpl extends AbstractMongoHelper implements TodoItemDao {
    private static final Logger log = Logger.getLogger(TodoItemDaoImpl.class);

    @Override
    public List<TodoItem> getAllTodoItems() {
        return loadAll(TodoItem.class);
    }

    @Override
    public TodoItem getTodoItem(String id) {
        return findById(id, TodoItem.class);
    }

    @Override
    public void createTodoItems(TodoItem item) {
        log.debug("creating todo item: "+item);
        createDocument(item);
        log.debug("created todo item: "+item.getId());
    }

    @Override
    public void deleteTodoItem(String id) {
        if (StringUtils.isEmpty(id)) {
            throw new IllegalArgumentException("Id cannot be null when attempting to delete TodoItem");
        } else {
            deleteDocumentById(id, TodoItem.class);
        }
    }

    @Override
    public void markItemAsComplete(TodoItem item) {
        if(item!=null){
            item.setCompleted(true);
            updateDocument(item);
        } else {
            log.error("Todo Item cannot be null when attempting to mark as completed");
        }
    }
}
