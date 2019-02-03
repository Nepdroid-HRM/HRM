package com.nepdroid.hrm.allowanceandcompensation.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nepdroid.hrm.entity.AuditModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

/**
 * This is a model class for Company AllowanceAndCompensation Details
 * with its getter and setter functions. 
 * @author Samee
 *
 */
@Entity
@Table(name = "allowanceAndCompensation")
public class AllowanceAndCompensationModel extends AuditModel {

  /**
   * This is a serial UID version number.
   */
  private static final long serialVersionUID = -4281625286184254180L;

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "ALLOWANCE_ID")
  private String allowanceId;

  @Column(name = "ALLOWANCE_TYPE")
  @NotNull
  private String allowanceType;

  @Column(name = "PAYMENT_TYPE")
  @NotNull
  private String paymentType;

  @Column(name = "PERCENTAGE")
  private String percentage;

  @Column(name = "CASH")
  private String cash;

  @Column(name = "PAYMENT_FROM")
  private String paymentFrom;

  @Column(name = "UNIT")
  private String unit;

  @Column(name = "PROJECT_ID")
  private String projectId;

  @Column(name = "PAYMENT_SCHEDULE")
  private String paymentSchedule;

  @Column(name = "COMPLETE_DATE")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private String completeDate;

  public String getAllowanceId() {
    return allowanceId;
  }

  public void setAllowanceId(String allowanceId) {
    this.allowanceId = allowanceId;
  }

  public String getAllowanceType() {
    return allowanceType;
  }

  public void setAllowanceType(String allowanceType) {
    this.allowanceType = allowanceType;
  }

  public String getPaymentType() {
    return paymentType;
  }

  public void setPaymentType(String paymentType) {
    this.paymentType = paymentType;
  }

  public String getPercentage() {
    return percentage;
  }

  public void setPercentage(String percentage) {
    this.percentage = percentage;
  }

  public String getCash() {
    return cash;
  }

  public void setCash(String cash) {
    this.cash = cash;
  }

  public String getPaymentFrom() {
    return paymentFrom;
  }

  public void setPaymentFrom(String paymentFrom) {
    this.paymentFrom = paymentFrom;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public String getProjectId() {
    return projectId;
  }

  public void setProjectId(String projectId) {
    this.projectId = projectId;
  }

  public String getPaymentSchedule() {
    return paymentSchedule;
  }

  public void setPaymentSchedule(String paymentSchedule) {
    this.paymentSchedule = paymentSchedule;
  }

  public String getCompleteDate() {
    return completeDate;
  }

  public void setCompleteDate(String completeDate) {
  }

  @Override
  public String toString() {
    return "AllowanceAndCompensationModel [allowanceId=" + allowanceId + ", allowanceType="
      + allowanceType + ", paymentType=" + paymentType + ", percentage=" + percentage + ","
      + "cash=" + cash + ", paymentFrom=" + paymentFrom + ", unit=" + unit + ", projectId="
      + projectId + ", paymentSchedule=" + paymentSchedule + ", completeDate=" + completeDate + "]";
  }

}
