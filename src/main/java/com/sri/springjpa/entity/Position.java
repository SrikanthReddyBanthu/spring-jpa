package com.sri.springjpa.entity;


import javax.persistence.*;

@Entity
@Table(name = "position")
public class Position {

  @Id
  @Column(name = "position_id")
  private long positionId;
  @Column(name = "position_title")
  private String positionTitle;
  @Column(name = "pay_type")
  private String payType;
  @Column(name = "min_scale")
  private double minScale;
  @Column(name = "max_scale")
  private double maxScale;
  @Column(name = "management_role")
  private String managementRole;

  public long getPositionId() {
    return positionId;
  }

  public void setPositionId(long positionId) {
    this.positionId = positionId;
  }


  public String getPositionTitle() {
    return positionTitle;
  }

  public void setPositionTitle(String positionTitle) {
    this.positionTitle = positionTitle;
  }


  public String getPayType() {
    return payType;
  }

  public void setPayType(String payType) {
    this.payType = payType;
  }


  public double getMinScale() {
    return minScale;
  }

  public void setMinScale(double minScale) {
    this.minScale = minScale;
  }


  public double getMaxScale() {
    return maxScale;
  }

  public void setMaxScale(double maxScale) {
    this.maxScale = maxScale;
  }


  public String getManagementRole() {
    return managementRole;
  }

  public void setManagementRole(String managementRole) {
    this.managementRole = managementRole;
  }

}
