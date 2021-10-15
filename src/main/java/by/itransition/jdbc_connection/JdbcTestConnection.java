package by.itransition.jdbc_connection;

import by.itransition.entities.Job;
import by.itransition.entities.Student;
import by.itransition.repository.BaseRepository;
import by.itransition.repository.JobRepository;
import by.itransition.repository.StudentRepository;
import by.itransition.repository.impl.JobRepositoryImpl;
import by.itransition.repository.impl.StudentRepositoryImpl;
import by.itransition.service.BaseService;
import by.itransition.service.JobService;
import by.itransition.service.StudentService;
import by.itransition.service.impl.JobServiceImpl;
import by.itransition.service.impl.StudentServiceImpl;

public class JdbcTestConnection {
    public static void main(String[] args) {

        JdbcConnection connection = new JdbcConnection();
        StudentRepository repository = new StudentRepositoryImpl(connection);
        JobRepository repository1 = new JobRepositoryImpl(connection);
        JobService jobService = new JobServiceImpl(repository1);
        /*Job job = new Job("developer");
        jobService.save(job,1);*/
        StudentService service = new StudentServiceImpl(repository);
        service.findAll().forEach(System.out::println);
    }
}
