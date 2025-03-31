package com.example.mywebapp.usecases;

import com.example.mywebapp.mybatis.model.Grupe;
import com.example.mywebapp.mybatis.model.Studentas;
import lombok.Getter;
import lombok.Setter;
import com.example.mywebapp.mybatis.dao.GrupeMapper;
import com.example.mywebapp.mybatis.dao.StudentasMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Model
public class StudentaiMyBatis {
    @Inject
    private GrupeMapper grupeMapper;

    @Inject
    private StudentasMapper studentasMapper;

    @Getter
    @Setter
    private Grupe grupe;

    @Getter
    @Setter
    private Studentas studentas = new Studentas();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer grupeId = Integer.parseInt(requestParameters.get("grupeId"));
        this.grupe = grupeMapper.selectByPrimaryKey(grupeId);

        List<Studentas> studentai = grupeMapper.selectStudentsByGroupId(grupeId);
        this.grupe.setStudentai(studentai); // Set the students for the group
    }

    @Transactional
    public void createStudentas() {
        Studentas existingStudent = studentasMapper.selectByNameAndLastName(studentas.getVardas(), studentas.getPavarde());
        if (existingStudent == null) {
            studentas.setGrupeId(grupe.getId());
            studentasMapper.insert(studentas);
        }
    }
}
