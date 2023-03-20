package duy.code.module04.service;


import java.util.Optional;

public interface Icrud<T>{
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    T save(T t);
    void delete(Long id);
    Iterable<T> getAllByAgeAsc();
    Iterable<T> findAllByName(String name);
    Iterable<T> findAllByBrand(String name);
}
