package controle.pagamento.mapper;

import controle.pagamento.dto.DevolucaoDTO;
import controle.pagamento.dto.FaturaDTO;
import controle.pagamento.entity.Fatura;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {PagamentoMapper.class})
public interface FaturaMapper {

    @Mapping(source = "cliente.id", target = "clienteId")
    @Mapping(source = "cliente.nome", target = "nomeCliente")
    @Mapping(source = "historicoPagamento", target = "pagamentos")
    FaturaDTO toDto(Fatura entity);

    Fatura toEntity(FaturaDTO dto);


}
