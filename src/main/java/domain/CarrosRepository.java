package domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CarrosRepository extends JpaRepository<Carros, Long> {
    List<Carros> findByTipo(String tipo);
}
