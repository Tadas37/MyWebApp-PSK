package com.example.mywebapp.usecases;

import lombok.Getter;
import lombok.Setter;
import com.example.mywebapp.mybatis.dao.GrupeMapper;
import com.example.mywebapp.mybatis.model.Grupe;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class GrupesMyBatis {
    @Inject
    private GrupeMapper grupeMapper;

    @Getter
    private List<Grupe> grupes;

    @Getter
    @Setter
    private Grupe grupe = new Grupe();

    @PostConstruct
    public void init() {
        this.loadAllGrupes();
    }

    private void loadAllGrupes() {
        this.grupes = grupeMapper.selectAll();
    }

    @Transactional
    public String createGrupe() {
        Grupe existingGrupe = grupeMapper.selectByNameAndCourse(grupe.getSpecialybe(), grupe.getKursas());
        if (existingGrupe == null) {
            grupeMapper.insert(grupe);
        }
        return "/myBatis/grupes?faces-redirect=true";
    }
}
