import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean loop1 = true;
        boolean loop2 = true;
        ListaProdutos listaProdutos = new ListaProdutos();
        System.out.println("***Produtos Comprados***");

        while (loop1) {
            System.out.println("Digite o nome do produto -> ");
            String nomeProduto = scan.nextLine();
            System.out.println("Digite o código do produto -> ");
            int codigoProduto = 0;
            try {
                codigoProduto = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Digite um código de produto válido [um numero inteiro] !");
                scan.nextLine();
                continue;
            }
            double valorUnitario = 0;
            boolean loopDouble = true;
            while (loopDouble) {
                System.out.println("Digite o valor unitário do produto -> ");
                try {
                    valorUnitario = scan.nextDouble();
                    scan.nextLine();
                    loopDouble = false;
                } catch (InputMismatchException e) {
                    System.out.println("Digite o valor unitário separando a casa decimal com vigula !");
                    scan.nextLine();
                }
            }
            System.out.println("Digite a quantidade do produto comprada -> ");
            int quantidadePoduto;
            try {
                quantidadePoduto = scan.nextInt();
                scan.nextLine();
            }catch (InputMismatchException e){
                System.out.println("Digite a quantidade do produto válida [Um numero inteiro] !");
                scan.nextLine();
                continue;
            }

            System.out.println("Deseja adicionar outro produto? (Digite 'sim' ou 'nao')");
            String resposta = scan.nextLine().toLowerCase();
            if (resposta.equals("nao")) {
                loop1 = false;
            }
            listaProdutos.adicionaLista(nomeProduto, codigoProduto, quantidadePoduto, valorUnitario);
        }
        do {
            System.out.println("\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            System.out.println("***Produtos no carrinho***");
            listaProdutos.printaProdutos();
            System.out.println("Valor compra -> R$" + listaProdutos.valorTotalCompra());
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

            System.out.println("Deseja remover algum produto? (Digite 'sim' ou 'nao')");
            String resposta = scan.nextLine().toLowerCase();
            if (resposta.equals("sim")) {
                System.out.println("Digite o código do produto que deseja remover -> ");
                int codigoRemover = scan.nextInt();
                listaProdutos.removeProduto(codigoRemover);
                scan.nextLine();
            } else if (resposta.equals("nao")) {
                loop2 = false;
            }
        } while (loop2);


        System.out.println("\n\n***Pagamento***");
        System.out.println("Digite o CPF do consumidor -> ");
        String cpfConsumidor = scan.nextLine();
        double valorDadoCliente = 0.0;
        boolean loopDouble2 = true;

        while (loopDouble2) {
            System.out.println("Digite o valor dado pelo cliente -> ");
            try {
                valorDadoCliente = scan.nextDouble();
                scan.nextLine();
                if (valorDadoCliente < listaProdutos.valorTotalCompra()) {
                    System.out.println("Valor insuficiente, digite novamente !\n");
                } else {
                    loopDouble2 = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite o valor separando a casa decimal com vírgula !");
                scan.nextLine();
            }
        }
        CupomFiscal cupomFiscal = new CupomFiscal(listaProdutos.valorTotalCompra(), cpfConsumidor, valorDadoCliente, listaProdutos.TrocoItem(valorDadoCliente));


        cupomFiscal.imprimeNotaFiscal1();
        listaProdutos.printaDadosCompra();
        cupomFiscal.imprimeNotafiscanl2();



        scan.close();
    }
}
