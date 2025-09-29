package aplicacao;

import arvores.AVLint;

import java.util.Scanner;

public class MenuAvl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AVLint avl = new AVLint();
        int opcao;
        do {
            System.out.println("0 - Sair");
            System.out.println("1 - Inserir");
            System.out.println("2 - Mostra FB de cada nó");
            opcao = sc.nextInt();
            switch (opcao) {
                case 0:
                    System.out.println("Encerrado");
                break;
                case 1:
                    System.out.println("Informe o valor a ser inserido");
                    int valor = sc.nextInt();
                    avl.root = avl.inserirAVL(avl.root, valor);
                    avl.atualizaAlturas(avl.root);
                break;
                case 2:
                    System.out.println("Apresentação da AVL");
                    avl.mostraFB(avl.root);
                break;
                default:
                    System.out.println("Opção Invalida");
            }

        } while(opcao != 0 );

        sc.close();
    }
}
