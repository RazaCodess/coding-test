package com.health.repo;


import com.health.entity.Enrollee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrolleeRepository extends JpaRepository<Enrollee, Integer> {

}
