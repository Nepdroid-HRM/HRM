package com.nepdroid.hrm.attendance.service;

import com.nepdroid.hrm.attendance.model.CompanyCalenderModel;
import com.nepdroid.hrm.entity.Response;
import org.springframework.stereotype.Service;

/**
* This is interface class for Company Calender.
* @author  Samee
* @version 1.0
* @since   2018-11-31 
*/
@Service
public interface CompanyCalenderService {

  public Response registerCompanyCalender(CompanyCalenderModel companyCalenderModel);
  
  public Response updateCompanyCalender(CompanyCalenderModel companyCalenderModel);
}


