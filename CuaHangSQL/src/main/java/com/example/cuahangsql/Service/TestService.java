package com.example.cuahangsql.Service;

import com.example.cuahangsql.Model.Test;
import com.example.cuahangsql.Repository.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestRepo testRepo;

    public List<Test> test() {
        return testRepo.findAll();
    }
}
