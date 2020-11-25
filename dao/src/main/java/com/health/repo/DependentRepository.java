package com.health.repo;


import com.health.entity.Dependent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DependentRepository extends JpaRepository<Dependent, Integer> {

}
