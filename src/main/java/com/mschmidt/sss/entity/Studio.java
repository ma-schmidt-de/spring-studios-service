package com.mschmidt.sss.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Studio {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;

    private String country;
    private int headCount;

    public Studio(String name, String description, String country, int headCount) {
        this.name = name;
        this.description = description;
        this.country = country;
        this.headCount = headCount;
    }
}
