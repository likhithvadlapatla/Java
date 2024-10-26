package com.ge.service;

import com.ge.dao.ITicketRepo;
import org.hibernate.id.Configurable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TicketService {

    @Autowired
    private ITicketRepo repo;

    public TicketService(){
        System.out.println("Ticket Service Bean Created");
    }

    public void someMessage(){
        System.out.println("Repo Hashcode : "+repo.hashCode());
        long count = repo.count();
        System.out.println("Number of records "+count);
    }

}
