package demo2.service;

import demo2.entity.Status;

public interface StatusService {
	
	public Status getStatus(int trainNo);
	
	public void addStatus(Status status);
	

}
