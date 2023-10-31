package uniderp.loo.escola.FakeDB;

import uniderp.loo.escola.models.Aluno;
import java.util.Scanner;
import java.util.ArrayList;

public class Turma {
    
    private Scanner sc;
    private ArrayList<Aluno> aluno;
    Aluno alunos = new Aluno();

    public Turma(){

        aluno = new ArrayList<Aluno>();
        sc = new Scanner(System.in);
    }

    public void funcao(){
        int op=0;
        do{
            menu();
            System.out.println("\nEscolha uma opção: ");
            op = this.sc.nextInt();
            switch (op) { 
                case 1: 
                    opcao01();
                    break; 

                case 2: 
                    opcao02();
                    break; 

                case 9: 
                    System.out.println("Encerrando Programa..."); 
                    break; 
                default: 
                    System.out.println("\n\nOpção Inválida!\nTente Novamente!");
                    break;
            }
        }while(op != 9);
    }
    
    private void menu(){
        System.out.println("=========================================");
        System.out.println("\n\nMENU DE OPÇÕES");
        System.out.println("\nOpção 1 - Gerenciar Aluno");
        System.out.println("Opção 2 - Rendimento Escolar");
        System.out.println("Opção 9 - Sair");
        System.out.println("=========================================");
    }

    private void opcao01(){
        int op=0;

        do{
            System.out.println("=========================================");
            System.out.println("\n\n01. GERENCIAR ALUNO:");
            System.out.println("\nOpção 1 - Adicionar Aluno");
            System.out.println("Opção 2 - Alterar nome do Aluno");
            System.out.println("Opção 3 - Excluir Aluno");
            System.out.println("Opção 4 - Listar todos");
            System.out.println("Opção 5 - Selecionar um aluno da lista");
            System.out.println("Opção 9 - Voltar");
            System.out.println("\n=========================================");

            System.out.println("\n\nEscolha uma opção: ");
                    op = this.sc.nextInt();

                    switch (op) { 
                        case 1: 
                            opcao001();        
                            break;
                        case 2: 
                            opcao002();
                            break;
                        case 3: 
                            opcao003();
                            break;
                        case 4: 
                            mostrarLista();
                            break;
                        case 5:
                            this.aluno.get(procuraAluno()).calcNotas();
                            break;
                        case 9: 
                             System.out.println("\n\nVoltando para o Menu Principal");
                            break;
                        default: 
                            System.out.println("\n\nOpção Inválida!\nTente Novamente!");
                            break;
                    }
        }while(op!=9);
    }

    private void opcao001(){

        int codigo;
        String nome;

        System.out.println("Digite o código do aluno: ");
        codigo = sc.nextInt();
        System.out.println("Digite o nome do aluno: ");
        nome = sc.next();
        sc.nextLine();

        this.aluno.add(new Aluno(codigo, nome));
    }

    private void opcao002(){
        int codachado;
        String newnome;
        codachado = procuraAluno();
        if(codachado != -1){
            
            System.out.println("\nDigite o novo nome: ");
            newnome = sc.next();
            sc.nextLine();
            System.out.println(""+ this.aluno.get(codachado).getNome()+" passou a se chamar: ");
            this.aluno.get(codachado).setNome(newnome);
            System.out.println(""+ this.aluno.get(codachado).getNome());
        }else{
            System.out.println("\nErro!\nAluno não encotrado");
        }
    }

    private void opcao003(){
        int codachado = procuraAluno();
            this.aluno.remove(codachado);
            
    }

    private int procuraAluno(){
            int cod;
        do {
            mostrarLista();
            System.out.println("\n\nDigite o código do aluno desejado: ");
            cod = sc.nextInt();
            int cont = 0;
            for (Aluno alun : this.aluno) {
                if (alun.getCodigo() == cod) {
                    return cont;
                }
                else{cont++;}
            }
        } while (true);
    }

    public void mostrarLista(){
        int cont = aluno.size();
        System.out.println("\n\nMostrando a lista...");
        System.out.println("\nCódigo --   Aluno ");
        for (int i=0; i<cont; i++) {
            System.out.println(aluno.get(i));
        }
    }

    private void opcao02(){
        int op =0;

        do{
        System.out.println("=========================================");
        System.out.println("\n\n02. RENDIDMENTO ESCOLAR");
        System.out.println("\nOpção 1 - Exibir Rendimento de Aluno");
        System.out.println("Opção 2 - Exibir Rendimento da Turma");
        System.out.println("Opção 9 - Voltar");
        System.out.println("=========================================");

        System.out.println("\n\nEscolha uma opção: ");
                    op = this.sc.nextInt();
                    switch (op) { 
                        case 1:
                            mostrarAluno();
                            break;
                        case 2: 
                            mostrarAlunos();
                            break;
                        case 9: 
                             System.out.println("\n\nVoltando para o Menu Principal");
                            break;
                        default: 
                            System.out.println("\n\nOpção Inválida!\nTente Novamente!");
                            break;
                    }
        }while(op != 9);
        
    }

    private void mostrarAluno(){
        int codachado;
        codachado = procuraAluno();
            System.out.println("\n\nCódigo -- Aluno -- Nota A1 -- Nota P1 -- Nota A2 -- Nota P2 -- Media ");
            System.out.println(this.aluno.get(codachado).getCodigo() + " -- " + this.aluno.get(codachado).getNome() + " -- " + this.aluno.get(codachado).getNotaA1() + " -- " + this.aluno.get(codachado).getNotaP1() + " -- " + this.aluno.get(codachado).getNotaA2() + " -- " + this.aluno.get(codachado).getNotaP2() + " -- " + this.aluno.get(codachado).getMedia());
    }

    private void mostrarAlunos(){
         System.out.println("Mostrando a lista...");
        System.out.println("\n\nCódigo -- Aluno -- Nota A1 -- Nota P1 -- Nota A2 -- Nota P2 -- Meida ");
        for (int codachado = 0; codachado < aluno.size(); codachado++) {
            System.out.println(this.aluno.get(codachado).getCodigo() + " -- " + this.aluno.get(codachado).getNome() + " -- " + this.aluno.get(codachado).getNotaA1() + " -- " + this.aluno.get(codachado).getNotaP1() + " -- " + this.aluno.get(codachado).getNotaA2() + " -- " + this.aluno.get(codachado).getNotaP2() + " -- " + this.aluno.get(codachado).getMedia());
        }
    }    
}
