package com.ge.service;
import com.ge.dao.Alien;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface IAlienService {
    public Alien registerAlienInfo(Alien alien) throws Exception;
    public List<Alien> getAllAlienInfo();
}

