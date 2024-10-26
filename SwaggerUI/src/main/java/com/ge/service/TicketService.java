package com.ge.service;
import com.ge.dao.ITicketRepo;
import org.springframework.stereotype.Service;
@Service
public class TicketService {
    private ITicketRepo repo;

    public TicketService(){
        System.out.println("Ticket service bean created.");
    }

    public void someMessage(){
        System.out.println("Repo Hashcode : "+repo.hashCode());
        long count = repo.count();
        System.out.println("Number of records : "+count);
    }
}
