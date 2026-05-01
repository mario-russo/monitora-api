package br.com.mariorusso.domain.output.repository;

import io.smallrye.mutiny.Uni;

import java.util.List;

public interface RepositoryCore<T> {

    Uni<T> save(T entity);
    Uni<List<T> >listAll();
    Uni<T> findById(Long id);
    Uni<T>  update (T entity);

}
