package will.designpatterns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import will.designpatterns.model.Fabricante;
import will.designpatterns.repository.FabricanteRepository;

import java.util.Optional;


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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluiFabricante(@PathVariable Long id) {
        if (fabricanteRepository.existsById(id)) {
            fabricanteRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizaFabricante(@PathVariable Long id, @RequestBody Fabricante fabricanteAtualizado) {
        Optional<Fabricante> fabricante = fabricanteRepository.findById(id);
        if(fabricante.isPresent()) {
            fabricante.get().setNome(fabricanteAtualizado.getNome());
            fabricante.get().setOrigem(fabricanteAtualizado.getOrigem());
            fabricante.get().setAnoFundacao(fabricanteAtualizado.getAnoFundacao());
            fabricanteRepository.save(fabricante.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
