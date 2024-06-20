package com.example.demoestudiocaso1.Repository;

import com.example.demoestudiocaso1.Model.Zapato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZapatoRepository extends JpaRepository<Zapato, Integer> {
}