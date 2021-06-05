package com.oguztopal.annualpermit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "person")
public class Person {

	@Id
	@SequenceGenerator(name = "person_seq_generator", sequenceName = "person_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq_generator")
	private Long id;

	@Column(name = "FIRST_NAME" , nullable = false)
	private String firstName;

	@Column(name = "LAST_NAME" , nullable = false)
	private String lastName;

	@Column(name = "HIRE_DATE")
	private Date hireDate;

	@Column(name = "IS_MANAGER")
	private Boolean isManager=false;


	@PrePersist
	public void prePersist() {
		if (Objects.isNull(hireDate)){
			this.hireDate = new Date(System.currentTimeMillis());
		}
	}
}
