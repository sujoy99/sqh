package com.example.sqh.enums;

public enum Status {
  ACTIVE(1),
  INACTIVE(0);

  private final Integer label;

  Status(Integer label) {
    this.label = label;
  }

  public Integer getLabel() {
    return label;
  }
}
