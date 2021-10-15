package by.itransition.repository;

import by.itransition.entities.Job;

public interface JobRepository {

    boolean save (Job job,int userId);
}
