package by.rymko.openapigeneratorgradle.controller;

import by.rymko.openapigeneratorgradle.api.ProjectsApi;
import by.rymko.openapigeneratorgradle.entity.Project;
import by.rymko.openapigeneratorgradle.mapper.ProjectModelMapper;
import by.rymko.openapigeneratorgradle.model.ProjectRequest;
import by.rymko.openapigeneratorgradle.model.ProjectResponse;
import by.rymko.openapigeneratorgradle.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

import static by.rymko.openapigeneratorgradle.mapper.ProjectModelMapper.toApi;
import static org.springframework.http.HttpStatus.CREATED;

@Controller
public class ProjectController implements ProjectsApi {

    ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public ResponseEntity<ProjectRequest> createProject(String xRequestIDName, @Valid ProjectRequest projectRequest) {
        Project project = projectService.createProject(ProjectModelMapper.toEntity(projectRequest));
        return ResponseEntity.status(CREATED).body(projectRequest);
    }

    @Override
    public ResponseEntity<ProjectResponse> getProjects(@Min(1L) Long projectId) {
        Project project = projectService.findProject(projectId);
        return ResponseEntity.ok().body(toApi(project));
    }

    @Override
    public ResponseEntity<List<ProjectResponse>> searchProjects(@Valid String name) {
        if (name != null) {
            return ResponseEntity.ok(ProjectModelMapper.toApi(projectService.findProjectsByName(name)));
        } else {
            return ResponseEntity.ok(ProjectModelMapper.toApi(projectService.retrieveAllProjects()));
        }
    }
}
