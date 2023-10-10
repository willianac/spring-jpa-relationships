package will.designpatterns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import will.designpatterns.model.Fabricante;
import will.designpatterns.repository.FabricanteRepository;


@RestController
@RequestMapping("/fabricante")
public class FabricanteController {
    @Autowired
    private FabricanteRepository fabricanteRepository;
    @GetMapping
    public Iterable<Fabricante> retornaFabricantes() {
        return fabricanteRepository.findAll();
    }

    @PostMapping
    public Fabricante salvaFabricante(@RequestBody Fabricante fabricante) {
        return fabricanteRepository.save(fabricante);
    }
}
