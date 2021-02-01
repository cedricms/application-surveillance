package com.mariasube.cedric.postgres.ping.service.impl;

import com.mariasube.cedric.postgres.ping.entity.Company;
import com.mariasube.cedric.postgres.ping.entity.Employee;
import com.mariasube.cedric.postgres.ping.repository.CompanyRepository;
import com.mariasube.cedric.postgres.ping.repository.EmployeeRepository;
import com.mariasube.cedric.postgres.ping.service.PostgresPingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PostgresPingServiceImpl implements PostgresPingService {

    private static final int WAIT_TIME = 5;
    private static final int NUMBER_OF_DATABASE_REQUEST_TYPES = 4;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void run() throws InterruptedException {
        boolean infinity = true;

        // We want to generate database pings for all time or untill somebody thinks to stop the process (might be a good idea to save on energy ;) ).
        while (infinity) {
            pingDatabase();

            sleepABit();
        }
    }

    private void pingDatabase() {
        int requestType = (int) (NUMBER_OF_DATABASE_REQUEST_TYPES * Math.random());

        switch (requestType) {
            case 0:
                List<Company> companyList = companyRepository.findAll();
                System.out.println("Number of companies : " + companyList.size());
                break;
            case 1:
                Company company = companyRepository.getOne(1L);
                System.out.println("Company : " + company.getName());
                break;
            case 2:
                List<Employee> employeeList = employeeRepository.findAll() ;
                System.out.println("Number of employees : " + employeeList.size());
                break;
            case 3:
                Employee employee = employeeRepository.getOne(3L);
                System.out.println("Employee : " + employee.getFirstName() + " " + employee.getLastName());
                System.out.println("Employee company : " + employee.getCompany().getName());
                break;
            default:
                System.out.println("Database request type not yet covered : " + requestType);
        }
    }

    private void sleepABit() throws InterruptedException {
        // We want to ping the database "regularly" between 0 and 5 seconds.
        long napTimeInMilliseconds = (long) (WAIT_TIME * 1000 * Math.random());
        System.out.println("Nap time in milliseconds : " + napTimeInMilliseconds);
        Thread.sleep(napTimeInMilliseconds);
    }
}
