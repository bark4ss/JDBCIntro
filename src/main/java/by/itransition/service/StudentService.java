package by.itransition.service;

import by.itransition.entities.Student;

import java.util.List;

public interface StudentService extends BaseService<Student>{
    List<Student> findAllByCriteria(String field, String order);
}
