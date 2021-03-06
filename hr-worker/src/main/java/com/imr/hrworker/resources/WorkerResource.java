package com.imr.hrworker.resources;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imr.hrworker.entities.Worker;
import com.imr.hrworker.repositories.WorkerRepository;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
	
	@Value("${test.config}")
	private String config;
	
	Logger logger = LoggerFactory.getLogger(WorkerResource.class);
	
	@Autowired
	Environment env;
	
	@Autowired
	private WorkerRepository repository;
	
	@GetMapping("/configs")
	public ResponseEntity<Void> getConfigs(){
		System.out.println(config);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> workers =  repository.findAll();
		return ResponseEntity.ok(workers);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findOne(@PathVariable Long id){
		logger.info("PORT = "+ env.getProperty("local.server.port"));
		Optional<Worker> worker =  repository.findById(id);
		return ResponseEntity.ok(worker.get());
	}
	
}
