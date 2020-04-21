package com.example.springfluxcassandra.repository;

import com.example.springfluxcassandra.model.Student;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
@Repository
public interface StudentRepository extends ReactiveCassandraRepository<Student,Integer> {
    @AllowFiltering
    Flux<Student> findStudentBySidAfter(int sid);
}
