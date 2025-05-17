package domain;

import domain.dto.CarrosDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarrosService {

    private final CarrosRepository rep;

    @Autowired
    public CarrosService(CarrosRepository rep) {
        this.rep = rep;
    }

    public List<CarrosDTO> getCarros(){
       return rep.findAll().stream().map(CarrosDTO::create).collect(Collectors.toList());
    }

    public Optional<CarrosDTO> getCarrosById(Long id) {
        return rep.findById(id).map(CarrosDTO::create);
    }

    public List<CarrosDTO> getCarrosByTipo(String tipo) {
        return rep.findByTipo(tipo).stream().map(CarrosDTO::create).collect(Collectors.toList());
    }
    public Carros save(Carros carro) {
        return rep.save(carro);
    }

    public CarrosDTO insert(Carros carro) {
        Assert.notNull(carro.getId(), "Não foi possivel inserir o registro");
        return CarrosDTO.create(rep.save(carro));
    }

    public CarrosDTO update(Carros carro, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        Optional<Carros> optional = rep.findById(id);
        if(optional.isPresent()) {
            Carros db = optional.get();
            db.setNome(carro.getNome());
            db.setTipo(carro.getTipo());
            System.out.println("Carro id " + db.getId());

            rep.save(db);

            return CarrosDTO.create(db);

        } else {
            return null;
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }
}