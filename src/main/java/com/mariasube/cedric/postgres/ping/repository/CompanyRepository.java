package com.mariasube.cedric.postgres.ping.repository;

import com.mariasube.cedric.postgres.ping.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
