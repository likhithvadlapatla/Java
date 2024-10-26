package com.ge.service;

import com.ge.model.Tourist;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITouristManagement {
    public String registerTourist(Tourist tourist);
    public List<Tourist> fetchAllTourists();
    public Tourist fetchTouristInfoById(Integer id);
    public String updateTouristInfo(Tourist tourist);
    public String updateTouristInfoById(Integer id, Double budget);
    public String deleteTouristById(Integer id);
}
