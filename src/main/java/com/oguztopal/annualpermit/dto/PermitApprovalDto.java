package com.oguztopal.annualpermit.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PermitApprovalDto {

	@ApiModelProperty(name = "permitId ",position = 1 ,required = true)
	private Long permitId;
	@ApiModelProperty(name = "UserId ",position = 2  ,required = true)
	private Long userId;
	@ApiModelProperty(name = "permissionStatus ",position = 3 ,required = true)
	private String permissionStatus;

}
