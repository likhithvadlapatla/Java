package com.ge.dao;

import com.ge.view.ResultView1;
import com.ge.view.View;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/*
Generic Type <T extends View>:
This declares a generic type T that extends a specific type View. This means that T can be any type that implements the View interface. It ensures that the method can work with various types that extend View.

Return Type List<T>:
The method returns a List of objects of type T. Since T extends View, the returned list will contain instances of types that implement View.

Class<T> cls:
The method also takes a Class<T> parameter. This specifies the type of projection to be used for the results. It allows the caller to specify the type at runtime.
 */
@Repository
public interface IVaccineRepo extends JpaRepository<Vaccine, Integer>
{
    public <T extends View>List<T> findByCostLessThan(Integer cost, Class<T> cls);
}