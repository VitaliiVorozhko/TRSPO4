package com.example.facultative.service;

import com.example.facultative.model.Facultative;
import com.example.facultative.model.Administator;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class EducationServiceImpl implements EducationService {


    private static final Map<Integer, Facultative> CLIENT_REPOSITORY_MAP = new HashMap<>();
    private static final Map<Integer, Administator> ADMINISTRATOR_REPOSITORY_MAP = new HashMap<>();

    public static final Map<Integer, Facultative> FACULTATIVE_REPOSITORY_MAP = new HashMap<>();


    private static final AtomicInteger ADMINISTRATRATOR_ID_HOLDER = new AtomicInteger();
    private static final AtomicInteger APPLICANT_ID_HOLDER = new AtomicInteger();
    private static final AtomicInteger FACULTATIVE_ID_HOLDER = new AtomicInteger();

    @Override
    public void createAdministrator(Administator administator) {
        final int administratorId = ADMINISTRATRATOR_ID_HOLDER.incrementAndGet();
        administator.setAdministratorId(administratorId);
        ADMINISTRATOR_REPOSITORY_MAP.put(administratorId, administator);
    }

    @Override
    public void createFacultative(Facultative facultative) {
        final int facultativeId = FACULTATIVE_ID_HOLDER.incrementAndGet();
        facultative.setFacultativeId(facultativeId);
        FACULTATIVE_REPOSITORY_MAP.put(facultativeId, facultative);
    }

    @Override
    public List<Administator> readAllAdministrators() {
        return new ArrayList<>(ADMINISTRATOR_REPOSITORY_MAP.values());
    }

    @Override
    public Administator readAdministrator(int administratorId) {
        return ADMINISTRATOR_REPOSITORY_MAP.get(administratorId);
    }


    @Override
    public List<Facultative> readAllFacultatives() {
        return new ArrayList<>(FACULTATIVE_REPOSITORY_MAP.values());
    }

    @Override
    public Facultative readFacultative(int facultativeId) {
        return FACULTATIVE_REPOSITORY_MAP.get(facultativeId);
    }

    @Override
    public boolean updateAdministrator(Administator administator, int administratorId) {
        if (ADMINISTRATOR_REPOSITORY_MAP.containsKey(administratorId)) {
            administator.setAdministratorId(administratorId);
            ADMINISTRATOR_REPOSITORY_MAP.put(administratorId, administator);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateFacultative(Facultative facultative, int facultativeId) {
        if (FACULTATIVE_REPOSITORY_MAP.containsKey(facultativeId)) {
            facultative.setFacultativeId(facultativeId);
            FACULTATIVE_REPOSITORY_MAP.put(facultativeId, facultative);

            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAdministrator(int administratorId) {
        return ADMINISTRATOR_REPOSITORY_MAP.remove(administratorId) != null;
    }

    @Override
    public boolean deleteFacultative(int facultativeId) {
        return FACULTATIVE_REPOSITORY_MAP.remove(facultativeId) != null;
    }


}