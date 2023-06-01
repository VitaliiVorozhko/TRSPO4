package com.example.facultative.controller;

import com.example.facultative.model.Facultative;
import com.example.facultative.model.Administator;
import com.example.facultative.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServiceController {


    private final EducationService educationService;
    @Autowired
    public ServiceController(EducationService educationService) {
        this.educationService = educationService;
    }

    //post

    @PostMapping(value = "/administrator")
    public ResponseEntity<?> create(@RequestBody Administator administator) {
        educationService.createAdministrator(administator);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PostMapping(value = "/facultative")
    public ResponseEntity<?> create(@RequestBody Facultative facultative) {
        educationService.createFacultative(facultative);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //get

    @GetMapping(value = "/administrators")
    public ResponseEntity<List<Administator>> readAdministrators() {
        final List<Administator> administators = educationService.readAllAdministrators();

        return administators != null && !administators.isEmpty()
                ? new ResponseEntity<>(administators, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/administrators/{administratorId}")
    public ResponseEntity<Administator> readAdministrators(@PathVariable(name = "administratorId") int administratorId) {
        final Administator administator = educationService.readAdministrator(administratorId);

        return administator != null
                ? new ResponseEntity<>(administator, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "/facultatives")
    public ResponseEntity<List<Facultative>> readFacultatives() {
        final List<Facultative> facultative = educationService.readAllFacultatives();

        return facultative != null && !facultative.isEmpty()
                ? new ResponseEntity<>(facultative, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/facultatives/{facultativeId}")
    public ResponseEntity<Facultative> readFacultatives(@PathVariable(name = "facultativeId") int facultativeId) {
        final Facultative facultative = educationService.readFacultative(facultativeId);

        return facultative != null
                ? new ResponseEntity<>(facultative, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //put

    @PutMapping(value = "/administrators/{administratorrId}")
    public ResponseEntity<?> updateAdministrator(@PathVariable(name = "administratorId") int administratorId, @RequestBody Administator administator) {
        final boolean updated = educationService.updateAdministrator(administator, administratorId);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PutMapping(value = "/facultatives/{facultativeId}")
    public ResponseEntity<?> updateFacultative(@PathVariable(name = "facultativeId") int facultativeId, @RequestBody Facultative facultative) {
        final boolean updated = educationService.updateFacultative(facultative, facultativeId);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    //delete

    @DeleteMapping(value = "/administrators/{administratorId}")
    public ResponseEntity<?> deleteAdministrator(@PathVariable(name = "administratorId") int administratorId) {
        final boolean deleted = educationService.deleteAdministrator(administratorId);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}