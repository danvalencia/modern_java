package com.danielvalencia.repositories;

import rx.Observable;

import java.util.List;

/**
 * @author Daniel Valencia (daniel@tacitknowledge.com)
 */
public interface Repository<T>
{
    Observable<T> findAll(final Integer limit);
    Observable<T> findByName(final String name);
    Boolean add(final T item);
    Observable<T> findById(final String id);
}
