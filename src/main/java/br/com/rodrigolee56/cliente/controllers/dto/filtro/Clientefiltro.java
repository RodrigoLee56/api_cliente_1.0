package br.com.rodrigolee56.cliente.controllers.dto.filtro;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Clientefiltro {

    private Long id;
    private String nome;
    private String email;
    private String cpf;

}
