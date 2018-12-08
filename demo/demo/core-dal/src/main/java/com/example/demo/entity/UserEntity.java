package com.example.demo.entity;




import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author zhangyi  2018-09-01-13:52
 * @description
 */

@Entity
@Data
@Table(name = "user")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;

    @NotBlank(message = "用户名不能为空")
    @Column(name = "username")
    private String username ;

    @NotBlank(message = "密码名不能为空")
    @Column(name = "password")
    private String password ;

}
