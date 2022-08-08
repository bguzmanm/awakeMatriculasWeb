package cl.awakelab.matricula.model.persistence.repository;

import cl.awakelab.matricula.model.domain.dto.RolDTO;
import cl.awakelab.matricula.model.domain.repository.RolDTORepository;
import cl.awakelab.matricula.model.persistence.crud.RolCrud;
import cl.awakelab.matricula.model.persistence.entity.RolEntity;
import cl.awakelab.matricula.model.persistence.mapper.RolMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RolRepository implements RolDTORepository {

    private final RolCrud crud;
    private final RolMapper mapper;

    public RolRepository(RolCrud crud, RolMapper mapper) {
        this.crud = crud;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<RolDTO>> findAll() {
        return Optional.of(mapper.toRols((List<RolEntity>) crud.findAll()));
    }

    @Override
    public Optional<RolDTO> findById(int rolId) {
        return crud.findById(rolId)
                .map(mapper::toRol);
    }

    @Override
    public Optional<RolDTO> findByRolName(String rolName) {
        return crud.findByRolName(rolName)
                .map(mapper::toRol);
    }

    @Override
    public RolDTO save(RolDTO rol) {
        return mapper.toRol(crud.save(mapper.toRolEntity(rol)));
    }

    @Override
    public void delete(int rolId) {
        crud.deleteById(rolId);
    }
}
