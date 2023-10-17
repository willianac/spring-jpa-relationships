package will.designpatterns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        Optional<Fabricante> fabricante = fabricanteRepository.findById(automovel.getFabricante_id());
        fabricante.ifPresent(automovel::setFabricante);
        return autoRepository.save(automovel);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluiAutomovel(@PathVariable Long id) {
        Optional<Automovel> automovelParaSerExcluido = autoRepository.findById(id);

        if(automovelParaSerExcluido.isPresent()) {
            autoRepository.delete(automovelParaSerExcluido.get());
            return new ResponseEntity<>("Sucesso", HttpStatus.OK);
        }
        return new ResponseEntity<>("Não foi possível realizar a operação.", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizaAutomovel(@PathVariable Long id, @RequestBody Automovel automovelAtualizado) {
        Optional<Automovel> automovel = autoRepository.findById(id);
        if(automovel.isPresent()) {
            automovel.get().setModelo(automovelAtualizado.getModelo());
            automovel.get().setAno(automovelAtualizado.getAno());
            automovel.get().setVersao(automovelAtualizado.getVersao());
            automovel.get().setValor(automovelAtualizado.getValor());
            automovel.get().setNovoDeFabrica(automovelAtualizado.isNovoDeFabrica());
            autoRepository.save(automovel.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
