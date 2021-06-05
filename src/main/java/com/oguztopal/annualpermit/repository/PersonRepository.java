package com.oguztopal.annualpermit.repository;

import com.oguztopal.annualpermit.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {

}
