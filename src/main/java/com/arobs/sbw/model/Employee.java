package com.arobs.sbw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

/**
 * @author vasile.mihali
 * @since 8/12/2020
 */

@NoArgsConstructor
@DynamicUpdate
@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee extends BaseEntityIntegerAuditing {

    @Column(name = "name")
    private String name;
    @Column(name = "role")
    private String role;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

}
