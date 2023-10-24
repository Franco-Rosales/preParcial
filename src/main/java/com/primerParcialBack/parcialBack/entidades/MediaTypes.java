package com.primerParcialBack.parcialBack.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "media_types")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MediaTypes {
        @Id
        @GeneratedValue(generator = "mediaTypesGenerator")
        @TableGenerator(name = "mediaTypesGenerator", table = "sqlite_sequence",
                pkColumnName = "name", valueColumnName = "seq",
                pkColumnValue = "media_types",
                initialValue = 1, allocationSize = 1)
        @Column(name = "mediatypeid")
        private long mediaTypeId;

        @Column(name = "name")
        private String name;


}
