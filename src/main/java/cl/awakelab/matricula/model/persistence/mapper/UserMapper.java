package cl.awakelab.matricula.model.persistence.mapper;

import cl.awakelab.matricula.model.domain.dto.UserDTO;
import cl.awakelab.matricula.model.persistence.entity.UsuarioEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RolMapper.class})
public interface UserMapper {

    @Mappings({
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "enable", target = "enabled"),
            @Mapping(source = "roles", target = "rols"),
    })
    UserDTO toUser(UsuarioEntity user);
    List<UserDTO> toUsers(List<UsuarioEntity> users);
    @InheritInverseConfiguration
    UsuarioEntity toUsuario(UserDTO user);
}
