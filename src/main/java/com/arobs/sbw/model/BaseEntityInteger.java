package com.arobs.sbw.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author vasile.mihali
 * @since 2/24/2020
 */
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntityInteger implements Identifiable<Integer> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BaseEntityInteger)) {
            return false;
        }
        return id != null && id.equals(((BaseEntityInteger) o).getId());
    }

    //to make sure that in each Hibernate state the hashcode is the same
    //WARN: don't change this unless you know what you are doing!
    @Override
    public int hashCode() {
        return 41 * 37;
    }

}
