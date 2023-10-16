public class Produtos {
    protected String nomeProduto;
    protected int codigoProduto;
    protected double valorUnitario;
    protected int quantidadeProduto;

    public Produtos(String nomeProduto, int codigoProduto, double valorUnitario, int quantidadeProduto) {
        this.nomeProduto = nomeProduto;
        this.codigoProduto = codigoProduto;
        this.valorUnitario = valorUnitario;
        this.quantidadeProduto = quantidadeProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public double valorTotalProduto(){
        return getValorUnitario() * getQuantidadeProduto();
    }

    @Override
    public String toString() {
        return "\n______________________________________\n"+
                "Produto -> " + nomeProduto                +
                "\nCodigo -> " + codigoProduto             +
                "\nValor Unitario -> R$" + valorUnitario   +
                "\nQuantidade -> " + quantidadeProduto     +
                "\n____________________________________\n";
    }


}
