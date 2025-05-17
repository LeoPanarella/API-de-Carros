package api;

import domain.Carros;
import domain.CarrosService;
import domain.dto.CarrosDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/carros")
public class CarrosController {

    @Autowired
    private CarrosService service;

    @GetMapping
    public ResponseEntity<List<CarrosDTO>> get() {
        return new ResponseEntity<>(service.getCarros(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id){
        Optional<CarrosDTO> carro = service.getCarrosById(id);

                return carro
                        .map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("tipo/{tipo}")
    public ResponseEntity getCarrosbytipo(@PathVariable("tipo")String tipo){
        List<CarrosDTO> carros = service.getCarrosByTipo(tipo);

        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }
    @PostMapping
    public ResponseEntity post(@RequestBody Carros carro) {
            try {
                CarrosDTO c = service.insert(carro);

                URI location = getUri(c.getId());
                return ResponseEntity.created(location).build();
            } catch (Exception e) {
                return ResponseEntity.badRequest().build();
            }
        }

        private URI getUri(Long id) {
            return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")

    public ResponseEntity post(@PathVariable("id")Long id,@RequestBody Carros carros){
        carros.setId(id);
        CarrosDTO c = service.update(carros,id);

        return c != null ?
                ResponseEntity.ok(c) :
                ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id")Long id){
        service.delete(id);

        return ResponseEntity.ok().build();
    }
}