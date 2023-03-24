package com.rhapsody.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rhapsody.model.RhapsodyModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public interface RhapsodyRepo extends JpaRepository<RhapsodyModel, String> {

    List<RhapsodyModel> findByEventIdContaining(String eventId);

    Optional<RhapsodyModel> findById(String eventId);
    RhapsodyModel save(RhapsodyModel rhapsodyModel);

    void deleteById(String id);

    void deleteAll();
}
