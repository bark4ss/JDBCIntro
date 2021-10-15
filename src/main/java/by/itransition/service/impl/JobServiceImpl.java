package by.itransition.service.impl;

import by.itransition.entities.Job;
import by.itransition.repository.BaseRepository;
import by.itransition.repository.JobRepository;
import by.itransition.service.JobService;

import java.util.List;

public class JobServiceImpl implements JobService {

    private JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public boolean save(Job job, int userId) {
        return jobRepository.save(job,userId);
    }
}
