package by.rymko.openapigeneratorgradle.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-11-16T15:36:34.807+03:00[Europe/Minsk]")

@Controller
@RequestMapping("${openapi.toDoBoard.base-path:/v1}")
public class ProjectsApiController implements ProjectsApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ProjectsApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
