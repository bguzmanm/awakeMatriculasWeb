package cl.awakelab.matricula.model.persistence.crud;

import cl.awakelab.matricula.model.persistence.entity.RolEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RolCrud extends CrudRepository<RolEntity, Integer> {
    Optional<RolEntity> findByRolName(String rolName);
}
