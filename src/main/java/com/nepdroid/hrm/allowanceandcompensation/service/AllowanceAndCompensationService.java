package com.nepdroid.hrm.allowanceandcompensation.service;

import com.nepdroid.hrm.allowanceandcompensation.model.AllowanceAndCompensationModel;
import com.nepdroid.hrm.entity.Response;

import org.springframework.stereotype.Service;

/**
 * This is service interface for AllowanceAndCompensation Model.
 * @author Samee
 *
 */
@Service
public interface AllowanceAndCompensationService {

  public Response registerAllowanceAndCompensation(AllowanceAndCompensationModel 
      allowanceAndCompensationModel);
  
  public Response updateAllowanceAndCompensation(AllowanceAndCompensationModel 
      allowanceAndCompensationModel);

}
