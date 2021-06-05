package com.oguztopal.annualpermit.service;

import com.oguztopal.annualpermit.dto.OperationResult;
import com.oguztopal.annualpermit.dto.PersonDto;

public interface PersonService {

	OperationResult insertNewPerson(PersonDto personDto);
}
