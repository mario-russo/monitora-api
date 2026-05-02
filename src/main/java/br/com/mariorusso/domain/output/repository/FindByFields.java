package br.com.mariorusso.domain.output.repository;

import io.smallrye.mutiny.Uni;

import java.util.List;

public interface FindByFields<T> {

    public Uni<List<T>> findByField (String key, Object value);
}
