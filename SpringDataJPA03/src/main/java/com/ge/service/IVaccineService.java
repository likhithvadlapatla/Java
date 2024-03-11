package com.ge.service;

import com.ge.dao.Vaccine;
import java.util.List;

public interface IVaccineService {
    public Iterable<Vaccine> fetchDetails(boolean status, String... properties);
    public List<Vaccine> fetchDetails(int pgNo, int pgSize, boolean status, String... properties);
    public void fetchDetailsPagination(int pageSize);
}
