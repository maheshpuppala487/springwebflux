package com.example.springfluxcassandra;

import com.example.springfluxcassandra.model.Student;
import com.example.springfluxcassandra.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringfluxcassandraApplication {

    @Bean
    public CommandLineRunner loadData(StudentRepository studentRepository) {
        Set<String> hobbies = new HashSet<>();
        hobbies.add("playing chess");
        Map<String, String> map = new HashMap<>();
        map.put("home", "US");
        return args -> {
            studentRepository.deleteAll()
                    .subscribe(null, null, () -> {
                        Stream.of(new Student(12351, "Sathwik", Arrays.asList("sathwik@gmail.com"), hobbies, map),
                                new Student(12352, "Hansith", Arrays.asList("hansith@gmail.com"), hobbies, map))
                                .forEach(student -> {
                                    studentRepository
                                            .save(student)
                                            .subscribe(System.out::println);
                                });
                    });


        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringfluxcassandraApplication.class, args);
    }

}
