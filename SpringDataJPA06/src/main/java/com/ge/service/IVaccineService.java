package com.ge.service;

import com.ge.dao.Vaccine;
import com.ge.view.ResultView;

import java.util.Collection;
import java.util.List;
public interface IVaccineService {
    public List<ResultView> fetchByCostLessThan(Integer cost);
}
