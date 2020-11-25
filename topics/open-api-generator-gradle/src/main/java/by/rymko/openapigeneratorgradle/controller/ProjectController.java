package by.rymko.openapigeneratorgradle.controller;

import by.rymko.openapigeneratorgradle.api.ProjectsApi;
import by.rymko.openapigeneratorgradle.entity.Project;
import by.rymko.openapigeneratorgradle.mapper.ProjectModelMapper;
import by.rymko.openapigeneratorgradle.model.ProjectRequest;
import by.rymko.openapigeneratorgradle.model.ProjectResponse;
import by.rymko.openapigeneratorgradle.service.ProjectService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

import static by.rymko.openapigeneratorgradle.mapper.ProjectModelMapper.toApi;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@Controller
public class ProjectController implements ProjectsApi {

    ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }


    @Override
    public ResponseEntity<ProjectRequest> createProject(String xRequestID, List<Integer> xRequestArray, @Valid ProjectRequest projectRequest,
                                                        ProjectRequest xRequestProjectRequest) {
        Project project = projectService.createProject(ProjectModelMapper.toEntity(projectRequest));
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Response-String-Header1", "String header1");
        headers.add("X-Response-String-Header2", "String header2");

        return ResponseEntity.status(CREATED)
                .headers(headers)
                .body(projectRequest);
    }

//    @Override
//    public ResponseEntity<ProjectRequest> createProject(@Valid ProjectRequest projectRequest) {
//        Project project = projectService.createProject(ProjectModelMapper.toEntity(projectRequest));
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("X-Response-String-Header1", "String header1");
//        headers.add("X-Response-String-Header2", "String header2");
//
//        return ResponseEntity.status(CREATED)
//                .headers(headers)
//                .body(projectRequest);
//    }

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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleValidationExceptions(HttpMessageNotReadableException ex) {
        System.out.println("Exception handler was invoked.");
        System.out.println("------");
        System.out.println(ex.getLocalizedMessage());
        System.out.println("------");
        System.out.println(ex.getMessage());
        System.out.println("------");
        return ResponseEntity.status(BAD_REQUEST).body(ex.getLocalizedMessage());
    }
}
