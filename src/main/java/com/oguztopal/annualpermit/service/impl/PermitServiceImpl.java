package com.oguztopal.annualpermit.service.impl;

import com.oguztopal.annualpermit.constants.AnnualPermitConstants;
import com.oguztopal.annualpermit.dto.OperationResult;
import com.oguztopal.annualpermit.dto.PermitDto;
import com.oguztopal.annualpermit.entity.Permit;
import com.oguztopal.annualpermit.entity.Person;
import com.oguztopal.annualpermit.repository.PermitRepository;
import com.oguztopal.annualpermit.repository.PersonRepository;
import com.oguztopal.annualpermit.service.CalculationOperations;
import com.oguztopal.annualpermit.service.PermitService;
import com.oguztopal.annualpermit.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@AllArgsConstructor
@Slf4j
public class PermitServiceImpl implements PermitService {

	private final PermitRepository permitRepository;
	private final CalculationOperations calculationOperations;
	private final PersonRepository personRepository;
	private final ModelMapper modelMapper;
	private final MessageSource messageSource;

	@Override
	public OperationResult requestPermit(PermitDto permitDto) {
		OperationResult operationResult = new OperationResult();
		Person person = personRepository.getById(permitDto.getUserId());
		try {

			long hasTotalPermitDay = calculationOperations.calculateAllHasPermitFromHireDate(person.getHireDate(),permitDto.getStartDate());
			Long takenAllPermitDay = permitRepository.getAllPermittedDays(person.getId());
			if (hasTotalPermitDay == 5){
				long toBeTakenPermitDay = DateUtil.calculateToBePermitDayExcludedWeekend(permitDto.getStartDate(),permitDto.getFinishDate());
				if (hasTotalPermitDay < toBeTakenPermitDay){
					operationResult.setResultDesc(messageSource.getMessage("error1", null , new Locale("tr", "TR")));
					return operationResult;
				}else {
					return getOperationResult(permitDto, operationResult, person, hasTotalPermitDay, takenAllPermitDay, toBeTakenPermitDay);
				}
			}

			if (hasTotalPermitDay< DateUtil.calculateDayDiff(permitDto.getStartDate(),permitDto.getFinishDate())){
				operationResult.setResultDesc(messageSource.getMessage("error2", null , new Locale("tr", "TR")));
				return operationResult;
			}else {
				long toBeTakenPermitDay = DateUtil.calculateToBePermitDayExcludedWeekend(permitDto.getStartDate(),permitDto.getFinishDate());
				return getOperationResult(permitDto, operationResult, person, hasTotalPermitDay, takenAllPermitDay, toBeTakenPermitDay);
			}
		}catch (Exception ex){
			log.info("requestPermit error");
			operationResult.setResultDesc(AnnualPermitConstants.FAILED);
			operationResult.setResultCode(AnnualPermitConstants.SERVICE_RETURN_CODE_IS_FAILED);
			return operationResult;
		}
	}

	private OperationResult getOperationResult(PermitDto permitDto, OperationResult operationResult, Person person, long hasTotalPermitDay, Long takenAllPermitDay,
			long toBeTakenPermitDay) {
		if (Boolean.TRUE.equals(morePermitRequest(hasTotalPermitDay,takenAllPermitDay,toBeTakenPermitDay))){
			operationResult.setResultDesc(messageSource.getMessage("error3", null , new Locale("tr", "TR")));
			return operationResult;
		}else{
			Permit permit = modelMapper.map(permitDto,Permit.class);
			permit.setPerson(person);
			permitRepository.save(permit);
			operationResult.setResultDesc(messageSource.getMessage("success1", null ,new Locale("tr", "TR")));
			return operationResult;
		}
	}

	private Boolean morePermitRequest(long hasTotalPermitDay , long takenAllPermitDay , long toBeTakenPermitDay){
		return (hasTotalPermitDay - takenAllPermitDay) < toBeTakenPermitDay;
	}
}
