package com.example.sqh.enums;

public enum UsetType {
  BLOGGER(0),
  ADMIN(1);

  private final Integer label;

  UsetType(Integer label) {
    this.label = label;
  }

  public Integer getLabel() {
    return label;
  }
}
