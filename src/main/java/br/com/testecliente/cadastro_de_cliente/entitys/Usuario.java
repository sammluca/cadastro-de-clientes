package br.com.testecliente.cadastro_de_cliente.entitys;

import jakarta.persistence.*;
import lombok.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "usuario")
public class Usuario {

@Id()
@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

@Column(name = "email", unique = true)
    private String email;

@Column(name = "nome")
    private String nome;

@Column(name = "Idade")
    private Integer idade;
}
