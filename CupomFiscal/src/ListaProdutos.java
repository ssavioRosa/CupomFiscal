import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ListaProdutos {
    List<Produtos> produtosLista = new ArrayList<>();

    public  void adicionaLista(String nomeProduto, int codigoProduto, int quantidadeProduto, double valorProduto){

        Produtos produtos = new Produtos(nomeProduto, codigoProduto, valorProduto, quantidadeProduto);
        produtosLista.add(produtos);

    }

    public double valorTotalCompra(){
        double valorCompra = 0.0;
        for (Produtos produtos : produtosLista
             ) {
            valorCompra += produtos.getValorUnitario() * produtos.getQuantidadeProduto();
        }
        return valorCompra;
    }

    public String TrocoItem(double valorRecebido){
        double trocoItem = valorTotalCompra() - valorRecebido;
        double moduloTrocoItem = Math.abs(trocoItem);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");


        String trocoFormatado = decimalFormat.format(moduloTrocoItem);

        return trocoFormatado;

    }

    public void removeProduto(int codigoProduto){
        for (int i = 0; i < produtosLista.size(); i++){
            if (produtosLista.get(i).codigoProduto == codigoProduto){
                produtosLista.remove(i);
            }
        }
    }

    public void printaProdutos(){
        for (Produtos produtos : produtosLista) {
            System.out.println(produtos.toString());
        }
    }
    public void printaDadosCompra(){
        int cont = 1;
        for (int i = 0; i < produtosLista.size(); i++) {
            System.out.println(cont + "\t\t" + produtosLista.get(i).codigoProduto + "\t\t\t" + produtosLista.get(i).nomeProduto);
            System.out.println("\t\t" + produtosLista.get(i).quantidadeProduto + "x" + produtosLista.get(i).valorUnitario + "\t\t\t" + produtosLista.get(i).valorTotalProduto());
            cont++;
        }


    }
}
