package by.itransition.repository.impl;

import by.itransition.entities.Job;
import by.itransition.jdbc_connection.JdbcConnection;
import by.itransition.repository.BaseRepository;
import by.itransition.repository.JobRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class JobRepositoryImpl implements JobRepository {

    private static final String INSERT = "INSERT INTO jobs (userId,name) values (?, ?)";

    private final JdbcConnection connection;

    public JobRepositoryImpl(JdbcConnection connection) {
        this.connection = connection;
    }

    @Override
    public boolean save(Job job, int userId) {
        try(Connection conn = connection.getConnection();
            PreparedStatement statement = conn.prepareStatement(INSERT)) {
            statement.setInt(1,userId);
            statement.setString(2, job.getName());
            return statement.executeUpdate() != 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
