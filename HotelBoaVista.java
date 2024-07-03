package hotel;

import java.util.Scanner;

public class HotelBoaVista {

    private static final int maximo_hospedes = 10;
    private static String[] nomes = new String[maximo_hospedes];
    private static String[] cpfs = new String[maximo_hospedes];
    private static int[] dias = new int[maximo_hospedes];
    private static double [] despesas = new double[maximo_hospedes];
    private static int indiceHospedes = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        mostrarMenu(sc);
        sc.close();
    }

    private static void mostrarMenu(Scanner sc){
        while(true){
            System.out.println("\nMenu:");
            System.out.println("1 - Cadastrar Hóspede");
            System.out.println("2 - Exibir Hóspede Cadastrados");
            System.out.println("3 - Resercar Área de lazer");
            System.out.println("4 - Calcular total a Pagar");
            System.out.println("0 - sair");
            System.out.println("Digite sua escolha;");
            int opcao = sc.nextInt();
            sc.nextLine();

            switch(opcao){
                case 1:
                    cadastrarHospede(sc);
                    break;
                case 2: 
                    exibirHospedes();
                    break;
                case 3:
                    reservarAreaLazer(sc);
                    break;
                case 4:
                    calcularTotalAPagar(sc);
                    break;
                case 0:
                System.out.println("Obridado por usar o sistema. até logo!");
                return;
            default:
            System.out.println("Opção invalida. Por favor, tente novamente.");
            }
        }
    }

    private static void cadastrarHospede(Scanner sc){
        if(indiceHospedes >= maximo_hospedes){
            System.out.println("Maxino de cadastro atingido.");
            return;
        }

        System.out.print("\nDigite o nome do hóspede: ");
        nomes[indiceHospedes]  = sc.nextLine();
        System.out.print("Digite o CPF do hóspede: ");
        cpfs[indiceHospedes] = sc.nextLine();
        System.out.print("Digite a quantidade de dias que ficara hospedado: ");
        dias[indiceHospedes] = sc.nextInt();
        sc.nextLine();
        despesas[indiceHospedes] = 0;
        indiceHospedes++;
        System.out.println("Hóspede cadastrado com sucesso.");

    }

    private static void exibirHospedes(){
        if(indiceHospedes == 0){
            System.out.println("Nenhum hóspede cadastrado.");
            return;
        }

        for(int i = 0; i < indiceHospedes; i++){
            System.out.println("\nIndice: " + i);
            System.out.println("Nome: " + nomes[i]);
            System.out.println("CPF: " + cpfs[i]);
            System.out.println("Dias: " + dias[i]);
            System.out.println("despesas: R$ " + despesas[i]);
            System.out.println();
        }
    }

    private static void reservarAreaLazer(Scanner sc){
        exibirHospedes();
        System.out.println("\nDigite o índice do hóspede:");
        int indice = sc.nextInt();
        sc.nextLine();

        if(indice < 0 || indice >= indiceHospedes){
            System.out.println("Indice inválido.");
            return;
        }
        System.out.println("Escolher a área de lazer: ");
        System.out.println("(A) Academia = R$ 20");
        System.out.println("(S) salão de Festas - R$ 50");
        System.out.println("(R) Restaurante - R$ 35");
        System.out.println("Digite a opção desejada: ");
        char opcao = sc.next().toUpperCase().charAt(0);
        sc.nextLine();

        switch (opcao) {
            case 'A':
                despesas[indice] += 20;
                break;
            case 'S':
                despesas[indice] += 50;
                break;
            case 'R':
                despesas[indice] += 35;
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }
        System.out.println("Área de lazer reservada com sucesso.");
    }

    private static double calcularTotal(int indice){
        return(dias[indice] * 100) + despesas[indice];
    }

    private static void calcularTotalAPagar(Scanner sc){
        exibirHospedes();
        System.out.println("Digite o indice do hóspede: ");
        int indice = sc.nextInt();
        sc.nextLine();

        if(indice < 0 || indice >= indiceHospedes){
            System.out.println("Indice inválido.");
            return;
        }
        double total = calcularTotal(indice);
        System.out.println("O total a pagar do hóspede " + nomes[indice] + " é R$ " + total);
    }
}
