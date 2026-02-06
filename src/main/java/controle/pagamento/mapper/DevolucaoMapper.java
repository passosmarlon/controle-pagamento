package controle.pagamento.mapper;

import controle.pagamento.dto.DevolucaoDTO;
import controle.pagamento.entity.Devolucao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {FaturaMapper.class})
public interface DevolucaoMapper {

    @Mapping(source = "fatura.id", target = "faturaId")
    DevolucaoDTO toDto(Devolucao entity);

    Devolucao toEntity(DevolucaoDTO dto);
}
