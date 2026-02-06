package controle.pagamento.service;

import controle.pagamento.dto.ClienteDTO;
import controle.pagamento.entity.Cliente;
import controle.pagamento.mapper.ClienteMapper;
import controle.pagamento.mapper.ClienteUpdate;
import controle.pagamento.repositories.ClienteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;
    private final ClienteMapper mapper;
    private final ClienteUpdate mapperUpdate;

    public Cliente saveCliente(ClienteDTO data) {
        var get = mapper.toEntity(data);
        return repository.save(get);
    }

    public List<ClienteDTO> getCliente(){
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Transactional
    public Cliente updateCliente(ClienteDTO data) {
        Cliente cliente = repository.findById(data.id())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        mapperUpdate.updateCliente(data, cliente);
        return repository.save(cliente);
    }

    @Transactional
    public Cliente desativarCliente(ClienteDTO data) {
        Cliente cliente = repository.findById(data.id())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        mapperUpdate.updateCliente(data, cliente);
        cliente.setActive(false);
        return repository.save(cliente);

    }

    public List<ClienteDTO> getActive() {
        return repository.findByActiveTrue()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public List<ClienteDTO> getName(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome)
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
