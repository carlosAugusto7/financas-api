package com.financas.sistema.config;

import com.financas.sistema.domain.enums.PerfilUsuario;
import com.financas.sistema.domain.model.Usuario;
import com.financas.sistema.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;

    public DataLoader(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (usuarioRepository.count() == 0) {
            Usuario carlos = new Usuario(null, "carlos@email.com", "Carlos", "123456", PerfilUsuario.ADMIN);
            Usuario namorada = new Usuario(null, "namorada@email.com", "Namorada", "123456", PerfilUsuario.USER);
            
            usuarioRepository.save(carlos);
            usuarioRepository.save(namorada);
            
            System.out.println("✅ Usuários carregados com sucesso!");
        }
    }
}