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
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-11-11T17:37:21.921+03:00[Europe/Minsk]")

public class ProjectRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("name")
  private String name;

  @JsonProperty("additionalName")
  private String additionalName;

  @JsonProperty("email")
  private String email;

  @JsonProperty("testField1")
  private String testField1;

  @JsonProperty("testField2")
  private String testField2;

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

  public ProjectRequest testField1(String testField1) {
    this.testField1 = testField1;
    return this;
  }

  /**
   * Get testField1
   * @return testField1
  */
  @ApiModelProperty(value = "")


  public String getTestField1() {
    return testField1;
  }

  public void setTestField1(String testField1) {
    this.testField1 = testField1;
  }

  public ProjectRequest testField2(String testField2) {
    this.testField2 = testField2;
    return this;
  }

  /**
   * Get testField2
   * @return testField2
  */
  @ApiModelProperty(value = "")


  public String getTestField2() {
    return testField2;
  }

  public void setTestField2(String testField2) {
    this.testField2 = testField2;
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
        Objects.equals(this.email, projectRequest.email) &&
        Objects.equals(this.testField1, projectRequest.testField1) &&
        Objects.equals(this.testField2, projectRequest.testField2);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, additionalName, email, testField1, testField2);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProjectRequest {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    additionalName: ").append(toIndentedString(additionalName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    testField1: ").append(toIndentedString(testField1)).append("\n");
    sb.append("    testField2: ").append(toIndentedString(testField2)).append("\n");
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

