package com.oguztopal.annualpermit.controller;

import com.oguztopal.annualpermit.dto.OperationResult;
import com.oguztopal.annualpermit.dto.PermitDto;
import com.oguztopal.annualpermit.service.PermitService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping(value = "api/permit")
public class PermitController {

	private final PermitService permitService;

	@PostMapping(value = "permitRequest")
	public ResponseEntity<OperationResult> permitRequest(@RequestBody PermitDto permitDto){
		log.info("permit Request started for userId = {}" , permitDto.getUserId());
		OperationResult response = permitService.requestPermit(permitDto);
		log.info("permit Request finished");
		return new ResponseEntity<>(response , HttpStatus.OK);
	}

}
