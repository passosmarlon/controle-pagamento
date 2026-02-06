package controle.pagamento.mapper;

import controle.pagamento.dto.ClienteDTO;
import controle.pagamento.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mapping(target = "active", ignore = true)
    Cliente toEntity(ClienteDTO dto);

    ClienteDTO toDto(Cliente entity);
}
