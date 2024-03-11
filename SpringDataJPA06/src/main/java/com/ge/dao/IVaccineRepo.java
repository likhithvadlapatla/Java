package com.ge.dao;

import com.ge.view.ResultView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface IVaccineRepo extends JpaRepository<Vaccine, Integer>
{
    public List<ResultView> findByCostLessThan(Integer cost);
}