package br.com.mariorusso.domain.service;

import java.util.List;

public interface ServiceCore<T> {

    T salve(T entity);
    List<T> listAll();
    T findById(Long id);
    T update (T entity);
}
