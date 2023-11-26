package com.projectx.springdata.repository;

import com.projectx.springdata.config.SpringContext;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;


import java.io.Serializable;
public class BatchRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BatchRepository<T, ID> {

    public BatchRepositoryImpl(JpaEntityInformation entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

    @Override
    public <S extends T> void saveInBatch(Iterable<S> entities) {

        if (entities == null) {
            throw new IllegalArgumentException("The given iterable of entities cannot be null");
        }

        BatchExecutor batchExecutor = SpringContext.getBean(BatchExecutor.class);
        batchExecutor.saveInBatch(entities);
    }

}
