package com.ge.service;

import com.ge.dao.IVaccineRepo;
import com.ge.dao.Vaccine;
import com.ge.view.ResultView1;
import com.ge.view.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class VaccineServiceImpl implements IVaccineService{

    @Autowired
    private IVaccineRepo repo;

    @Override
    public <T extends View>List<T> fetchByCostLessThan(Integer cost, Class<T> cls) {
        return repo.findByCostLessThan(cost,cls);
    }
}
