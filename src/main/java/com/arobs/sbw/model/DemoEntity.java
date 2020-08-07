package com.arobs.sbw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

/**
 * @author vasile.mihali
 * @since 8/6/2020
 */

@DynamicUpdate
@Getter
@Setter
@Entity
@Table(name = "demo_entity")
public class DemoEntity extends BaseEntityIntegerAuditing {

    public DemoEntity() {
    }

    @Column(name = "description")
    private String description;

    @Column(name = "error_msg")
    private String errorMsg;

}
