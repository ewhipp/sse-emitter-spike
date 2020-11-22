package org.whipp.serversentevents.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.whipp.serversentevents.demo.service.UnlockService;


@RestController
@RequestMapping("api/v1/event/unlock")
public class UnlockController {

    UnlockService service;

    @Autowired
    public UnlockController(UnlockService service) {
        this.service = service;
    }

    @PutMapping
    ResponseEntity<HttpStatus> unlockContent(@RequestParam String dmsId) {
        service.unlock(dmsId);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }



}
