package com.rhapsody.controller;

import com.rhapsody.model.RhapsodyModel;
import com.rhapsody.repository.RhapsodyRepo;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping
@ResponseBody
public class RhapsodyController {

    @Autowired(required = false)
    RhapsodyRepo rhapsodyRepo;

    @GetMapping("/")
    public ResponseEntity<List<RhapsodyModel>> getAllPosts(@RequestParam(required = false) String eventId) {
        try {
            List<RhapsodyModel> posts = new ArrayList<RhapsodyModel>();

            if (eventId == null)
                rhapsodyRepo.findAll().forEach(posts::add);
            else
                rhapsodyRepo.findByEventIdContaining(eventId).forEach(posts::add);

            if (posts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(posts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/AdminPage")
    public ResponseEntity<RhapsodyModel> createTutorial(@RequestBody RhapsodyModel model) {
        try {
            RhapsodyModel test = rhapsodyRepo
                    .save(new RhapsodyModel(model.getEventId(), model.getTimeStamp().toLocalDate(), model.getAggregateId()));
            return new ResponseEntity<>(test, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
