package br.com.zup.Contato.contatos.dtos;

import br.com.zup.Contato.produto.dtos.ProdutoDTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class ContatoDTO {

    @Email
    private String email;
    @Size (min = 2 , max = 30, message = "O nome deve ter entre 2 e 30 caracteres")
    @NotBlank
    private String nome;
    @NotNull
    private String telefone;
    private List <ProdutoDTO> produtos;

    public ContatoDTO() {
    }

    public ContatoDTO(String email, String nome, String telefone, List<ProdutoDTO> produtos) {
        this.email = email;
        this.nome = nome;
        this.telefone = telefone;
        this.produtos = produtos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<ProdutoDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoDTO> produtos) {
        this.produtos = produtos;
    }

}
