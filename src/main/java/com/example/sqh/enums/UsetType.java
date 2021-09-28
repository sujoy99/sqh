package com.example.sqh.enums;

public enum UsetType {
  ADMIN(1),
  BLOGGER(2);

  private final Integer label;

  UsetType(Integer label) {
    this.label = label;
  }

  public Integer getLabel() {
    return label;
  }
}
