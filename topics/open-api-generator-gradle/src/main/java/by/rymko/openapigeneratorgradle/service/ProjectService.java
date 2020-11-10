package by.rymko.openapigeneratorgradle.service;

import by.rymko.openapigeneratorgradle.entity.Project;
import by.rymko.openapigeneratorgradle.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {


    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> retrieveAllProjects() {
        return projectRepository.findAll();
    }

    public Project findProject(Long projectId) {
        return projectRepository.getOne(projectId);
    }

    public List<Project> findProjectsByName(String name) {
        return projectRepository.findAllByName(name);
    }


}
