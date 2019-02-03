package com.nepdroid.hrm.attendance.service;

import com.nepdroid.hrm.attendance.model.LeaveModel;
import com.nepdroid.hrm.entity.Response;

import org.springframework.stereotype.Service;

/**
* This is interface class for Employee's Leave.
* @author  Samee
* @version 1.0
* @since   2018-11-31 
*/

@Service
public interface LeaveService {

  public Response registerLeave(LeaveModel leaveModel);

  public Response updateLeave(LeaveModel leaveModel);
}