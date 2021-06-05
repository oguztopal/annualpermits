package com.oguztopal.annualpermit.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PermitDto implements Serializable {

	@ApiModelProperty(name = "UserId ",position = 1 ,required = true)
	private Long userId;
	@JsonFormat(pattern = "dd-MM-yyyy")
	@ApiModelProperty(name = "startDate ",position = 2 ,required = true, example = "11-05-2020")
	private Date startDate;
	@ApiModelProperty(name = "finishDate ",position = 3 ,required = true, example = "15-05-2020")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date finishDate;

}
