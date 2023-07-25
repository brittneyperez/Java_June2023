package com.javastack.projectmanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javastack.projectmanager.models.Project;
import com.javastack.projectmanager.models.User;
import com.javastack.projectmanager.repositories.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projRepo;
	
	// * CREATE
	public Project createProject( Project newProject, User userIsTeamLeader ) {
		newProject.setCreator(userIsTeamLeader);
//		return this.joinTeam(newProject, userIsTeamLeader);
		return this.projRepo.save(newProject);
	}
	
	// * READ
	public List<Project> getAllProjects() {
		return this.projRepo.findAll();
	}
	
	// * READ ONE
	public Project getProjectById( Long id ) {
		return this.projRepo.findById(id).orElse(null);
	}
	
	// * UPDATE
	public Project updateProject( Project existingProject ) {
		return this.projRepo.save(existingProject);
	}
	
	// * DELETE
	public void deleteProjectById( Long id ) {
		this.projRepo.deleteById(id);
	}
	
	// * Join Team
	public Project joinTeam( Project project, User user ) {
		project.getTeamMembers().add(user);
		return this.projRepo.save(project);
	}
	// * Leave Team
	public void leaveTeam( Project project, User user ) {
		project.getTeamMembers().remove(user);
		this.projRepo.save(project);
	}
	// * Filtering Projects
	public List<Project> getProjectsWithoutThisMember( User user ) {
		return this.projRepo.findAllByTeamMembersNotContaining(user);
	}
}
