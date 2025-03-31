package com.example.mywebapp.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Getter
@Setter
@Entity
@Table(name = "PASIRENKAMAS_KURSAS")
@NamedQueries({
        @NamedQuery(name = "PasirenkamasKursas.findAll", query = "select p from PasirenkamasKursas as p")
})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PasirenkamasKursas implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(name = "PAVADINIMAS", nullable = false)
    private String pavadinimas;

    @ManyToMany(mappedBy = "pasirenkamiKursai", fetch = FetchType.LAZY)
    private List<Studentas> studentai = new ArrayList<>();
}