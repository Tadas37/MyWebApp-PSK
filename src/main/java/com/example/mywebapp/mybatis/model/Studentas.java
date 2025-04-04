package com.example.mywebapp.mybatis.model;

import java.util.List;

public class Studentas {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.STUDENTAS.ID
     *
     * @mbg.generated Mon Mar 31 04:38:56 EEST 2025
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.STUDENTAS.PAVARDE
     *
     * @mbg.generated Mon Mar 31 04:38:56 EEST 2025
     */
    private String pavarde;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.STUDENTAS.VARDAS
     *
     * @mbg.generated Mon Mar 31 04:38:56 EEST 2025
     */
    private String vardas;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.STUDENTAS.GRUPE_ID
     *
     * @mbg.generated Mon Mar 31 04:38:56 EEST 2025
     */
    private Integer grupeId;

    private Grupe grupe;

    private List<PasirenkamasKursas> pasirenkamiKursai;


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.STUDENTAS.ID
     *
     * @return the value of PUBLIC.STUDENTAS.ID
     *
     * @mbg.generated Mon Mar 31 04:38:56 EEST 2025
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.STUDENTAS.ID
     *
     * @param id the value for PUBLIC.STUDENTAS.ID
     *
     * @mbg.generated Mon Mar 31 04:38:56 EEST 2025
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.STUDENTAS.PAVARDE
     *
     * @return the value of PUBLIC.STUDENTAS.PAVARDE
     *
     * @mbg.generated Mon Mar 31 04:38:56 EEST 2025
     */
    public String getPavarde() {
        return pavarde;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.STUDENTAS.PAVARDE
     *
     * @param pavarde the value for PUBLIC.STUDENTAS.PAVARDE
     *
     * @mbg.generated Mon Mar 31 04:38:56 EEST 2025
     */
    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.STUDENTAS.VARDAS
     *
     * @return the value of PUBLIC.STUDENTAS.VARDAS
     *
     * @mbg.generated Mon Mar 31 04:38:56 EEST 2025
     */
    public String getVardas() {
        return vardas;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.STUDENTAS.VARDAS
     *
     * @param vardas the value for PUBLIC.STUDENTAS.VARDAS
     *
     * @mbg.generated Mon Mar 31 04:38:56 EEST 2025
     */
    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.STUDENTAS.GRUPE_ID
     *
     * @return the value of PUBLIC.STUDENTAS.GRUPE_ID
     *
     * @mbg.generated Mon Mar 31 04:38:56 EEST 2025
     */
    public Integer getGrupeId() {
        return grupeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.STUDENTAS.GRUPE_ID
     *
     * @param grupeId the value for PUBLIC.STUDENTAS.GRUPE_ID
     *
     * @mbg.generated Mon Mar 31 04:38:56 EEST 2025
     */
    public void setGrupeId(Integer grupeId) {
        this.grupeId = grupeId;
    }

    public Grupe getGrupe() {
        return grupe;
    }

    public void setGrupe(Grupe grupe) {
        this.grupe = grupe;
    }

    public List<PasirenkamasKursas> getPasirenkamiKursai() {
        return pasirenkamiKursai;
    }

    public void setPasirenkamiKursai(List<PasirenkamasKursas> pasirenkamiKursai) {
        this.pasirenkamiKursai = pasirenkamiKursai;
    }
}