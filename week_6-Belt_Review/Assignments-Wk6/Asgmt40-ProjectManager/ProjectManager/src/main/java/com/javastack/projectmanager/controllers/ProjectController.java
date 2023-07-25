package com.javastack.projectmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javastack.projectmanager.models.Project;
import com.javastack.projectmanager.models.User;
import com.javastack.projectmanager.services.ProjectService;
import com.javastack.projectmanager.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	private ProjectService pService;
	@Autowired
	private UserService uService;
	
// * CREATE
	@GetMapping("/new")
	public String createProjectForm(
			@ModelAttribute("newProject") Project newProject
			) {
		return "create-project-form.jsp";
	}
	
	@PostMapping("/create")
	public String createProject(
			@Valid @ModelAttribute("newProject") Project newProject,
			BindingResult result, Model model, HttpSession session
			) {
		// If errors are present, re-render form with validation errors.
		if (result.hasErrors()) {
			return "create-project-form.jsp";
		}
				
		// Find the logged-in user's ID in session from the database and set the reader attribute of the new book to the logged-in user
		User teamLeader = this.uService.findByUserById((long) session.getAttribute("userId"));
		
		// Console Check (this can be done before saving anything to db):
//		System.out.println("Project Object: "+newProject);
//		System.out.println("Project Title: "+newProject.getTitle());
//		System.out.println("Project Desc: "+newProject.getDescription());
//		System.out.println("Due Date: "+newProject.getDueDate());
//		System.out.println("Creator: "+newProject.getCreator().getUsername());
		
		this.pService.createProject(newProject, teamLeader);
		System.out.printf("\n# Creating project, %s...\n", newProject.getTitle());
//		return "redirect:/project-manager/dashboard";
		return "redirect:/projects/"+newProject.getId()+"/join";
		}
		
		
// * READ ONE
	@GetMapping("/{projectId}/show")
	public String showProject(
		@PathVariable("projectId") Long id,
		Model model, HttpSession session
			) {
		Project selectedProject = this.pService.getProjectById(id); 
		model.addAttribute("project", selectedProject);
		
		// Check if the user is logged in, and add the currentUser attribute to the model if so.
		if (session.getAttribute("userId") != null) {
			Long userId = (Long) session.getAttribute("userId");
			User currentUser = this.uService.findByUserById(userId);
			model.addAttribute("currentUser", currentUser);
		}
		
		System.out.printf("\n# Loading page for project %s, %s...\n", id, selectedProject.getTitle());
		return "show-project.jsp";
	}
	
// * UPDATE
	@GetMapping("/{projectId}/edit")
	public String editProjectForm(
			@PathVariable("projectId") Long projId,
			Model model 
			) {
		model.addAttribute("projectToEdit", this.pService.getProjectById(projId));
		return "update-project-form.jsp";
	}
	
	@PutMapping("/{id}/update")
	public String editProject(
			@PathVariable("id") Long projIdToEdit,
			@Valid @ModelAttribute("projectToEdit") Project originalProject,
			BindingResult result, Model model, HttpSession session
			) {
		// Redirect non-users to index pg:
		if (session.getAttribute("userId") == null) {
			return "redirect:/users";
		}
		// Present form validations:
		if (result.hasErrors()) {
			return "update-project-form.jsp";
		}
		
		// Retrieve the original project from the database
		Project updatedProject = pService.getProjectById(projIdToEdit);
		
		// Update the attributes of the original project with the new values
		updatedProject.setTitle(originalProject.getTitle());
		updatedProject.setDescription(originalProject.getDescription());
		updatedProject.setDueDate(originalProject.getDueDate());
		updatedProject.setCreator(this.uService.findByUserById( (Long)session.getAttribute("userId")));
		
		// Console Check (this can be done before saving anything to db):
//		System.out.println("Project Object: "+updatedProject);
//		System.out.println("Project Title: "+updatedProject.getTitle());
//		System.out.println("Project Desc: "+updatedProject.getDescription());
//		System.out.println("Due Date: "+updatedProject.getDueDate());
//		System.out.println("Creator: "+updatedProject.getCreator().getUsername());
		
		this.pService.updateProject(updatedProject);
		System.out.printf("\n# Saving changes for project, %s...\n", updatedProject.getTitle());
		return "redirect:/projects/"+updatedProject.getId()+"/show";
	}
		
// * JOIN TEAM
	@GetMapping("/{projectId}/join")
	public String joinProjectTeam(
			@PathVariable("projectId") Long projectIdToJoinTeam,
			HttpSession session
			) {
		Long currentUserId = (Long) session.getAttribute("userId");
		if (currentUserId == null) {
			return "redirect:/";
		}
		
		Project joiningProject = this.pService.getProjectById(projectIdToJoinTeam);
		User currentUser = this.uService.findByUserById(currentUserId);
		this.pService.joinTeam(joiningProject, currentUser);
		
		System.out.printf("\n# Joining on team for project, %s...\n", joiningProject.getTitle());
		return "redirect:/project-manager/dashboard";
	}
// * LEAVE TEAM
	@GetMapping("/{projectId}/leave")
	public String leaveProjectTeam(
			@PathVariable("projectId") Long projectIdToLeaveTeam,
			HttpSession session
			) {
		Long currentUserId = (Long) session.getAttribute("userId");
		if (currentUserId == null) {
			return "redirect:/";
		}
			
		Project leavingProject = this.pService.getProjectById(projectIdToLeaveTeam);
		User currentUser = this.uService.findByUserById(currentUserId);
		this.pService.leaveTeam(leavingProject, currentUser);
		System.out.printf("\n# Leaving team for project, %s...\n", leavingProject.getTitle());
		return "redirect:/project-manager/dashboard";
	}
	
	
// * DELETE
	@GetMapping("/{projectId}/delete")
	public String terminateProject(@PathVariable("projectId") Long projectId) {
		System.out.println("\n# Deleting project "+ projectId +"...");
		this.pService.deleteProjectById(projectId);
		return "redirect:/project-manager/dashboard";
	}
}
