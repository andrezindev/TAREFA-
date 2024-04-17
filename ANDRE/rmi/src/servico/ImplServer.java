package servico;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ImplServer extends UnicastRemoteObject implements Operacao {

    public ImplServer() throws RemoteException {
        super();
    }

    @Override
    public int Soma(int VarA, int VarB) {
        int soma = VarA + VarB;
        System.out.println("Operação de soma realizada no servidor.");
        return soma;
    }

    @Override
    public int Produto(int VarA, int VarB) {
        int produto = VarA * VarB;
        System.out.println("Operação de produto realizada no servidor.");
        return produto;
    }
}
