package cliente;

import java.rmi.Naming;
import servico.Operacao;

public class Client {
    public static void main(String args[]) {
        try {
            // Define a política de segurança (descomente esta linha se necessário)
            // System.setProperty("java.security.policy", "file:///C:/Users/botel/eclipse-workspace/unievaRMI/fabio.policy");

            // Localiza o objeto de operações matemáticas
            Operacao Opp = (Operacao) Naming.lookup("OppMathServer");
            System.out.println("Objeto Operações matemáticas localizado.");

            // Lê os argumentos passados via linha de comando
            int tipoopp = Integer.parseInt(args[0]);
            int a = Integer.parseInt(args[1]);
            int b = Integer.parseInt(args[2]);
            int resultado = 0;

            // Executa a operação desejada
            if (tipoopp == 1) {
                resultado = Opp.Soma(a, b);
            } else if (tipoopp == 2) {
                resultado = Opp.Produto(a, b);
            } else {
                System.out.println("Operação não reconhecida.");
                System.exit(1); // Saída com código de erro
            }

            // Exibe o resultado
            System.out.println("Resultado = " + resultado);

        } catch (NumberFormatException e) {
            System.err.println("Erro de formato numérico: Certifique-se de que os argumentos fornecidos são números inteiros.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Erro de entrada: Certifique-se de fornecer todos os argumentos necessários.");
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
