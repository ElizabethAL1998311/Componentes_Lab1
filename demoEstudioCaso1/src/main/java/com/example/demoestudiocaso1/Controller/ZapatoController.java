package com.example.demoestudiocaso1.Controller;

import com.example.demoestudiocaso1.Model.Zapato;
import com.example.demoestudiocaso1.Service.ZapatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zapatos")
public class ZapatoController {

    @Autowired
    private ZapatoService zapatoService;

    @PostMapping
    public void agregarZapato(@RequestBody Zapato zapato) {
        zapatoService.agregarZapato(zapato);
    }

    @GetMapping
    public List<Zapato> obtenerZapatos() {
        return zapatoService.obtenerZapatos();
    }

    @GetMapping("/{id}")
    public Zapato obtenerZapatoPorId(@PathVariable int id) {
        return zapatoService.obtenerZapatoPorId(id);
    }

    @PutMapping("/{id}")
    public void actualizarZapato(@PathVariable int id, @RequestBody Zapato zapato) {
        zapato.setId(id);
        zapatoService.actualizarZapato(zapato);
    }

    @DeleteMapping("/{id}")
    public void eliminarZapato(@PathVariable int id) {
        zapatoService.eliminarZapato(id);
    }
}