package com.sim1zzo.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sim1zzo.pma.dto.ChartData;
import com.sim1zzo.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {

	@Override
	public List<Project> findAll();
	
	@Query(nativeQuery=true, value="SELECT STAGE as label, COUNT(*) AS value FROM PROJECT "
			+ "GROUP BY STAGE ;")
	public List<ChartData> getProjectStatus();
	
}
