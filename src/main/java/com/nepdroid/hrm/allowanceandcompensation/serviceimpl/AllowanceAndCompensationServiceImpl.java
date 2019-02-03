package com.nepdroid.hrm.allowanceandcompensation.serviceimpl;

import com.nepdroid.hrm.allowanceandcompensation.model.AllowanceAndCompensationModel;
import com.nepdroid.hrm.allowanceandcompensation.repository.AllowanceAndCompensationRepository;
import com.nepdroid.hrm.allowanceandcompensation.service.AllowanceAndCompensationService;
import com.nepdroid.hrm.entity.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This is service implementation class for AllowanceAndCompensation Model.
 * @author Samee
 *
 */
@Component
public class AllowanceAndCompensationServiceImpl implements AllowanceAndCompensationService {

  @Autowired
  AllowanceAndCompensationRepository allowanceAndCompensationRepository;

  /**
   * This is a method to register Allowance And Compensation.
   * It defines logic of selection of percentage or cash payment type.
   * @param allowanceAndCompensationModel This is a parameter to registerAllowanceAndCompensation
   *     method.
   * @return Response This returns response of registering Allowance And Compensation. 
   */
  @Override
  public Response registerAllowanceAndCompensation(AllowanceAndCompensationModel 
      allowanceAndCompensationModel) {

    if (allowanceAndCompensationModel.getPaymentType().equals("percentage")) {
      allowanceAndCompensationModel.setCash(null);
    } else {
      allowanceAndCompensationModel.setPercentage(null);
      allowanceAndCompensationModel.setProjectId(null);
      allowanceAndCompensationModel.setPaymentSchedule(null);
      allowanceAndCompensationModel.setCompleteDate(null);
    }
    allowanceAndCompensationRepository.save(allowanceAndCompensationModel);
    Response response = new Response();
    return response;
  }

  /**
   * This is a method to update Allowance And Compensation.
   * @param allowanceAndCompensationModel This is a parameter to updateAllowanceAndCompensation
   *     method.
   * @return Response This returns response of updating Allowance And Compensation. 
   */
  @Override
  public Response updateAllowanceAndCompensation(AllowanceAndCompensationModel
      allowanceAndCompensationModel) {

    if (allowanceAndCompensationRepository
        .existsById(allowanceAndCompensationModel.getAllowanceId())) {
      registerAllowanceAndCompensation(allowanceAndCompensationModel);
    }
    Response response = new Response();
    return response;  
  }
}

