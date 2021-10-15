package by.itransition.repository;

import by.itransition.entities.Student;

import java.util.List;

public interface StudentRepository extends BaseRepository<Student>{
    List<Student> findAllByCriteria(String field, String order);
}
