package com.example.mywebapp.usecases;

import com.example.mywebapp.mybatis.model.PasirenkamasKursas;
import com.example.mywebapp.mybatis.model.Studentas;
import com.example.mywebapp.mybatis.dao.PasirenkamasKursasMapper;
import com.example.mywebapp.mybatis.dao.StudentasMapper;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Model
public class PasirenkamiKursaiMyBatis {
    @Inject
    private PasirenkamasKursasMapper pasirenkamiKursaiMapper;

    @Inject
    private StudentasMapper studentasMapper;

    @Getter
    @Setter
    private Studentas studentas;

    @Getter
    @Setter
    private Integer selectedCourseId;

    @Getter
    @Setter
    private PasirenkamasKursas newCourse = new PasirenkamasKursas();

    @Getter
    private List<PasirenkamasKursas> availableCourses;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer studentId = Integer.parseInt(requestParameters.get("studentasId"));
        this.studentas = studentasMapper.selectByPrimaryKey(studentId);
        loadAvailableCourses();

        List<PasirenkamasKursas> kursai = studentasMapper.selectCoursesByStudentId(studentId);
        this.studentas.setPasirenkamiKursai(kursai);
    }

    private void loadAvailableCourses() {
        availableCourses = pasirenkamiKursaiMapper.selectAll();
    }

    @Transactional
    public void addCourseToStudent() {
        if (selectedCourseId != null) {
            PasirenkamasKursas course = pasirenkamiKursaiMapper.selectByPrimaryKey(selectedCourseId);
            if (course != null && !studentas.getPasirenkamiKursai().contains(course)) {
                studentas.getPasirenkamiKursai().add(course);
                studentasMapper.updateByPrimaryKey(studentas);
                studentasMapper.insertCourseForStudent(studentas, course);
            }
        }
    }

    @Transactional
    public void createCourse() {
        pasirenkamiKursaiMapper.insert(newCourse);
    }
}
