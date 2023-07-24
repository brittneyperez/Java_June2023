package com.javalecture.beltreview.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javalecture.beltreview.models.Project;
import com.javalecture.beltreview.models.User;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
	
	// Retrieve all projects from db:
	List<Project> findAll();
	// Retrieve all projects the current user is not team up in:
	List<Project> findAllByTeamMembersNotContaining(User user);
}
