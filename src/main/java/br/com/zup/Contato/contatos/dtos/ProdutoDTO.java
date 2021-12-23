package br.com.zup.Contato.contatos.dtos;

public class ProdutoDTO {

    private String nomeDoProduto;
    private double valorDoProduto;

    public ProdutoDTO() {
    }

    public ProdutoDTO(String nomeDoProduto, double valorDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
        this.valorDoProduto = valorDoProduto;
    }

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }

    public double getValorDoProduto() {
        return valorDoProduto;
    }

    public void setValorDoProduto(double valorDoProduto) {
        this.valorDoProduto = valorDoProduto;
    }
}
