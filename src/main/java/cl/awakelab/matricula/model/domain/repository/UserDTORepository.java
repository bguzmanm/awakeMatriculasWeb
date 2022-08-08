package cl.awakelab.matricula.model.domain.repository;

import cl.awakelab.matricula.model.domain.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserDTORepository {
    Optional<List<UserDTO>> findAll();
    Optional<UserDTO> findById(String username);
    UserDTO save(UserDTO user);
    void delete(String username);
    boolean existsByUsername(String username);
}
