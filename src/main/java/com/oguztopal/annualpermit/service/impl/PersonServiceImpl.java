package com.oguztopal.annualpermit.service.impl;

import com.oguztopal.annualpermit.dto.OperationResult;
import com.oguztopal.annualpermit.dto.PersonDto;
import com.oguztopal.annualpermit.entity.Person;
import com.oguztopal.annualpermit.repository.PersonRepository;
import com.oguztopal.annualpermit.service.PersonService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@Slf4j
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

	private final PersonRepository personRepository;
	private final ModelMapper modelMapper;
	private final MessageSource messageSource;

	@Override
	public OperationResult insertNewPerson(PersonDto personDto){
		log.info("insertNewPerson satarted ");
		OperationResult operationResult = new OperationResult();
		try {
			personRepository.save(modelMapper.map(personDto, Person.class));
			operationResult.setResultCode(200);
			operationResult.setResultDesc(messageSource.getMessage("success2",null, new Locale("tr","TR")));
		}catch (Exception ex){
			log.error("error while person create , error: " + ex.getMessage() );
			operationResult.makeFailResult();
		}
		return operationResult;
	}

}
