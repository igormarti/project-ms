package com.imr.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imr.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
