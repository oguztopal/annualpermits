package com.oguztopal.annualpermit.entity;

import com.oguztopal.annualpermit.enums.PermissionStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "permit")
public class Permit {

	@Id
	@SequenceGenerator(name = "permit_seq_generator", sequenceName = "permit_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permit_seq_generator")
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	private Person person;

	@Column(name = "START_DATE")
	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Column(name = "FINISH_DATE")
	@Temporal(TemporalType.DATE)
	private Date finishDate;

	@Column(name = "PERMISSION_STATUS")
	@Enumerated(EnumType.STRING)
	private PermissionStatus permissionStatus;

	@PrePersist
	public void prePersist(){
		this.permissionStatus = PermissionStatus.WAITING_APPROVAL;
	}


}
