package com.rhapsody.query.repository;

import com.rhapsody.query.entity.RhapsodyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<RhapsodyModel, String> {
    List<RhapsodyModel> findAll();

    RhapsodyModel save(RhapsodyModel rhapsodyModel);
}
