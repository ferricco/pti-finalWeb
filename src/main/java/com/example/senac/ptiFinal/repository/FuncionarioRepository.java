
package com.example.senac.ptifinal.repository;

import com.example.senac.ptifinal.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    
}
