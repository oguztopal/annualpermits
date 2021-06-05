package com.oguztopal.annualpermit.service;

import com.oguztopal.annualpermit.dto.OperationResult;
import com.oguztopal.annualpermit.dto.PermitApprovalDto;

public interface PermitApprovalService {

	OperationResult permitApproval(PermitApprovalDto permitApprovalDto);

}
