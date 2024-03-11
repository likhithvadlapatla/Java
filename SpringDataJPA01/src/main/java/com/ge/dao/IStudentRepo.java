package com.ge.dao;

import org.springframework.data.repository.CrudRepository;

/*We need to pass two parameters when extending CrudRepository one of which is the entity class that you are going to work on and another one is the data type of the primary key column.*/
/*We are telling Spring Data JPA that we are going to work with Student Entity class.*/
public interface IStudentRepo extends CrudRepository<Student, Integer>{

}
