package servico;

import java.rmi.Naming;

public class Server {

    public static void main(String args[]) {
        System.setProperty("java.security.policy", "file:///C:/tmp/fabio.policy");

        try {
            // System.setSecurityManager(new RMISecurityManager()); // Não é mais necessário

            ImplServer obj = new ImplServer();
            Naming.rebind("OppMathServer", obj);

            System.out.println("Servidor de Operações Matemáticas registrado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
