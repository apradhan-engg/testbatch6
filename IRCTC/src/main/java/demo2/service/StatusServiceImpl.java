package demo2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo2.entity.Status;
import demo2.repository.StatusRepository;
import demo2.utility.Cache;

@Service
public class StatusServiceImpl implements StatusService{
	
	@Autowired
	StatusRepository statusRepository;

	@Autowired
	Cache cache;
	
	@Override
	public Status getStatus(int trainNo) {
		
		if(cache.checkData(trainNo))
		{
			System.out.println("getting data from cache");
			return cache.getCacheStatus(trainNo);
		}
		    System.out.println("getting data from db");
	        Status s = statusRepository.findById(trainNo).get();
	        
	        cache.storeStatus(s);
	        return s;
	}

	@Override
	public void addStatus(Status status) {
		statusRepository.save(status);
	}

}
