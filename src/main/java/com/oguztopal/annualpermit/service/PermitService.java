package com.oguztopal.annualpermit.service;

import com.oguztopal.annualpermit.dto.OperationResult;
import com.oguztopal.annualpermit.dto.PermitDto;

public interface PermitService {
	OperationResult requestPermit(PermitDto permitDto);
}
