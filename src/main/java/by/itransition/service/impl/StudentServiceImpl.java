package by.itransition.service.impl;

import by.itransition.entities.Student;
import by.itransition.repository.StudentRepository;
import by.itransition.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student findById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        return repository.deleteById(id);
    }

    @Override
    public boolean update(Student entity) {
        return repository.update(entity);
    }

    @Override
    public boolean save(Student entity) {
        return repository.save(entity);
    }

    @Override
    public List<Student> findAllByCriteria(String field, String order) {
        return repository.findAllByCriteria(field,order);
    }
}
