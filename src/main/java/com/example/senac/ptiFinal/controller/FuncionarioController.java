
package com.example.senac.ptifinal.controller;

import com.example.senac.ptifinal.model.Funcionario;
import com.example.senac.ptifinal.service.FuncionarioService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/funcionarios")
@CrossOrigin(origins = "*")
public class FuncionarioController {
    
    private final FuncionarioService service;
    
    public FuncionarioController(FuncionarioService service) {
        this.service = service;
    }
    
    @GetMapping
    public List<Funcionario> listar(){
        return service.listarTodos();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarPorId(@PathVariable Long id) {
        Funcionario funcionario = service.buscarPorId(id);
        if (funcionario != null) {
            return ResponseEntity.ok(funcionario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    public Funcionario salvar(@RequestBody Funcionario funcionario) {
        return service.salvar(funcionario);
    }
    
    @PutMapping("/{id}")
    public Funcionario atualizar(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        return service.atualizar(id, funcionario);
    }
    
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
