package by.itransition.repository.impl;

import by.itransition.entities.Job;
import by.itransition.entities.Student;
import by.itransition.jdbc_connection.JdbcConnection;
import by.itransition.repository.BaseRepository;
import by.itransition.repository.StudentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {

    private static final String INSERT = "INSERT INTO students (name,l_name) values (?, ?)";
    private static final String DELETE = "DELETE FROM students where id=?";
    private static final String SELECT_ALL = "SELECT * FROM students";
    private static final String SELECT_BY_ID = "SELECT id,name,l_name,age FROM students where id=?";
    private static final String SELECT_BY_ID_WITH_JOB = "SELECT s.id,s.name,s.l_name,s.age,j.name FROM students s LEFT JOIN jobs j ON s.id=j.userId";
    private static final String SELECT_ALL_ORDER_BY = "SELECT * FROM students ORDER BY l_name ASC";
    private static final String UPDATE = "UPDATE students SET name=?, l_name=?, age=? where id=?";

    private final JdbcConnection connection;

    public StudentRepositoryImpl(JdbcConnection connection) {
        this.connection = connection;
    }
    @Override
    public Student findById(int id) {
        Student student = new Student();
        try(Connection conn = connection.getConnection();
            PreparedStatement statement = conn.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                student.setId(resultSet.getInt(1));
                student.setFirstName(resultSet.getString(2));
                student.setLastName(resultSet.getString(3));
                student.setAge(resultSet.getInt(4));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        try(Connection conn = connection.getConnection();
            Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_BY_ID_WITH_JOB);
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt(1));
                student.setFirstName(resultSet.getString(2));
                student.setLastName(resultSet.getString(3));
                student.setAge(resultSet.getInt(4));
                Job job = new Job();
                job.setName(resultSet.getString(5));
                student.setJob(job);
                students.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return students;
    }

    @Override
    public boolean deleteById(int id) {
        try(Connection conn = connection.getConnection();
            PreparedStatement statement = conn.prepareStatement(DELETE)) {
            statement.setInt(1,id);
            return statement.executeUpdate() != 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Student entity) {
        try(Connection conn = connection.getConnection();
            PreparedStatement statement = conn.prepareStatement(UPDATE)) {
            statement.setString(1,entity.getFirstName());
            statement.setString(2,entity.getLastName());
            statement.setInt(3,entity.getAge());
            statement.setInt(4,entity.getId());
            return statement.executeUpdate() != 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean save(Student entity) {
        try(Connection conn = connection.getConnection();
            PreparedStatement statement = conn.prepareStatement(INSERT)) {
            statement.setString(1,entity.getFirstName());
            statement.setString(2, entity.getLastName());
            return statement.executeUpdate() != 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Student> findAllByCriteria(String field, String order) {
        List<Student> students = new ArrayList<>();
        try(Connection conn = connection.getConnection();
            Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_ORDER_BY);
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt(1));
                student.setFirstName(resultSet.getString(2));
                student.setLastName(resultSet.getString(3));
                student.setAge(resultSet.getInt(4));
                students.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return students;
    }
}
