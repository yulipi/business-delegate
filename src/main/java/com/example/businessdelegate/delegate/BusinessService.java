package com.example.businessdelegate.delegate;

import java.util.Optional;

public interface BusinessService<T> {
    T add(T t);
    Optional<T> findById(long id) throws Exception;
    Iterable<T> findAll() throws Exception;
    void deleteById(T t);
}
