package controle.pagamento.mapper;

import controle.pagamento.dto.ClienteDTO;
import controle.pagamento.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ClienteUpdate {

    void updateCliente(ClienteDTO dto, @MappingTarget Cliente entity);
}
