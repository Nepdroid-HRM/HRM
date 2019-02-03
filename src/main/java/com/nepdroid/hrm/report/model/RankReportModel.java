package com.nepdroid.hrm.report.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nepdroid.hrm.entity.AuditModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * This is a model class for Company Employee Rank Report Model
 * with its getter and setter functions. 
 *
 * @author  Bipin Shrestha
 * @version 1.0
 * @since   2019-01-06 
 */
@Entity
@Table(name = "emp_rank")
public class RankReportModel extends AuditModel {

  /**
   * During serialization, java runtime associates a version number with each serializable class. 
   * This number called serialVersionUID, which is used during deserialization to verify that 
   * the sender and receiver of a serialized object have loaded classes for that object that are 
   * compatible with respect to serialization.
   */
  private static final long serialVersionUID = 6375408055594220400L;

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "RANK_ID")
  private String rankId;
  
  @Column(name = "RANK_NAME")
  @NotNull(message = "rank is required")
  private String rankName;
  
  @Column(name = "SALARY_RANGE") //range as 20000,50000 in front-end 
  @NotNull(message = "rank salary range is required")
  private String salaryRange;
  
  @Column(name = "DELETE_FLAG", nullable = true)
  private String deleteFlag;
  
  
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "DEPARTMENT_ID", nullable = true)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIgnore
  private DepartmentReportModel departmentReportModel1;
  
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "SUB_DEPARTMENT_ID", nullable = true)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIgnore
  private SubDepartmentReportModel subDepartmentReportModel;
  
  public String getRankId() {
    return rankId;
  }

  public void setRankId(String rankId) {
    this.rankId = rankId;
  }

  public String getRankName() {
    return rankName;
  }

  public void setRankName(String rankName) {
    this.rankName = rankName;
  }

  public String getSalaryRange() {
    return salaryRange;
  }

  public void setSalaryRange(String salaryRange) {
    this.salaryRange = salaryRange;
  }

  public String getDeleteFlag() {
    return deleteFlag;
  }

  public void setDeleteFlag(String deleteFlag) {
    this.deleteFlag = deleteFlag;
  }

  public DepartmentReportModel getDepartmentReportModel1() {
    return departmentReportModel1;
  }

  public void setDepartmentReportModel1(DepartmentReportModel departmentReportModel1) {
    this.departmentReportModel1 = departmentReportModel1;
  }

  public SubDepartmentReportModel getSubDepartmentReportModel() {
    return subDepartmentReportModel;
  }

  public void setSubDepartmentReportModel(SubDepartmentReportModel subDepartmentReportModel) {
    this.subDepartmentReportModel = subDepartmentReportModel;
  }

  @Override
  public String toString() {
    return "RankReportModel [rankId=" + rankId + ", rankName=" + rankName + ", salaryRange="
      + salaryRange + ", departmentReportModel1=" + departmentReportModel1 + ","
      + "subDepartmentReportModel=" + subDepartmentReportModel + "]";
  }

}