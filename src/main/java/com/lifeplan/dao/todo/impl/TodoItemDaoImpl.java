package com.lifeplan.dao.todo.impl;

import com.lifeplan.dao.AbstractHelperDao;
import com.lifeplan.dao.todo.TodoItemDao;
import com.lifeplan.models.TodoItem;
import org.apache.log4j.Logger;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 2/10/14.
 */
@Repository
public class TodoItemDaoImpl extends AbstractHelperDao implements TodoItemDao {
    private static final Logger log = Logger.getLogger(TodoItemDaoImpl.class);

    @Override
    public List<TodoItem> getAllTodoItems() {
        return mongoTemplate.findAll(TodoItem.class);
    }

    @Override
    public TodoItem getTodoItem(String id) {
        return mongoTemplate.findById(id, TodoItem.class);
    }

    @Override
    public void createTodoItems(TodoItem item) {
        log.debug("creating todo item: "+item);
        if(!mongoTemplate.collectionExists(TodoItem.class)){
            mongoTemplate.createCollection(TodoItem.class);
        }
        mongoTemplate.insert(item);
        log.debug("created todo item: "+item.getId());
    }

    @Override
    public void deleteTodoItem(String id) {
        Query q = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(q,TodoItem.class);
        log.debug("deleted id:"+id);
    }

    @Override
    public void markItemAsComplete(TodoItem item) {
        if(item!=null){
            item.setCompleted(true);
            mongoTemplate.save(item);
        } else {
            log.error("Todo Item cannot be null when attempting to mark as completed");
        }
    }
}
