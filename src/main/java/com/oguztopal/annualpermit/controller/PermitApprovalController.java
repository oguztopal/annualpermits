package com.oguztopal.annualpermit.controller;

import com.oguztopal.annualpermit.dto.OperationResult;
import com.oguztopal.annualpermit.dto.PermitApprovalDto;
import com.oguztopal.annualpermit.service.PermitApprovalService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@Slf4j
@RequestMapping("api/approval")
public class PermitApprovalController {

	private final PermitApprovalService permitApprovalService;

	@PutMapping(value = "permitApproval")
	public ResponseEntity<OperationResult> permitApproval(@RequestBody PermitApprovalDto permitApprovalDto){
		log.info("started permitApproval");
		OperationResult result = permitApprovalService.permitApproval(permitApprovalDto);
		log.info("finished permitApproval");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
