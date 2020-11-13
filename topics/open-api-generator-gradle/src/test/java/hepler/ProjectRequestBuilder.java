package hepler;

import by.rymko.openapigeneratorgradle.model.ProjectRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ProjectRequestBuilder {

    private static ObjectMapper mapper = new ObjectMapper();

    public static String project(String name){
        ProjectRequest projectRequest = new ProjectRequest();
        projectRequest.setName(name);

        try {
            return mapper.writeValueAsString(projectRequest);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Failed to parse JSON object", e);
        }

    }
}
