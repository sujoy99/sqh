package com.example.sqh.enums;

public enum Status {
  INACTIVE(0),
  ACTIVE(1);

  private final Integer label;

  Status(Integer label) {
    this.label = label;
  }

  public Integer getLabel() {
    return label;
  }
}
