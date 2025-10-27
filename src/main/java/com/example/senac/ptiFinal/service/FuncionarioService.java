
package com.example.senac.ptifinal.service;

import com.example.senac.ptifinal.model.Funcionario;
import com.example.senac.ptifinal.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FuncionarioService {
    
    private final FuncionarioRepository repository;
    
    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }
    
    public List<Funcionario> listarTodos() {
        return repository.findAll();
    }
    
    public Funcionario salvar(Funcionario funcionario) {
        return repository.save(funcionario);
    }
    
    public void excluir(Long id) {
        repository.deleteById(id);
    }
    
    public Funcionario buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
    }

    public Funcionario atualizar(Long id, Funcionario dadosAtualizados) {
        Funcionario funcionarioExistente = buscarPorId(id);
        funcionarioExistente.setNome(dadosAtualizados.getNome());
        funcionarioExistente.setCargo(dadosAtualizados.getCargo());
        funcionarioExistente.setCpf(dadosAtualizados.getCpf());
        return repository.save(funcionarioExistente);
    }  

}
