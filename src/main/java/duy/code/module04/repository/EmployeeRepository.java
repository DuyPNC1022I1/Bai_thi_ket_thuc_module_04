package duy.code.module04.repository;

import duy.code.module04.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Iterable<Employee> findAllByNameContaining(String name);
    @Query("SELECT e FROM Employee e ORDER BY e.age Asc")
    Iterable<Employee> getAllByAgeAsc();
    Iterable<Employee> findAllByBrand_Name(String brand);
}
