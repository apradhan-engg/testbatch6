package demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import demo2.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Integer>{

	
}
