package com.nepdroid.hrm.allowanceandcompensation.repository;

import com.nepdroid.hrm.allowanceandcompensation.model.AllowanceAndCompensationModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllowanceAndCompensationRepository extends
    JpaRepository<AllowanceAndCompensationModel, String> {

}
