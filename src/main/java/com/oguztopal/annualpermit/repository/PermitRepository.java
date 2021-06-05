package com.oguztopal.annualpermit.repository;

import com.oguztopal.annualpermit.entity.Permit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PermitRepository extends JpaRepository<Permit,Long> {

	@Query(value = "SELECT nvl(sum(datediff('DAY',p.start_date,p.finish_date)),0) FROM Permit p where p.person_id = :personId and PERMISSION_STATUS='APPROVED'", nativeQuery = true)
	Long getAllPermittedDays(@Param("personId") Long personId);

}
