package com.example.mywebapp.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "STUDENTAS")
@NamedQueries({
        @NamedQuery(name = "Studentas.findAll", query = "select s from Studentas as s")
})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Studentas implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Size(max = 50)
    @Column(name = "VARDAS", nullable = false)
    private String vardas;

    @Size(max = 50)
    @Column(name = "PAVARDE", nullable = false)
    private String pavarde;

    @ManyToOne
    @JoinColumn(name = "GRUPE_ID", nullable = false)
    private Grupe grupe;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PasirenkamasKursas> pasirenkamiKursai = new ArrayList<>();
}