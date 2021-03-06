package de.incompleteco.spring.batch.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;

import de.incompleteco.spring.heartbeat.batch.BatchExecutionRegister;

/**
 * simple listener to register a job execution id
 * @author wschipp
 *
 */
public class JobExecutionRegisterListener implements JobExecutionListener {

	@Autowired
	private BatchExecutionRegister register;
	
	@Override
	public void beforeJob(JobExecution jobExecution) {
		register.registerExecution(jobExecution.getId());
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		register.deregisterExecution(jobExecution.getId());
	}

	public void setRegister(BatchExecutionRegister register) {
		this.register = register;
	}

	
}
