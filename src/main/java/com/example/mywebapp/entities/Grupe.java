package com.example.mywebapp.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "GRUPE")
@NamedQueries({
        @NamedQuery(name = "Grupe.findAll", query = "select g from Grupe as g")
})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Grupe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(name = "SPECIALYBE", nullable = false)
    @Size(max = 100)
    private String specialybe;

    @Column(name = "KURSAS", nullable = false)
    private Integer kursas;

    @OneToMany(mappedBy = "grupe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Studentas> studentai = new ArrayList<>();
}