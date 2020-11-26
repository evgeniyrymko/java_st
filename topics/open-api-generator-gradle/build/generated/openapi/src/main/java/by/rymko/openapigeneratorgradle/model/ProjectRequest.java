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
import org.hibernate.validator.constraints.*;

/**
 * ProjectRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-11-26T10:27:27.768+03:00[Europe/Minsk]")

public class ProjectRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("name")
  private String name;

  @JsonProperty("additionalName")
  private String additionalName;

  @JsonProperty("email")
  private String email;

  public ProjectRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * the name of the project
   * @return name
  */
  @ApiModelProperty(example = "To-do Application Development", required = true, value = "the name of the project")
  @NotNull

@Size(min=2,max=10) 
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

  public ProjectRequest email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  @ApiModelProperty(value = "")

@javax.validation.constraints.Email
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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
        Objects.equals(this.additionalName, projectRequest.additionalName) &&
        Objects.equals(this.email, projectRequest.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, additionalName, email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProjectRequest {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    additionalName: ").append(toIndentedString(additionalName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
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

