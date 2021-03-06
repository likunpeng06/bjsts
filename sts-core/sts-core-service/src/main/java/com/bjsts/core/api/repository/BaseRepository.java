package com.bjsts.core.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * 通用的JPA方法声明
 * Created by sunshow on 4/21/15.
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends BaseInternalRepository<T, ID>, JpaSpecificationExecutor<T> {
    <S extends T> S save(S s);

    <S extends T> Iterable<S> save(Iterable<S> iterable);

    T findOne(ID id);

    boolean exists(ID id);

    Iterable<T> findAll(Iterable<ID> iterable);

    void flush();

    <S extends T> S saveAndFlush(S s);

    /**
     * Returns all entities sorted by the given options.
     *
     * @param sort
     * @return all entities sorted by the given options
     */
    Iterable<T> findAll(Sort sort);

    /**
     * Returns a {@link Page} of entities meeting the paging restriction provided in the {@code Pageable} object.
     *
     * @param pageable
     * @return a page of entities
     */
    Page<T> findAll(Pageable pageable);
}
