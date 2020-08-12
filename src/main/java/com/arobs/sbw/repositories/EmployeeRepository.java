package com.arobs.sbw.repositories;

import com.arobs.sbw.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author vasile.mihali
 * @since 8/12/2020
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
