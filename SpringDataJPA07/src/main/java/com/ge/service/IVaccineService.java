package com.ge.service;

import com.ge.dao.Vaccine;
import com.ge.view.ResultView1;
import com.ge.view.View;

import java.util.Collection;
import java.util.List;
public interface IVaccineService {
    public <T extends View>List<T> fetchByCostLessThan(Integer cost, Class<T> cls);
}
