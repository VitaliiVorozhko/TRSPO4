package com.example.applicant.service;

import com.example.applicant.model.Applicant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


public class ApplicantServiceImpl implements ApplicantService {

    private static final Map<Integer, Applicant> APPLICANT_REPOSITORY_MAP = new HashMap<>();
    private static final AtomicInteger APPLICANT_ID_HOLDER = new AtomicInteger();

    @Override
    public void createApplicant(Applicant applicant) {
        final int applicantId = APPLICANT_ID_HOLDER.incrementAndGet();
        applicant.setApplicantId(applicantId);

        APPLICANT_REPOSITORY_MAP.put(applicantId, applicant);
    }

    @Override
    public List<Applicant> readAllApplicants() {
        return new ArrayList<>(APPLICANT_REPOSITORY_MAP.values());
    }

    @Override
    public Applicant readApplicant(int applicantId) {
        return APPLICANT_REPOSITORY_MAP.get(applicantId);
    }

    @Override
    public int readPoint(int facultativeId, int applicantId) {
        int[][] applicantPoints = com.example.facultative.service.EducationServiceImpl.FACULTATIVE_REPOSITORY_MAP.get(facultativeId).getApplicantPoints();
        return applicantPoints[applicantId -1][1];
    }

    @Override
    public List<Applicant> readApplicantsInFacultative(int facultativeId) {
        List applicantList = new ArrayList();
        int[][] applicantPoints = com.example.facultative.service.EducationServiceImpl.FACULTATIVE_REPOSITORY_MAP.get(facultativeId).getApplicantPoints();
        for(int i=0;i<applicantPoints.length;i++){
            applicantList.add(APPLICANT_REPOSITORY_MAP.get(applicantPoints[i][0]));
        }

        return applicantList;

    }

    @Override
    public boolean updateApplicant(Applicant applicant, int applicantId) {
        if (APPLICANT_REPOSITORY_MAP.containsKey(applicantId)) {
            applicant.setApplicantId(applicantId);
            APPLICANT_REPOSITORY_MAP.put(applicantId, applicant);
            return true;
        }
        return false;
    }


    @Override
    public boolean deleteApplicant(int applicantId) {
        return APPLICANT_REPOSITORY_MAP.remove(applicantId) != null;
    }

}