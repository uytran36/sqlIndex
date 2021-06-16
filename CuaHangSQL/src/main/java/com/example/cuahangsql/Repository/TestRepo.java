package com.example.cuahangsql.Repository;

import com.example.cuahangsql.Model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepo extends JpaRepository<Test, String> {
}
