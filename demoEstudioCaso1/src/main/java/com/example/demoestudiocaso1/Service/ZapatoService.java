package com.example.demoestudiocaso1.Service;

import com.example.demoestudiocaso1.Model.Zapato;
import com.example.demoestudiocaso1.Repository.ZapatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZapatoService {

    @Autowired
    private ZapatoRepository zapatoRepository;

    public void agregarZapato(Zapato zapato) {
        zapatoRepository.save(zapato);
    }

    public List<Zapato> obtenerZapatos() {
        return zapatoRepository.findAll();
    }

    public Zapato obtenerZapatoPorId(int id) {
        return zapatoRepository.findById(id).orElse(null);
    }

    public void actualizarZapato(Zapato zapato) {
        zapatoRepository.save(zapato);
    }

    public void eliminarZapato(int id) {
        zapatoRepository.deleteById(id);
    }
}