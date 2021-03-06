package com.nepdroid.hrm.employee.repository;

import com.nepdroid.hrm.employee.model.ContactModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<ContactModel, String> {

}
