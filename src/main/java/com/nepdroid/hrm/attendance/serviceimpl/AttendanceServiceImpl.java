package com.nepdroid.hrm.attendance.serviceimpl;

import com.nepdroid.hrm.attendance.model.AttendanceModel;
import com.nepdroid.hrm.attendance.model.WorkShiftModel;
import com.nepdroid.hrm.attendance.repository.AttendanceRepository;
import com.nepdroid.hrm.attendance.repository.WorkShiftRepository;
import com.nepdroid.hrm.attendance.service.AttendanceService;
import com.nepdroid.hrm.employee.model.EmployeeModel;
import com.nepdroid.hrm.employee.repository.EmployeeRepository;
import com.nepdroid.hrm.entity.Response;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
* This class program implements an application that
* simply handles business logic to manage Employee's attendance.
* @author  Samee
* @version 1.0
* @since   2018-11-31 
*/

@Component
public class AttendanceServiceImpl implements AttendanceService {

  @Autowired
  private AttendanceRepository attendanceRepository;
  
  @Autowired
  private EmployeeRepository employeeRepository;
  
  @Autowired
  private WorkShiftRepository workShiftRepository;
  

  /**
   * This is a method to register employee attendance.
   * @param attendanceModel This is a parameter to registerAttendance method.
   * @return Response This returns response of registering attendance. 
   */
  @Override
  public Response registerAttendance(AttendanceModel attendanceModel) {
    EmployeeModel employeeModel =  employeeRepository.findById(attendanceModel.getEmployeeId())
          .get();
    WorkShiftModel workShiftModel = workShiftRepository.findById(employeeModel.getWorkshiftId())
          .get();

    try {
      SimpleDateFormat parser  = new SimpleDateFormat("HH:mm a"); 
      Date workshiftStartTime = parser.parse(workShiftModel.getWorkshiftStartTime());
      Date workshiftEndTime = parser.parse(workShiftModel.getWorkshiftEndTime());
      Date attendanceTime = parser.parse(parser.format(new Date()));

      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
      //String strDate = String.valueOf((dateFormat.format(new Date())));  

      attendanceModel.setAttendanceDate(String.valueOf(dateFormat.format(new Date())));

      long startTimeDifference = (attendanceTime.getTime() - workshiftStartTime
            .getTime()) / (60 * 1000);  //time in minutes
      System.out.println(startTimeDifference);

      long endTimeDifference =  (attendanceTime.getTime() - workshiftEndTime
           .getTime()) / (60 * 1000); 
      System.out.println(endTimeDifference);

      if (workshiftStartTime.before(attendanceTime)) {
        //System.out.println("you are late by" + startTimeDifference + "minutes");
        attendanceModel.setComment("you are late by " + startTimeDifference + " minutes");
      } else {
        attendanceModel.setComment("Always keep your attendance on time");
      }
      
      AttendanceModel amodel =  new AttendanceModel();
      
      try {
    
        amodel = attendanceRepository.findByEmployeeIdAndAttendanceDate(attendanceModel
                       .getEmployeeId(), attendanceModel.getAttendanceDate());

        if (amodel.getAttendanceEndTime() == null || amodel.getAttendanceEndTime().isEmpty()) {

          amodel.setAttendanceEndTime(attendanceTime.toString());
          amodel.setEndTimeDifference(String.valueOf(endTimeDifference));
          attendanceRepository.save(amodel);

        } else {
          System.out.println("Attendance already done");
          //throw new NoResultException();
        }

      } catch (Exception ex) {

        if (ex.toString() != null) {
      
          attendanceModel.setAttendanceStartTime(attendanceTime.toString());
          attendanceModel.setStartTimeDifference(String.valueOf(startTimeDifference));
          attendanceRepository.save(attendanceModel);
        }

      } 

    } catch (ParseException e) {
      e.printStackTrace();
    }

    Response response = new Response();
    return response;
  }
  
  /**
   * This is a method to update employee attendance.
   * @param attendanceModel This is a parameter to updateAttendance method.
   * @return Response This returns response of updating attendance. 
   */
  @Override
  public Response updateAttendance(AttendanceModel attendanceModel) {

    if (attendanceRepository.existsById(attendanceModel.getAttendanceId())) {
      registerAttendance(attendanceModel);
    } 
    Response response = new Response();
    return response;  
  }
  
}
  