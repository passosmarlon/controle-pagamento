package controle.pagamento.mapper;

import controle.pagamento.dto.FaturaDTO;
import controle.pagamento.entity.Fatura;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface FaturaUpdate {

    void updateFatura(FaturaDTO dto, @MappingTarget Fatura entity);
}
