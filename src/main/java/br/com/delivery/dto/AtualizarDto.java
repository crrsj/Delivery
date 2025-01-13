package br.com.delivery.dto;

import java.util.Date;

import br.com.delivery.entidade.Cliente;
import br.com.delivery.enums.Tipo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AtualizarDto {
	private Long id;
	private String nome;
	private String fone;
	private String email;	
	private Tipo tipo;	
	private Date dataCriacao;	
	private Date dataAtualizacao;
	
	public AtualizarDto(Cliente atualizar) {
		
		this.id = atualizar.getId();
		this.nome = atualizar.getNome();
		this.fone = atualizar.getFone();
		this.email = atualizar.getEmail();		
		this.tipo  = atualizar.getTipo();
		this.dataCriacao = atualizar.getDataCriacao();
		this.dataAtualizacao = atualizar.getDataAtualizacao();
		
   }
}