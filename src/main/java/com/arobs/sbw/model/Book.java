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
@Table(name = "books")
public class Book extends BaseEntityIntegerAuditing {

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "description")
    private String description;

}
