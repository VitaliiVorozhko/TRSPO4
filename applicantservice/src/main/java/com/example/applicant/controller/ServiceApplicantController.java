package com.example.applicant.controller;


import com.example.applicant.model.Applicant;
import com.example.applicant.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServiceApplicantController {



    private final ApplicantService applicantService;
    @Autowired
    public ServiceApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    //post


    @PostMapping(value = "/applicant")
    public ResponseEntity<?> create(@RequestBody Applicant applicant) {
        applicantService.createApplicant(applicant);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }




    //get



    @GetMapping(value = "/applicants")
    public ResponseEntity<List<Applicant>> readApplicants() {
        final List<Applicant> applicants = applicantService.readAllApplicants();

        return applicants != null && !applicants.isEmpty()
                ? new ResponseEntity<>(applicants, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/applicants/{applicantId}")
    public ResponseEntity<Applicant> readApplicants(@PathVariable(name = "applicantId") int applicantId) {
        final Applicant applicant = applicantService.readApplicant(applicantId);

        return applicant != null
                ? new ResponseEntity<>(applicant, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }






    @GetMapping(value = "/facultatives/{facultativeId}/applicants/{applicantId}/point")
    public ResponseEntity<Integer> readPoint(@PathVariable(name = "facultativeId") int facultativeId, @PathVariable(name = "applicantId") int applicantId) {
        final Integer point = applicantService.readPoint(facultativeId, applicantId);

        return point != null
                ? new ResponseEntity<>(point, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/facultatives/{facultativeId}/applicants")
    public ResponseEntity<List<Applicant>> readApplicantsInFacultative(@PathVariable(name = "facultativeId") int facultativeId) {
        final List<Applicant> applicants = applicantService.readApplicantsInFacultative(facultativeId);

        return applicants != null
                ? new ResponseEntity<>(applicants, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    //put



    @PutMapping(value = "/applicants/{applicantId}")
    public ResponseEntity<?> updateApplicant(@PathVariable(name = "applicantId") int applicantId, @RequestBody Applicant applicant) {
        final boolean updated = applicantService.updateApplicant(applicant, applicantId);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }



    //delete



    @DeleteMapping(value = "/applicants/{applicantId}")
    public ResponseEntity<?> deleteApplicant(@PathVariable(name = "applicantId") int applicantId) {
        final boolean deleted = applicantService.deleteApplicant(applicantId);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
