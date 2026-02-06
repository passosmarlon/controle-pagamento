package controle.pagamento.mapper;

import controle.pagamento.dto.PagamentoDTO;
import controle.pagamento.entity.Pagamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PagamentoMapper {

    @Mapping(source = "fatura.id", target = "faturaId")
    PagamentoDTO toDto(Pagamento entity);

    @Mapping(target = "fatura", ignore = true)
    Pagamento toEntity(PagamentoDTO dto);
}
