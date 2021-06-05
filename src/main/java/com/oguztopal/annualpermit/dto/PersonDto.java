package com.oguztopal.annualpermit.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PersonDto implements Serializable {

	@ApiModelProperty(name = "First Name ",position = 1 ,required = true , example = "oguz")
	private String firstName;

	@ApiModelProperty(name = "Last Name ",position  =2 ,required = true, example = "topal")
	private String lastName;

	@ApiModelProperty(name = "Hire Date ",position = 3, example = "05-06-2021")
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date hireDate;

	@ApiModelProperty(name = "Is Manager ",position = 4 , example = "false")
	private Boolean isManager;

}
