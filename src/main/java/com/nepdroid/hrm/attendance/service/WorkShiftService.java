package com.nepdroid.hrm.attendance.service;

import com.nepdroid.hrm.attendance.model.WorkShiftModel;
import com.nepdroid.hrm.entity.Response;

import org.springframework.stereotype.Service;

/**
 * This is service interface class for WorkShift Model.
 * @author Samee
 *
 */
@Service
public interface WorkShiftService {
  
  public Response registerWorkShift(WorkShiftModel workShiftModel);
  
  public Response updateWorkShift(WorkShiftModel workShiftModel);

}  
  
