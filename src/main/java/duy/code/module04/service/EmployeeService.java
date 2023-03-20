package duy.code.module04.service;

import duy.code.module04.model.Employee;
import duy.code.module04.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService implements Icrud<Employee> {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Iterable<Employee> getAllByAgeAsc() {
        return employeeRepository.getAllByAgeAsc();
    }

    @Override
    public Iterable<Employee> findAllByName(String name) {
        return employeeRepository.findAllByNameContaining(name);
    }
}
