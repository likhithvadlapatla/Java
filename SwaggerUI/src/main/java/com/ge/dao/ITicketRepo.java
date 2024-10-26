package com.ge.dao;

import com.ge.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITicketRepo extends JpaRepository<Passenger, Integer> {
}
