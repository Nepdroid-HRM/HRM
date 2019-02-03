package com.nepdroid.hrm.allowanceandcompensation.controller;

import com.nepdroid.hrm.allowanceandcompensation.model.AllowanceAndCompensationModel;
import com.nepdroid.hrm.allowanceandcompensation.repository.AllowanceAndCompensationRepository;
import com.nepdroid.hrm.allowanceandcompensation.service.AllowanceAndCompensationService;
import com.nepdroid.hrm.entity.Response;
import com.nepdroid.hrm.exception.ResourceNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class program implements an application that simply performs CRUD operations
 * for Employee's AllowanceAndCompensation Model.
 * @author Samee
 */
@RestController
public class AllowanceAndCompensationController {

  @Autowired
  AllowanceAndCompensationRepository allowanceAndCompensationRepository;

  @Autowired
  AllowanceAndCompensationService allowanceAndCompensationService;

  /**
   * This is a method to fetch all AllowanceAndCompensation details. 
   * @return ResponseEntity This returns response of fetching AllowanceAndCompensation model list
   */
  @GetMapping("/getAllAllowanceAndCompensation")
  public ResponseEntity<List<AllowanceAndCompensationModel>> getAllAllowanceAndCompensation() {

    List<AllowanceAndCompensationModel> list = allowanceAndCompensationRepository.findAll();
    if (list.isEmpty()) {
      return new ResponseEntity<List<AllowanceAndCompensationModel>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<AllowanceAndCompensationModel>>(list, HttpStatus.OK);
  }

  /**
   * This is a method to register AllowanceAndCompensation details
   * upon request.
   * @param allowanceAndCompensationModel This is a parameter to registerAllowanceAndCompensation
   *     method.
   * @param result This is a parameter to registerAllowanceAndCompensation method.
   * @return ResponseEntity This returns response of registering AllowanceAndCompensation model  
   */
  @PostMapping("/registerAllowanceAndCompensation")
  public ResponseEntity<Response> registerAllowanceAndCompensation(@Valid @RequestBody
      AllowanceAndCompensationModel allowanceAndCompensationModel, Errors result) {

    Response response = new Response();
    if (result.hasErrors()) {
      // Get error message
      Map<String, String> errors = result.getFieldErrors().stream()
           .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

      response.setStatus(false);
      response.setErrorMessages(errors);
      return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);

    } else {

      // Implement business logic to save allowance and compensation into database
      try {

        allowanceAndCompensationService
            .registerAllowanceAndCompensation(allowanceAndCompensationModel);
        response.setStatus(true);
        response.setAllowanceAndCompensationModel(allowanceAndCompensationModel);

      } catch (Exception ex) {

        Map<String, String> errors = new HashMap<>();
        errors.put("Error message", ex.toString());
        response.setStatus(false);
        response.setErrorMessages(errors);
        return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);

      }
      return new ResponseEntity<Response>(response, HttpStatus.CREATED);
    }
  }


  /**
   * This is a method to update allowanceAndCompensation details
   * upon request.
   * @param allowanceAndCompensationModel This is a parameter to updateAllowanceAndCompensation
   *     method.
   * @param result This is a parameter to updateAllowanceAndCompensation method.
   * @return ResponseEntity This returns response of updating allowanceAndCompensation Model  
   */
  @PutMapping("/updateAllowanceAndCompensation")
  public ResponseEntity<Response> updateAllowanceAndCompensation(@Valid @RequestBody
      AllowanceAndCompensationModel allowanceAndCompensationModel, Errors result) {

    Response response = new Response();
    if (result.hasErrors()) {
      // Get error message
      Map<String, String> errors = result.getFieldErrors().stream()
            .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

      response.setStatus(false);
      response.setErrorMessages(errors);
      return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);

    } else {

      try {

        allowanceAndCompensationService
            .updateAllowanceAndCompensation(allowanceAndCompensationModel);
        response.setStatus(true);
        response.setAllowanceAndCompensationModel(allowanceAndCompensationModel);

      } catch (Exception ex) {

        Map<String, String> errors = new HashMap<>();
        errors.put("Error message", ex.toString());
        response.setStatus(false);
        response.setErrorMessages(errors);
        return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);

      }
      return new ResponseEntity<Response>(response, HttpStatus.OK);
    }
  }


  /**
   *  This is a method to delete allowance and compensation detail based on id.
   * @param allowanceId This is a parameter to deleteAllowanceAndCompensation method.
   * @return ResponseEntity This returns response of deleting AllowanceAndCompensation.
   */
  @DeleteMapping("/deleteAllowanceAndCompensation/{allowanceId}")
  public ResponseEntity<Response> deleteAllowanceAndCompensation(@PathVariable("allowanceId")
        String allowanceId) {

    Response response = new Response();
    AllowanceAndCompensationModel allowanceAndCompensationModel = allowanceAndCompensationRepository
        .findById(allowanceId).get();
    if (allowanceAndCompensationModel == null) {
      throw new ResourceNotFoundException("Unable to delete. Allowance and compensation detail"
          + "with id:" + allowanceId + "not found");
    }
    allowanceAndCompensationRepository.delete(allowanceAndCompensationModel);
    response.setStatus(true);
    return new ResponseEntity<Response>(response, HttpStatus.NO_CONTENT);
  }


  /**
   * This is a method to fetch AllowanceAndCompensation detail by id.
   * @param allowanceId This is a parameter to getByAllowanceId method.
   * @return ResponseEntity This returns response of fetching AllowanceAndCompensation Model.
   */
  @GetMapping("/getByAllowanceId/{allowanceId}")
  public ResponseEntity<AllowanceAndCompensationModel> getByAllowanceId(
      @PathVariable("allowanceId") String allowanceId) {

    AllowanceAndCompensationModel allowanceAndCompensationModel = allowanceAndCompensationRepository
        .findById(allowanceId).get();
    if (allowanceAndCompensationModel == null) {
      throw new ResourceNotFoundException(
        "Allowance and Compensation Detail with Id:" + allowanceId + "not found");
    }
    return new ResponseEntity<AllowanceAndCompensationModel>(allowanceAndCompensationModel,
        HttpStatus.OK);
  }

}
