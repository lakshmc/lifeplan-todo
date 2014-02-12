package com.lifeplan.controllers;

import com.lifeplan.logic.todo.TodoItemLogic;
import com.lifeplan.models.TodoItem;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created on 2/10/14.
 */
@Controller
@RequestMapping("todo")
public class TodoController {
    static final Logger log = Logger.getLogger(TodoController.class);

    @Autowired
    TodoItemLogic todoItemLogic;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public @ResponseBody List<TodoItem> getTodoItems(){
        log.debug("called to list all todo items");
        return todoItemLogic.getTodoItems();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public @ResponseBody TodoItem getTodoItems(@PathVariable String id){
        return todoItemLogic.getTodoItem(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public @ResponseBody void deleteTodoItem(@PathVariable String id){
        log.debug("initate delete for id:"+ id);
        todoItemLogic.deleteTodoItem(id);
    }

    @RequestMapping(value = "create", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody void createTodoItem(@RequestBody TodoItem item){
        log.debug("calling logic to create todo item: "+item);
        todoItemLogic.createTodoItems(item);
    }

    @RequestMapping(value = "{id}/complete", method = RequestMethod.POST)
    public @ResponseBody void markTodoItemComplete(@PathVariable String id){
        log.debug("Marking item as complete: "+id);
        todoItemLogic.markItemAsComplete(id);
    }
}
