package com.example.facultative.service;

import com.example.facultative.model.Facultative;
import com.example.facultative.model.Administator;


import java.util.List;

public interface EducationService {
    void createAdministrator(Administator administator);


    void createFacultative(Facultative facultative);

    List<Administator> readAllAdministrators();

    Administator readAdministrator(int administratorId);

    List<Facultative> readAllFacultatives();

    Facultative readFacultative(int facultativeId);

    boolean updateAdministrator(Administator administator, int administratorId);

    boolean updateFacultative(Facultative facultative, int facultativeId);

    boolean deleteAdministrator(int administratorId);

    boolean deleteFacultative(int facultativeId);
}