/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.dados;

import java.util.Scanner;

/**
 *
 * @author Inu
 */
public class AplicacaoCliente {
    
    
    private static void main(String args[]){
        
                ColecaoAmbiente cole_ambiente = new ColecaoAmbiente();
		ColecaoCurso cole_curso = new ColecaoCurso();
		ColecaoLaboratorio cole_laboratorio = new ColecaoLaboratorio();
		ColecaoProfessor cole_professor = new ColecaoProfessor();
		ColecaoSetorLogico cole_set_logico = new ColecaoSetorLogico();   
        
                final int PORTA_PADRAO = 29900;
                final String IP_SERVIDOR = "localhost";
                
                ClienteSocket cli1 = new ClienteSocket(PORTA_PADRAO,IP_SERVIDOR);
                
                
                
        
    }//fim do main
    
    
    
    
    /**
	 * Metodo estático (leInteiro), é feito para garantir a leitura de um inteiro e retorna um Integer com tal informação.
 	 * @return inteiro Integer
	 */
	private static int leInteiro(){
		
		Scanner tcl = new Scanner(System.in);
		
		System.out.print("Digite um inteiro: ");
		while (!tcl.hasNextInt()) {			
			tcl.nextLine();
		}
		
		int inteiro = tcl.nextInt();
		tcl.nextLine();
		return inteiro;
		
	}
        
        
        
    /**
	 * @see cliente.dados.ColecaoAmbiente
	 * @see cliente.dados.ColecaoCurso
	 * @see cliente.dados.ColecaoLaboratorio
	 * @see cliente.dados.ColecaoProfessor
	 * @see cliente.dados.ColecaoSetorLogico
 	 * 
 	 * Este metodo estatico (menuPrincipal), é utilizado mostrar o menu principal, onde 
 	 * 	se tem duas opções que chamam - os outros dois submenus
 	 *   
 	 * @param cole_ambiente ColecaoAmbiente - Coleção que guarda objetos do tipo Ambiente.
 	 * @param cole_curso ColecaoCurso - Coleção que guarda objetos do tipo Curso.
 	 * @param cole_laboratorio ColecaoLaboratorio - Coleção que guarda objetos do tipo Laboratorio.
 	 * @param cole_professor ColecaoProfessor - Coleção que guarda objetos do tipo Professor.
 	 * @param cole_set_logico ColecaoSetorLogico - Coleção que guarda objetos do tipo SetorLogico.
 	 * 
 	 * @return void
 	 */
    private static void menuPrincipal(ColecaoAmbiente cole_ambiente, ColecaoCurso cole_curso, ColecaoLaboratorio cole_laboratorio, ColecaoProfessor cole_professor, ColecaoSetorLogico cole_set_logico) throws Exception {
		
		Integer opmenu = 0;
		
		do{
			
				System.out.println("================================================");
				System.out.println("MENU PRINCIPAL - SISTEMA AGENDAMENTO - Cliente");
				System.out.println("================================================");
				System.out.println("Digite [1] para entrar no submenu da Colecão de Ambientes :");
				System.out.println("================================================");
				System.out.println("Digite [2] para entrar no submenu da Colecão de Laboratorio :");
				System.out.println("================================================");
				System.out.println("Digite [0] para sair:");
				System.out.println("================================================");
		
				opmenu=leInteiro();
		
				switch(opmenu) {
		
					case 1:
						submenuAmbiente( cole_ambiente,  cole_curso,  cole_laboratorio, cole_professor, cole_set_logico);
						break;
				
					case 2:
						submenuLaboratorio(cole_ambiente,  cole_curso,  cole_laboratorio, cole_professor, cole_set_logico);
						break;

						
					case 0:
						break;
		
				default:
					System.out.println("Digite uma opcao valida [0] ou [1-2]");
					break;
				}
		
		
			}while(opmenu!=0);
		
	}
    
    
    private static void submenuAmbiente(ColecaoAmbiente cole_ambiente, ColecaoCurso cole_curso, ColecaoLaboratorio cole_laboratorio, ColecaoProfessor cole_professor, ColecaoSetorLogico cole_set_logico) throws Exception {
		
		Integer opmenu = 0;
		
		do{
			
				System.out.println("================================================");
				System.out.println("SUBMENU AMBIENTE - SISTEMA AGENDAMENTO - Cliente");
				System.out.println("================================================");
				System.out.println("Digite [1] para adicionar um novo ambiente: ");
				System.out.println("====================================================");
				System.out.println("Digite [2] para ver os ambientes cadastrados: ");
				System.out.println("====================================================");
				System.out.println("Digite [0] para sair:");
				System.out.println("================================================");
		
				opmenu=leInteiro();
		
				switch(opmenu) {
		
					case 1:
						
						break;
				
					case 2:
						
						break;

						
					case 0:
						break;
		
				default:
					System.out.println("Digite uma opcao valida [0] ou [1-2]");
					break;
				}
		
		
			}while(opmenu!=0);
		
	}
    
    private static void submenuLaboratorio(ColecaoAmbiente cole_ambiente, ColecaoCurso cole_curso, ColecaoLaboratorio cole_laboratorio, ColecaoProfessor cole_professor, ColecaoSetorLogico cole_set_logico) throws Exception {
		
		Integer opmenu = 0;
		
		do{
			
				System.out.println("====================================================");
				System.out.println("SUBMENU LABORATORIO - SISTEMA AGENDAMENTO - Cliente");
				System.out.println("====================================================");
				System.out.println("Digite [1] para adicionar um novo laboratorio: ");
				System.out.println("====================================================");
				System.out.println("Digite [2] para ver os ambientes cadastrados: ");
				System.out.println("====================================================");
		
				opmenu=leInteiro();
		
				switch(opmenu) {
		
					case 1:
						
						break;
				
					case 2:
						
						break;

						
					case 0:
						break;
		
				default:
					System.out.println("Digite uma opcao valida [0] ou [1-2]");
					break;
				}
		
		
			}while(opmenu!=0);
		
	}
    
   
 
    
    
}//fim da classe

                               