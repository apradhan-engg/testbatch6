package demo2.utility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo2.entity.Status;
import demo2.repository.StatusRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Cache {
	
	@Autowired
	StatusRepository statusRepository;
	
	Map<Integer, Status> m = new HashMap<>();
	
	
	public void storeStatus(Status status) //firstely store 200 in cache from db
	{
		m.put(status.getTrainId(), status);
	}
	
	public Status getCacheStatus(int trainId)//return to people from cache 200 for 15 sec
	{
		return m.get(trainId);
		
	}
	
	public boolean checkData(int trainId)
	{
		return m.containsKey(trainId);
		
	}
	
	public void clearCache()
	{
		m.clear();
		System.out.println("cleared cache");
	}
	
	@PostConstruct
    public void dumpAllDataFromDb()
    {
    	List <Status> l = statusRepository.findAll();
    	
    	/*for(int i=0;i<l.size();i++)
    	{
    		m.put(l.get(i).getTrainId(), l.get(i));
    	}*/
    	
    	for(Status s :l)
    	{
    		System.out.println("dumping is in progress:"+s);
    		m.put(s.getTrainId(), s);
    	}
    }
	
	@PreDestroy
	public void m1()
	{
		System.out.println("this is predestroy method");
	}
	
}











