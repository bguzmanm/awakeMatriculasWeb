package cl.awakelab.matricula.model.persistence.mapper;

import cl.awakelab.matricula.model.domain.dto.RolDTO;
import cl.awakelab.matricula.model.persistence.entity.RolEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RolMapper {

    @Mappings({
            @Mapping(source = "rolId", target = "rolId"),
            @Mapping(source = "rolName", target = "rolName"),
    })
    RolDTO toRol(RolEntity rol);
    List<RolDTO> toRols(List<RolEntity> rol);

    @InheritInverseConfiguration
    RolEntity toRolEntity(RolDTO rol);
}
