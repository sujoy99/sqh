package com.example.sqh.entity;

import com.example.sqh.enums.Status;
import com.example.sqh.enums.UsetType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "USER")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "USER_ID")
  private Long id;

  @Column(name = "USER_NAME", length = 25)
  private String name;

  @Column(name = "PASSWORD")
  private String password;

  @Column(name = "ADDRESS")
  private String address;

  @Column(name = "USER_TYPE")
  private UsetType userType;

  @Column(name = "STATUS")
  private Status status;
}
