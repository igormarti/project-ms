package com.imr.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imr.hrpayroll.entities.Payment;
import com.imr.hrpayroll.entities.Worker;
import com.imr.hrpayroll.feignclients.WorkerFeignClients;

@Service
public class PaymentService {
	
	@Autowired
	private WorkerFeignClients clients;
	
	public Payment getPayment(Long workerId, Integer days) {

		Worker worker = clients.findOne(workerId).getBody();
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
