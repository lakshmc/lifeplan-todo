package com.lifeplan.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 2/10/14.
 */
@Repository
public abstract class AbstractMongoHelper {
    @Autowired
    protected MongoTemplate mongoTemplate;

    static final Logger log = Logger.getLogger(AbstractMongoHelper.class);

    protected <T> List<T> loadAll(Class<T> clazz) {
        return mongoTemplate.findAll(clazz);
    }

    protected <T> T findById(String id, Class<T> entityClass) {
        return mongoTemplate.findById(id, entityClass);
    }

    protected <T> void createDocument(T document) {
        if (document != null) {
            if (!mongoTemplate.collectionExists(document.getClass())) {
                mongoTemplate.createCollection(document.getClass());
            }
            mongoTemplate.insert(document);
        } else {
            throw new IllegalArgumentException("Document cannot be null when adding to db..");
        }
    }

    protected <T> void updateDocument(T document) {
        if (document != null) {
            mongoTemplate.save(document);
        } else {
            throw new IllegalArgumentException("Document cannot be null when updating..");
        }
    }

    protected <T> void deleteDocument(T document) {
        if (document != null) {
            mongoTemplate.remove(document);
        } else {
            throw new IllegalArgumentException("Document cannot be null when deleting..");
        }
    }

    protected <T> void deleteDocumentById(String id, Class<T> clazz) {
        Query q = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(q, clazz);
        log.debug("deleted id:" + id);

    }
}
