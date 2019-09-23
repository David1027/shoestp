package com.shoestp.test.entity;

import javax.persistence.*;
import lombok.Data;

/**
 * (Test)表实体类
 *
 * @author lingjian
 * @since 2019-09-23 14:03:02
 */
@Entity
@Table(name = "test")
@Data
public class Test {

  @Id @GeneratedValue private Integer id;
  /** 名称 */
  @Column(name = "name")
  private String name;
  /** 性别 */
  @Column(name = "gender")
  private String gender;
}
