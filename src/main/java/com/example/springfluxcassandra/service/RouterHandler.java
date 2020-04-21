package com.example.springfluxcassandra.service;

import com.example.springfluxcassandra.model.Student;
import com.example.springfluxcassandra.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class RouterHandler {

    @Autowired
    private StudentRepository studentRepository;

    public Mono<ServerResponse> getAll(ServerRequest serverRequest){
        return ServerResponse.ok().body(studentRepository.findAll(), Student.class);
    }


    public Mono<ServerResponse> getById(ServerRequest serverRequest) {
        int id=Integer.parseInt(serverRequest.pathVariable("id"));
        return ServerResponse.ok().body(studentRepository.findById(id),Student.class);
    }

    public Mono<ServerResponse> getAfterId(ServerRequest serverRequest) {
        int id=Integer.parseInt(serverRequest.pathVariable("id"));
        return ServerResponse.ok().body(studentRepository.findStudentBySidAfter(id),Student.class);
    }
}
