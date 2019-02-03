package com.nepdroid.hrm.attendance.service;

import com.nepdroid.hrm.attendance.model.AttendanceModel;
import com.nepdroid.hrm.entity.Response;

import org.springframework.stereotype.Service;

/**
* This is interface class for Employee's attendance.
* @author  Samee
* @version 1.0
* @since   2018-11-31 
*/

@Service
public interface AttendanceService {

  public Response registerAttendance(AttendanceModel attendanceModel);
  
  public Response updateAttendance(AttendanceModel attendanceModel);
  
}
