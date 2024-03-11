package com.ge.dao;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IVaccineRepo extends JpaRepository<Vaccine, Integer>
{
    @Query("FROM Vaccine WHERE vaccineCompany = :company")
    public List<Vaccine> searchByVaccineCompanyName(String company);
    /*We need to use @Param annotation if the named params in the query and the parameters in the method signature don't match.*/
    @Query("FROM Vaccine WHERE vaccineCompany IN (:company1, :company2)")
    public List<Vaccine> searchByVaccineCompanyName(@Param("company1") String comp1, @Param("company2")String comp2);
    @Query("SELECT vaccineName, vaccineCompany FROM Vaccine WHERE cost BETWEEN :minP AND :maxP")
    public List<String> searchByVaccinePriceRange(Integer minP, Integer maxP);
    /*Since we are selecting two parameters of different data types. We are storing them in Object(Parent class of all data type classes) array.*/
    @Query("SELECT vaccineCompany, cost FROM Vaccine WHERE vaccineName IN(:vac1, :vac2)")
    public List<Object[]> searchVaccineInfoByVaccineName(String vac1, String vac2);
    @Transactional /*This annotation tells that the operation happens completely or it won't start at all.*/
    @Modifying
    @Query("UPDATE Vaccine SET cost=:newCost WHERE vaccineName=:vac")
    public int updatePriceByVaccineName(Integer newCost, String vac);

    @Transactional
    @Modifying
    @Query("DELETE FROM Vaccine WHERE cost BETWEEN :minP AND :maxP")
    public int deleteByVaccinePriceRange(Integer minP, Integer maxP);

    @Transactional
    @Modifying
    @Query(value="INSERT INTO vaccine(id,vaccine_name,vaccine_company,cost) Values(?,?,?,?)", nativeQuery=true)
    public int insertVaccineDetails(Integer id, String vaccineName, String vaccineCompany, Integer cost);

}