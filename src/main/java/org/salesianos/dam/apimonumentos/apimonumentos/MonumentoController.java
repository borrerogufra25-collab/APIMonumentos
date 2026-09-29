package org.salesianos.dam.apimonumentos.apimonumentos;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/monumento")
public class MonumentoController {

    private final MonumentoRepository monumentoRepository;

    @GetMapping
    public ResponseEntity<List<Monumento>> traerTodosMonumentos() {
        List<Monumento> listaMonumentos = monumentoRepository.findAll();
        if (listaMonumentos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listaMonumentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Monumento> findByIdMonumento(@PathVariable Long id) {
        return ResponseEntity.of(monumentoRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity<Monumento> agregarMonumento(@RequestBody Monumento monumento) {
        if (StringUtils.hasText(monumento.getNomMonumento())) {
            return ResponseEntity.status(201).body(monumentoRepository.save(monumento));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Monumento> actualizarMonumento(
        @PathVariable Long id, @RequestBody Monumento monumento) {

        if (!StringUtils.hasText(monumento.getNomMonumento())) {
            return ResponseEntity.badRequest().build();
        }

        return monumentoRepository.findById(id).map(m -> {
            m.setCodPais(monumento.getCodPais());
            m.setPais(monumento.getPais());
            m.setCiudad(monumento.getCiudad());
            m.setLatitud(monumento.getLatitud());
            m.setLongitud(monumento.getLongitud());
            m.setNomMonumento(monumento.getNomMonumento());
            m.setDescripcion(monumento.getDescripcion());
            m.setImagen(monumento.getImagen());
            return ResponseEntity.ok(monumentoRepository.save(m));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarMonumento(@PathVariable Long id) {
        monumentoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
