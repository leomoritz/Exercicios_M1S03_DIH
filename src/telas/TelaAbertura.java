package telas;

public class TelaAbertura extends Tela {

    @Override
    public void apresentaTelaAbertura() {

        System.out.println("#############################################################################################################");

        System.out.println("----------------------------------------------- DEVINFLIX ---------------------------------------------------");

        System.out.println("#############################################################################################################");

        System.out.println("\n");
    }

    public void apresentaMenuTela() {
        System.out.println("1 - Cadastrar Conta" + "\n" + "2 - Acessar Conta" + "\n" + "3 - Administrador" + "\n" + "0 - Sair" + "\n");

        System.out.print("Digite a opção acima desejada -> ");
    }

}
