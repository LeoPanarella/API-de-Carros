package domain.dto;


import domain.Carros;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class CarrosDTO {
    private Long id;
    private String nome;
    private String tipo;


    public static CarrosDTO create(Carros carro) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(carro, CarrosDTO.class);
    }
}

