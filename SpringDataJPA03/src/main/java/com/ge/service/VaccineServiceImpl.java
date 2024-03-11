package com.ge.service;

import com.ge.dao.IVaccineRepo;
import com.ge.dao.Vaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineServiceImpl implements IVaccineService{

    @Autowired
    private IVaccineRepo repo;

    /*We are creating fetchDetails method with two parameters i.e., status and properties as we need to pass sort object to findAll method. One parameter status is used to tell whether sorting takes place in Ascending or Descending order. Second parameter properties is used to tell based on what properties sorting needs to happen.*/
    /*If the status is true the properties will be sorted in Ascending Order else they will be sorted in descending order.*/
    /*(String... properties) is a varargs parameter in java, which allows you to pass a variable number of arguments of type String.*/
    @Override
    public Iterable<Vaccine> fetchDetails(boolean status, String... properties) {
        Sort sort = Sort.by(status? Sort.Direction.ASC: Sort.Direction.DESC, properties);
        return repo.findAll(sort);
    }

    @Override
    public List<Vaccine> fetchDetails(int pgNo, int pgSize, boolean status, String... properties) {
        PageRequest pageable = PageRequest.of(pgNo,pgSize,status? Sort.Direction.ASC : Sort.Direction.DESC,properties);
        /*This page object contains the list of the vaccines.*/
        Page<Vaccine> page = repo.findAll(pageable);
        return page.toList();
    }

    @Override
    public void fetchDetailsPagination(int pageSize) {
        long count=4L;

        long pagesCount = count/pageSize;
        pagesCount = count % pageSize == 0?pagesCount:pagesCount++;

        for(Integer i=0;i<pagesCount;i++){
            PageRequest pageable = PageRequest.of(i,pageSize);
            Page<Vaccine> page = repo.findAll(pageable);
            System.out.println("Page Number : "+i);
            page.getContent().forEach((e)->System.out.println(e.getVaccineName()+" : "+e.getVaccineCompany()));
            System.out.println("---------------------------------------------");
        }
    }
}
