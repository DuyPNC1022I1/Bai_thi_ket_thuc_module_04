package duy.code.module04.service;

import duy.code.module04.model.Brand;
import duy.code.module04.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BrandService implements Icrud<Brand>{
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Iterable<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public Optional<Brand> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Brand save(Brand brand) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Iterable<Brand> getAllByAgeAsc() {
        return null;
    }

    @Override
    public Iterable<Brand> findAllByName(String name) {
        return null;
    }
}
