package will.designpatterns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import will.designpatterns.model.Automovel;
import will.designpatterns.model.Fabricante;
import will.designpatterns.repository.AutomovelRepository;
import will.designpatterns.repository.FabricanteRepository;

import java.util.Optional;

@RestController
@RequestMapping("/automovel")
public class AutomovelController {
    @Autowired
    private AutomovelRepository autoRepository;
    @Autowired
    private FabricanteRepository fabricanteRepository;
    @GetMapping
    public Iterable<Automovel> retornaAutomoveis() {
        return autoRepository.findAll();
    }

    @PostMapping
    public Automovel salvaAutomovel(@RequestBody Automovel automovel) {
        Optional<Fabricante> fabricante = fabricanteRepository.findById(1L);
        fabricante.ifPresent(automovel::setFabricante);
        return autoRepository.save(automovel);
    }
}
