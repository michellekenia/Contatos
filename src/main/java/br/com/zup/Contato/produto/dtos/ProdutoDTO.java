package br.com.zup.Contato.produto;

public class ProdutoDTO {

    private String nomeDoProduto;
    private double valorDoProduto;
    private int id;

    public ProdutoDTO() {
    }

    public ProdutoDTO(String nomeDoProduto, double valorDoProduto, int id) {
        this.nomeDoProduto = nomeDoProduto;
        this.valorDoProduto = valorDoProduto;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
