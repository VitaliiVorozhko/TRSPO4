package com.example.facultative.model;

public class Facultative {
    private Integer facultativeId;
    private String name;
    private Integer administratorId;
    private Integer durationMonths;
    int[][] archive = new int[6][2];

    public int[][] getApplicantPoints() {
        return archive;
    }

    public void setApplicantPoints(int[][] studentEstimates) {
        this.archive = studentEstimates;
    }

    public Integer getFacultativeId() {
        return facultativeId;
    }

    public void setFacultativeId(Integer facultativeId) {
        this.facultativeId = facultativeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(Integer administratorId) {
        this.administratorId = administratorId;
    }

}
