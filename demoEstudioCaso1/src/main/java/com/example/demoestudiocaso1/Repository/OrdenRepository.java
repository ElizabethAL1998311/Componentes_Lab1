package com.example.demoestudiocaso1.Repository;

import com.example.demoestudiocaso1.Model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Integer> {
}