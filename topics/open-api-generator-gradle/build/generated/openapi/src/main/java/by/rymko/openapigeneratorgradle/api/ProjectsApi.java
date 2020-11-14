/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.3.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package by.rymko.openapigeneratorgradle.api;

import by.rymko.openapigeneratorgradle.model.ProjectRequest;
import by.rymko.openapigeneratorgradle.model.ProjectResponse;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-11-14T14:33:30.522+03:00[Europe/Minsk]")

@Validated
@Api(value = "Projects", description = "the Projects API")
public interface ProjectsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /projects
     * create new project entry
     *
     * @param projectRequest  (required)
     * @return successfully created a project (status code 201)
     */
    @ApiOperation(value = "", nickname = "createProject", notes = "create new project entry", response = ProjectRequest.class, tags={ "Projects", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "successfully created a project", response = ProjectRequest.class) })
    @RequestMapping(value = "/projects",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<ProjectRequest> createProject(@ApiParam(value = "" ,required=true )  @Valid @RequestBody ProjectRequest projectRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"To-do Application Development\", \"additionalName\" : \"To-do Application Development\", \"email\" : \"email\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /projects/{projectId}
     * retrieve a project by id
     *
     * @param projectId  (required)
     * @return the specific project successfully retrieved (status code 200)
     */
    @ApiOperation(value = "", nickname = "getProjects", notes = "retrieve a project by id", response = ProjectResponse.class, tags={ "Projects", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "the specific project successfully retrieved", response = ProjectResponse.class) })
    @RequestMapping(value = "/projects/{projectId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<ProjectResponse> getProjects(@Min(1L)@ApiParam(value = "",required=true) @PathVariable("projectId") Long projectId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"To-do Application Development\", \"id\" : 1 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /projects
     * retrieve all available projects in paginated way
     *
     * @param name find project by name (optional)
     * @return successfully retrieved all projects (status code 200)
     */
    @ApiOperation(value = "", nickname = "searchProjects", notes = "retrieve all available projects in paginated way", response = ProjectResponse.class, responseContainer = "List", tags={ "Projects", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successfully retrieved all projects", response = ProjectResponse.class, responseContainer = "List") })
    @RequestMapping(value = "/projects",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<ProjectResponse>> searchProjects(@ApiParam(value = "find project by name") @Valid @RequestParam(value = "name", required = false) String name) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"To-do Application Development\", \"id\" : 1 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
