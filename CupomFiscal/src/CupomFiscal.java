import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CupomFiscal {
    protected String nomeLoja;
    protected String cnpjLoja;
    protected String cpfConsumidor;
    protected double dinheiroRecebido;
    protected String trocoCliente;
    protected double totalPago;





    public CupomFiscal(double totalPago, String cpfConsumidor, double dinheiroRecebido, String trocoCliente) {
        this.nomeLoja = "Casas Bahio";
        this.cnpjLoja = "11.222.333/0001-44";
        this.totalPago = totalPago;
        this.cpfConsumidor = cpfConsumidor;
        this.dinheiroRecebido = dinheiroRecebido;
        this.trocoCliente = trocoCliente;
    }

    public String dataEhora(){
        LocalDateTime dataHora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHoraFormatada = dataHora.format(formatter);

        return dataHoraFormatada;

    }
    public void imprimeNotaFiscal1() {
        int cont = 1;

        System.out.println("\t\t" + this.nomeLoja);
        System.out.println("CNPJ: " + this.cnpjLoja);
        System.out.println(dataEhora());
        System.out.println("--------------------------------------------");
        System.out.println("CPF consumidor: " + this.cpfConsumidor);
        System.out.println("--------------------------------------------");
        System.out.println("\t\tCUPOM FISCAL");
        System.out.println("ITEM" + "\tCÓDIGO" + "\tDESCRIÇÃO");
        System.out.println("____________________________________________");

    }
    public void imprimeNotafiscanl2(){
        System.out.println("____________________________________________");
        System.out.println("TOTAL R$: \t\t\t\t" + this.totalPago);
        System.out.println("VALOR RECEBIDO R$: \t\t\t" + this.dinheiroRecebido);
        System.out.println("TROCO R$: \t\t\t\t" + this.trocoCliente);
    }

}
