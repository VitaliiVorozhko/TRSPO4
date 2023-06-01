package com.example.applicant.service;


import com.example.applicant.model.Applicant;

import java.util.List;

public interface ApplicantService {

    void createApplicant(Applicant applicant);

    List<Applicant> readAllApplicants();

    Applicant readApplicant(int applicantId);

    int readPoint(int facultativeId, int applicantId);

    List<Applicant> readApplicantsInFacultative(int facultativeId);

    boolean updateApplicant(Applicant applicant, int applicantId);

    boolean deleteApplicant(int applicantId);


}
