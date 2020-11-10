package by.rymko.openapigeneratorgradle.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ProjectRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-11-10T19:53:38.376+03:00[Europe/Minsk]")

public class ProjectRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("name")
  private String name;

  @JsonProperty("additionalName")
  private String additionalName;

  public ProjectRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * the name of the project
   * @return name
  */
  @ApiModelProperty(example = "To-do Application Development", value = "the name of the project")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProjectRequest additionalName(String additionalName) {
    this.additionalName = additionalName;
    return this;
  }

  /**
   * the name of the project
   * @return additionalName
  */
  @ApiModelProperty(example = "To-do Application Development", value = "the name of the project")


  public String getAdditionalName() {
    return additionalName;
  }

  public void setAdditionalName(String additionalName) {
    this.additionalName = additionalName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProjectRequest projectRequest = (ProjectRequest) o;
    return Objects.equals(this.name, projectRequest.name) &&
        Objects.equals(this.additionalName, projectRequest.additionalName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, additionalName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProjectRequest {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    additionalName: ").append(toIndentedString(additionalName)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

