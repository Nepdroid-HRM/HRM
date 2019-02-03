package com.nepdroid.hrm.attendance.serviceimpl;

import com.nepdroid.hrm.attendance.model.WorkShiftModel;
import com.nepdroid.hrm.attendance.repository.WorkShiftRepository;
import com.nepdroid.hrm.attendance.service.WorkShiftService;
import com.nepdroid.hrm.entity.Response;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This is service implementation class for WorkShift Model.
 * @author Samee
 *
 */
@Component
public class WorkShiftServiceImpl implements WorkShiftService {

  @Autowired
  private WorkShiftRepository workShiftRepository;

  /**
   * This is a method to register work shift.
   * @param workShiftModel This is a parameter to registerWorkShift method.
   * @return This returns response of registering workshift.
   */
  @Override
  public Response registerWorkShift(WorkShiftModel workShiftModel) {

    try {
      SimpleDateFormat format = new SimpleDateFormat("HH:mm a");
      Date workshiftStartTime = format.parse(workShiftModel.getWorkshiftStartTime());
      Date workshiftEndTime = format.parse(workShiftModel.getWorkshiftEndTime());

      double workShiftDifference = (workshiftEndTime.getTime() - workshiftStartTime.getTime()) 
                                        / (1000);  //time in seconds

      DecimalFormat df = new DecimalFormat("#.##");
      //df.setRoundingMode(RoundingMode.CEILING);
      String wsDiff = df.format(workShiftDifference / (60 * 60)); //time in hrs with decimal format
      double breakHours = Double.valueOf(workShiftModel.getBreakHours()); 
      double workingHours = Double.valueOf(wsDiff) - breakHours;

      workShiftModel.setBreakHours(String.valueOf(breakHours));
      workShiftModel.setWorkingHours(String.valueOf(workingHours));
      workShiftRepository.save(workShiftModel);

    } catch (ParseException e) {
      System.out.println(e.toString());
    }
    Response response = new Response();
    return response;

  }

  /**
   * This is a method to update work shift.
   * @param workShiftModel This is a parameter to updateWorkShift method.
   * @return This returns response of  updating workshift.
   */
  @Override
  public Response updateWorkShift(WorkShiftModel workShiftModel) {

    if (workShiftRepository.existsById(workShiftModel.getWorkshiftId())) {
      registerWorkShift(workShiftModel);
    }
    Response response = new Response();
    return response;
  }
  
}
