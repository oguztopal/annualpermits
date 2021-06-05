package com.oguztopal.annualpermit.dto;

import com.oguztopal.annualpermit.constants.AnnualPermitConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OperationResult implements Serializable {

	private static final long serialVersionUID = 9160020579275341682L;

	private Integer resultCode;
	private String resultDesc;

	public void makeFailResult() {
		this.setResultCode(AnnualPermitConstants.SERVICE_RETURN_CODE_IS_FAILED);
		this.setResultDesc(AnnualPermitConstants.FAILED.toLowerCase());
	}

}
