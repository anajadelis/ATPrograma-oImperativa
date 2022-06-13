package atfinal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.util.stream.*;

public class app {

    public static List<Empregados> listaDeFuncionarios = new ArrayList<Empregados>();
	
	public static List<Empregados> listaMais1000 = new ArrayList<Empregados>();
	
	public static List<Empregados> igual1000 = new ArrayList<Empregados>();
	
	public static List<Empregados> menor1000 = new ArrayList<Empregados>();
	
	List<Integer> slist = Arrays.asList();  
	
    //opções de cargos
	public static String getCargo(int codigo) {
		
        switch (codigo) {
        case 1:
            return "Analista de Salarios";
        case 2:
            return "Auxiliar de Contabilidade";
        case 3:
            return "Chefe de Cobrança";
        case 4:
            return "Chefe de Expedição";
        case 5:
            return "Contador";
        case 6:
            return "Gerente de Divisão";
        case 7:
            return "Escriturário";
        case 8:
            return "Faxineiro";
        case 9:
            return "Gerente Administrativo";
        case 10:
            return "Gerente Comercial";
        case 11:
            return "Gerente de Pessoal";
        case 12:
            return "Gerente de Treinamento";
        case 13:
            return "Gerente Financeiro";
        case 14:
            return "Contínuo";
        case 15:
            return "Operador de Computador";
        case 16:
            return "Programador de Computador";
        case 17:
            return "Secretária";
            default: 
           return "Informe um numero entre 1-17";
            
            
        }
        
       
   }
    
//Menu principal.
    public static void menu(){
        System.out.println("\tBem vindo ao Banco de Funcionários");
        System.out.println("\tEscolha uma opção:");
        System.out.println("01.Cadastrar Funcionários:");
        System.out.println("02.Pesquisar Funcionários:");
        System.out.println("03.Registro dos Funcionários que recebem mais de R$1000,00:");
        System.out.println("04.Registro dos Funcionários que recebem menos de R$1000,00:");
        System.out.println("05.Registro dos Funcionários que recebem R$1000,00:");
        System.out.println("06.Sair do Programa:");
    }
//Declaração do método de Cadastro dos 200 funcionários. Não esquecer que eles precisam ter matrícula (identificador), cargo, nome e salário.
    public static void cadastro(){
        Scanner input = new Scanner(System.in);
		
		System.out.println("Informe o Nome do empregado");
		String nome = input.next();
		
		System.out.println("Informe a matricula do empregado");
		int matricula = input.nextInt();
		String nomeCargo = "";
		while (true) {
			System.out.println("========"+"\n");
			System.out.println("Cargos:"+"\n");
			System.out.println("1. Analista de Salarios");
			System.out.println("2. Auxiliar de Contabilidade");
			System.out.println("3. Chefe de Cobrança");
			System.out.println("4. Chefe de Expedição");
			System.out.println("5. Contador");
			System.out.println("6. Gerente de Divisão");
			System.out.println("7. Escriturário");
			System.out.println("8. Faxineiro");
			System.out.println("9. Gerente Administrativo");
			System.out.println("10. Gerente Comercial");
			System.out.println("11. Gerente de Pessoal");
			System.out.println("12. Gerente de Treinamento");
			System.out.println("13. Gerente Financeiro");
			System.out.println("14. Contínuo");
			System.out.println("15. Operador de Computador");
			System.out.println("16. Programador de Computador");
			System.out.println("17. Secretária"+"\n");
			
			System.out.println("==============================="+"\n");
			System.out.println("Informe o Cargo do empregado"+"\n");
			System.out.println("===============================");
			
			int cargoCodigo = input.nextInt();
			
			if (cargoCodigo <= 17) {
				 nomeCargo =	getCargo(cargoCodigo);
				System.out.println(nomeCargo+"\n");
				break;
			}
			
		}
		System.out.println("Informe o Salario do empregado");
		int salario = input.nextInt();
		
		Empregados funcionario = new Empregados(nome,salario,matricula,nomeCargo);
		listaDeFuncionarios.add(funcionario);
		
		/*for(Empregados empregado : listaDeFuncionarios) {
			System.out.println(empregado.getNome());
			System.out.println(empregado.getCargo());
			System.out.println(empregado.getMatricula());
			System.out.println(empregado.getSalario());
			System.out.println("=========================="+"\n");}*/
		
		for(Empregados empregado : listaDeFuncionarios) {
			if(empregado.getSalario() > 1000) {
				listaMais1000.add(empregado);
				}
		}
		
		for(Empregados empregado : listaDeFuncionarios) {
		if (empregado.getSalario() == 1000) {
			igual1000.add(empregado);
		}
		}
		
		for(Empregados empregado : listaDeFuncionarios) {
			if (empregado.getSalario() < 1000) {
				menor1000.add(empregado);
			}
			}
		
		
		
	
		System.out.println("= Funcionario Cadastrado! =");
	}

//Declaração do método de pesquisa binária pelo código ou simplesmente pelo nome.
    public static void pesquisa(){
        Scanner input = new Scanner(System.in);
	System.out.println("===================================================================");
	System.out.println("Pesquisar funcionario atravéz de seu nome digite 1.");
	System.out.println("Pesquisar funcionario atravéz de seu numero de matricula digite 2.");
	System.out.println("===================================================================");
	
	String pesquisar = input.next();
	
	switch (pesquisar) {
		
	case "1" :
		System.out.println("Informe o nome do funcionario");
		String nomePesquisa = input.next();
		for(Empregados empregado : listaDeFuncionarios) {
			if(empregado.getNome().equalsIgnoreCase(nomePesquisa)) {
				System.out.println("\n"+"["+"\n");
				System.out.println(" Nome : " + empregado.getNome() + "\n" +" Matricula: " + empregado.getMatricula() + "\n" +" Cargo = "+ empregado.getCargo() + "\n" +" Salario: " + empregado.getSalario());
				System.out.println("]"+"\n");
			}else {
				System.out.println("Não existem funcionarios com esse nome. ");
			}
			
		}
		break;
	case "2" :
		System.out.println("Informe o numero de matricula do funcionario: ");
		int matriPesquisa = input.nextInt();
		for(Empregados empregado : listaDeFuncionarios) {
			if(empregado.getMatricula() == matriPesquisa) {
				System.out.println("\n"+"["+"\n");
				System.out.println(" Nome : " + empregado.getNome() + "\n" +" Matricula: " + empregado.getMatricula() + "\n" +" Cargo = "+ empregado.getCargo() + "\n" +" Salario: " + empregado.getSalario());
				System.out.println("]"+"\n");
			}else {
				System.out.println("Não existem funcionarios com esse numero de matricula.");
			}
			
		}
		break;
	
	default :
		System.out.println("Digite 1 ou 2 para pesquisar o funcionario.");
		PesquisarEmpregado();
	}
	
	
    }
//Declaração do método de registro dos funcionários que recebem mais que R$1000,00.
    public static void registromaisquemil(){
        for(Empregados empregado : listaDeFuncionarios) {
			if((empregado.getSalario()  > 1000) ) {
				System.out.println("Funcionarios que recebem mais que R$1.000");
				System.out.println("\n"+"["+"\n");
				System.out.println(" Nome : " + empregado.getNome() + "\n" +" Matricula: " + empregado.getMatricula() + "\n" +" Cargo = "+ empregado.getCargo() + "\n" +" Salario: " + empregado.getSalario());
				System.out.println("]"+"\n");
			}
		}
    }
//Declaração do método de registro dos funcionários que recebem menos que R$1000,00.
    public static void registromenosquemil(){
        System.out.println("Funcionarios que recebem menos que R$1.000");
	for(Empregados empregado : listaDeFuncionarios) {
		if(empregado.getSalario() <= 999) { 
			System.out.println("\n"+"["+"\n");
			System.out.println(" Nome : " + empregado.getNome() + "\n" +" Matricula: " + empregado.getMatricula() + "\n" +" Cargo = "+ empregado.getCargo() + "\n" +" Salario: " + empregado.getSalario());
			System.out.println("]"+"\n");
		}
	}
    }
//Declaração do método de registro dos funcionários que recebem exatamente R$1000,00
    public static void registromil(){
        for(Empregados empregado : listaDeFuncionarios) {
			if(empregado.getSalario() == 1000) {
				System.out.println("Funcionarios que recebem R$1.000");
				System.out.println("\n"+"["+"\n");
				System.out.println(" Nome : " + empregado.getNome() + "\n" +" Matricula: " + empregado.getMatricula() + "\n" +" Cargo = "+ empregado.getCargo() + "\n" +" Salario: " + empregado.getSalario());
				System.out.println("]"+"\n");
			}
		}
    }
//Declaração do método de saída do programa.    
    public static void saida (){
    System.exit(0);   
    }    
//Execução dos métodos citados acima.
public static void main(String[] args) {
    int opção;
//Leitura da opção.
    Scanner entrada = new Scanner (System.in);
    do{
        menu();
        opcao = entrada.nextInt();
        
        switch(opcao){
//Switch que roda os métodos de acordo com a opção escolhida.
        case 1:
            cadastro();
            break;
            
        case 2:
            pesquisa();
            break;
            
        case 3:
            registromaisquemil();
            break;
            
        case 4:
            registromenosquemil();
            break;

        case 5:
            registromil();
            break;
        
        case 6:
            saida();
            break;
                
        default:
            System.out.println("Opção inválida. Digite um número de um à seis.");
        }
}   while(opcao != 0);
}
}