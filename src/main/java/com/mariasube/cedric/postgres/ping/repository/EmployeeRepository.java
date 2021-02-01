package com.mariasube.cedric.postgres.ping.repository;

import com.mariasube.cedric.postgres.ping.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
