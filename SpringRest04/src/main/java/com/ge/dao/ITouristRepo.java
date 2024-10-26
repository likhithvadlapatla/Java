package com.ge.dao;

import com.ge.model.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITouristRepo extends JpaRepository<Tourist, Integer> {

}
