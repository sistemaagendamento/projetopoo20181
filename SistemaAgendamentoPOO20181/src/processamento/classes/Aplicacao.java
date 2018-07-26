package processamento.classes;

import java.util.Scanner;

import processamento.colecoes.*;


public class Aplicacao {

	public static void main(String[] args) {
		
		ColecaoAmbiente cole_ambiente = new ColecaoAmbiente();
		ColecaoCurso cole_curso = new ColecaoCurso();
		ColecaoLaboratorio cole_laboratorio = new ColecaoLaboratorio();
		ColecaoProfessor cole_professor = new ColecaoProfessor();
		ColecaoSetorLogico cole_set_logico = new ColecaoSetorLogico();
		
		abrirArquivosHash( cole_curso, cole_professor, cole_set_logico);
		abrirArquivosArray(cole_ambiente,cole_laboratorio);
		
		try {
			menuPrincipal( cole_ambiente,  cole_curso,  cole_laboratorio, cole_professor, cole_set_logico);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		salvarNosArquivosHash(cole_curso, cole_professor, cole_set_logico);
		salvarNosArquivosArray(cole_ambiente,cole_laboratorio);
		
	}//fim do metodo main

	/**
	 * @see processamento.colecoes.ColecaoCurso
	 * @see processamento.colecoes.ColecaoProfessor
	 * @see processamento.colecoes.ColecaoSetorLogico
 	 * 
 	 * Este metodo estatico (abrirArquivosHash), é utilizado para abrir os arquivos das coleções
 	 *   
 	 * @param cole_curso ColecaoCurso - Coleção que guarda objetos do tipo Curso.
 	 * @param cole_professor ColecaoProfessor - Coleção que guarda objetos do tipo Professor.
 	 * @param cole_set_logico ColecaoSetorLogico - Coleção que guarda objetos do tipo SetorLogico.
 	 * 
 	 * @return void
 	 */
	private static void abrirArquivosHash (ColecaoCurso cole_curso, ColecaoProfessor cole_professor, ColecaoSetorLogico cole_set_logico) {
		try {
			
			cole_curso.lerDoXml();			
			cole_professor.lerDoXml();
			cole_set_logico.lerDoXml();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @see processamento.colecoes.ColecaoAmbiente
	 * @see processamento.colecoes.ColecaoLaboratorio
 	 * 
 	 * Este metodo estatico (abrirArquivosArray), é utilizado para abrir os arquivos das coleções
 	 *   
 	 * @param cole_ambiente ColecaoAmbiente - Coleção que guarda objetos do tipo Ambiente.
 	 * @param cole_laboratorio ColecaoLaboratorio - Coleção que guarda objetos do tipo Laboratorio.
 	 * 
 	 * @return void
 	 */
	private static void abrirArquivosArray(ColecaoAmbiente cole_ambiente, ColecaoLaboratorio cole_laboratorio) {
		try {
			
			cole_ambiente.lerDoXml();
			cole_laboratorio.lerDoXml();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

	/**
	 * @see processamento.colecoes.ColecaoCurso
	 * @see processamento.colecoes.ColecaoLaboratorio
	 * @see processamento.colecoes.ColecaoProfessor
	 * @see processamento.colecoes.ColecaoSetorLogico
 	 * 
 	 * Este metodo estatico (salvarNosArquivosHash), é utilizado para salvar os dados nos arquivos das coleções
 	 *   
 	 * @param cole_ambiente ColecaoAmbiente - Coleção que guarda objetos do tipo Ambiente.
 	 * @param cole_curso ColecaoCurso - Coleção que guarda objetos do tipo Curso.
 	 * @param cole_laboratorio ColecaoLaboratorio - Coleção que guarda objetos do tipo Laboratorio.
 	 * @param cole_professor ColecaoProfessor - Coleção que guarda objetos do tipo Professor.
 	 * @param cole_set_logico ColecaoSetorLogico - Coleção que guarda objetos do tipo SetorLogico.
 	 * 
 	 * @return void
 	 */
	private static void salvarNosArquivosHash(ColecaoCurso cole_curso, ColecaoProfessor cole_professor, ColecaoSetorLogico cole_set_logico) {
		try {
			
			cole_curso.salvarEmXml();			
			cole_professor.salvarEmXml();
			cole_set_logico.salvarEmXml();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * @see processamento.colecoes.ColecaoAmbiente
	 * @see processamento.colecoes.ColecaoLaboratorio
 	 * 
 	 * Este metodo estatico (salvarNosArquivosArray), é utilizado para salvar os dados nos arquivos das coleções
 	 *   
 	 * @param cole_ambiente ColecaoAmbiente - Coleção que guarda objetos do tipo Ambiente.
 	 * @param cole_laboratorio ColecaoLaboratorio - Coleção que guarda objetos do tipo Laboratorio.
 	 * 
 	 * @return void
 	 */
	private static void salvarNosArquivosArray(ColecaoAmbiente cole_ambiente, ColecaoLaboratorio cole_laboratorio) {
		try {
			
			cole_ambiente.salvarEmXml();
			cole_laboratorio.salvarEmXml();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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
	 * Metodo estático (leString), é feito para garantir a leitura de uma String e retorna um String com tal informação.
 	 * @return texto String
	 */
	private static String leString(){
		
		Scanner tcl = new Scanner(System.in);
		
		System.out.print("Digite um texto: ");
		String texto = tcl.nextLine();
		return texto;
		
	}
	
	/**
	 * @see processamento.colecoes.ColecaoAmbiente
	 * @see processamento.colecoes.ColecaoCurso
	 * @see processamento.colecoes.ColecaoLaboratorio
	 * @see processamento.colecoes.ColecaoProfessor
	 * @see processamento.colecoes.ColecaoSetorLogico
 	 * 
 	 * Este metodo estatico (menuPrincipal), é utilizado mostrar o menu principal, onde 
 	 * 	se tem duas opções que chamam - os outros dois submenus - submenuColecoes e submenuSockets
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
				System.out.println("MENU PRINCIPAL - SISTEMA AGENDAMENTO - Servidor");
				System.out.println("================================================");
				System.out.println("Digite [1] para entrar no submenu das Colecoes :");
				System.out.println("================================================");
				System.out.println("Digite [2] para entrar no submenu de Sockets :");
				System.out.println("================================================");
				System.out.println("Digite [0] para sair:");
				System.out.println("================================================");
		
				opmenu=leInteiro();
		
				switch(opmenu) {
		
					case 1:
						submenuColecoes( cole_ambiente,  cole_curso,  cole_laboratorio, cole_professor, cole_set_logico);
						break;
				
					case 2:
						submenuSockets( cole_ambiente,  cole_laboratorio, cole_professor);
						break;

						
					case 0:
						break;
		
				default:
					System.out.println("Digite uma opcao valida [0] ou [1-2]");
					break;
				}
		
		
			}while(opmenu!=0);
		
	}
	
	
	
	
	/**
	 * @see processamento.colecoes.ColecaoAmbiente
	 * @see processamento.colecoes.ColecaoCurso
	 * @see processamento.colecoes.ColecaoLaboratorio
	 * @see processamento.colecoes.ColecaoProfessor
	 * @see processamento.colecoes.ColecaoSetorLogico
 	 * 
 	 * Este metodo estatico (submenuColecoes), é utilizado gerir tudo que for relacionado a modificação das coleções
 	 *   
 	 * @param cole_ambiente ColecaoAmbiente - Coleção que guarda objetos do tipo Ambiente.
 	 * @param cole_curso ColecaoCurso - Coleção que guarda objetos do tipo Curso.
 	 * @param cole_laboratorio ColecaoLaboratorio - Coleção que guarda objetos do tipo Laboratorio.
 	 * @param cole_professor ColecaoProfessor - Coleção que guarda objetos do tipo Professor.
 	 * @param cole_set_logico ColecaoSetorLogico - Coleção que guarda objetos do tipo SetorLogico.
 	 * 
 	 * @return void
 	 */
	private static void submenuColecoes(ColecaoAmbiente cole_ambiente, ColecaoCurso cole_curso, ColecaoLaboratorio cole_laboratorio, ColecaoProfessor cole_professor, ColecaoSetorLogico cole_set_logico) throws Exception {
		Integer opmenu = 0;
		
		do{
			
				System.out.println("=================================================================");
				System.out.println("SUBMENU COLECOES - SISTEMA AGENDAMENTO - Servidor");
				System.out.println("=================================================================");
				System.out.println("Digite [1] para entrar no submenu da colecao de Ambientes :");
				System.out.println("=================================================================");
				System.out.println("Digite [2] para entrar no submenu da colecao de Cursos :");
				System.out.println("=================================================================");
				System.out.println("Digite [3] para entrar no submenu da colecao de Laboratorios :");
				System.out.println("=================================================================");
				System.out.println("Digite [4] para entrar no submenu da colecao de Professores :");
				System.out.println("=================================================================");
				System.out.println("Digite [5] para entrar no submenu da colecao de Setores Logicos:");
				System.out.println("=================================================================");
				System.out.println("Digite [0] para voltar:");
				System.out.println("=================================================================");
		
				opmenu=leInteiro();
		
				switch(opmenu) {
		
					case 1:
						submenuAmbiente(cole_ambiente, cole_professor);
						break;
				
					case 2:
						submenuCurso(cole_curso, cole_professor);
						break;

					case 3:
						submenuLaboratorio(cole_laboratorio, cole_professor);
						break;

					case 4:
						submenuProfessor(cole_professor, cole_set_logico);
						break;

					case 5:
						submenuSetorLogico(cole_set_logico, cole_professor, cole_curso);
						break;
						
					case 0:
						break;
		
				default:
					System.out.println("Digite uma opcao valida [0] ou [1-5]");
					break;
				}
		
		
			}while(opmenu!=0);
		
	}
	
	/**
	 * @see processamento.colecoes.ColecaoAmbiente
	 * Este metodo estatico (submenuAmbiente), é utilizado gerir tudo que for relacionado a modificação da Coleção de Ambientes.
	 * @param cole_ambiente ColecaoAmbiente - Coleção que guarda objetos do tipo Ambiente.
	 */
	private static void submenuAmbiente(ColecaoAmbiente cole_ambiente, ColecaoProfessor cole_professor) throws Exception {
		
		Integer opmenu = 0;
		
		do{
			
				System.out.println("====================================================");
				System.out.println("MENU PRINCIPAL DA COLECAO DE AMBIENTES");
				System.out.println("====================================================");
				System.out.println("Digite [1] para adicionar um novo ambiente: ");
				System.out.println("====================================================");
				System.out.println("Digite [2] para ver os ambientes cadastrados: ");
				System.out.println("====================================================");
				System.out.println("Digite [3] para pesquisar um ambiente pelo horario: ");
				System.out.println("====================================================");
				System.out.println("Digite [4] para remover um ambiente pelo horario: ");
				System.out.println("====================================================");
				System.out.println("Digite [5] para salvar os dados da ram no arquivo:");
				System.out.println("====================================================");
				System.out.println("Digite [6] para ler os dados do arquivo:");
				System.out.println("====================================================");
				System.out.println("Digite [0] para voltar:");
				System.out.println("====================================================");
		
				opmenu=leInteiro();
		
				switch(opmenu) {
		
				case 1:
					Ambiente ambitmp = new Ambiente();
					ambitmp.criarAmbiente();
					System.out.print("Digite a matricula do professor solicitador do ambiente: ");
					ambitmp.setSolicitador(cole_professor.pesquisarProfessor(leString() ));
					cole_ambiente.adicionarAmbiente(ambitmp);
					break;
					
				case 2:
					cole_ambiente.verColecaoAmbiente();
					break;
				
				case 3:
					HorarioAmbiente horario_de_pesquisa = new HorarioAmbiente();
					horario_de_pesquisa.criarHorarioAmbiente();
					cole_ambiente.procurarAmbiente(horario_de_pesquisa);
					break;
				
				case 4:
					HorarioAmbiente horario_pesquisa = new HorarioAmbiente();
					horario_pesquisa.criarHorarioAmbiente();
					cole_ambiente.removerAmbiente(horario_pesquisa);
					break;
					
				case 5:
					cole_ambiente.salvarEmXml();
					break;
					
				case 6:
					cole_ambiente.lerDoXml();
					break;
					
					
				case 0:
					break;
		
				default:
					System.out.println("Digite uma opcao valida [1-5] ou [0]");
					break;
				}
		
		
			}while(opmenu!=0);
	}
	
	/**
	 * @see processamento.colecoes.ColecaoCurso
	 * Este metodo estatico (submenuCurso), é utilizado gerir tudo que for relacionado a modificação da Coleção de Cursos.
	 * @param cole_curso ColecaoCurso - Coleção que guarda objetos do tipo Curso.
	 */
	private static void submenuCurso(ColecaoCurso cole_curso, ColecaoProfessor cole_professor) throws Exception {
		
		Integer opmenu = 0;
		
		do{
			
				System.out.println("====================================================");
				System.out.println("MENU PRINCIPAL DA COLECAO DE CURSOS");
				System.out.println("====================================================");
				System.out.println("Digite [1] para adicionar um novo curso: ");
				System.out.println("====================================================");
				System.out.println("Digite [2] para pesquisar um curso pelo id: ");
				System.out.println("====================================================");
				System.out.println("Digite [3] para remover um curso pelo id: ");
				System.out.println("====================================================");
				System.out.println("Digite [4] para salvar os dados da ram no arquivo:");
				System.out.println("====================================================");
				System.out.println("Digite [5] para ler os dados do arquivo:");
				System.out.println("====================================================");
				System.out.println("Digite [0] para voltar:");
				System.out.println("====================================================");
		
				opmenu=leInteiro();
		
				switch(opmenu) {
		
				case 1:
						Curso cursotmp = new Curso();
						cursotmp.criarCurso();
						cursotmp.setCoordenador(cole_professor.pesquisarProfessor(leString() ));
						cole_curso.adicionarCurso(cursotmp);
					
					break;
				
				case 2:
					String id_de_pesquisa = leString();
					
					cole_curso.pesquisarCurso(id_de_pesquisa);
					break;
				
				case 3:
					String id_pesquisa = leString();
					cole_curso.removerCurso(id_pesquisa);
					break;
					
				case 4:
					cole_curso.salvarEmXml();
					break;
					
				case 5:
					cole_curso.lerDoXml();
					break;
					
					
				case 0:
					break;
		
				default:
					System.out.println("Digite uma opcao valida [1-5] ou [0]");
					break;
				}
		
		
			}while(opmenu!=0);
	}
	
	/**
	 * @see processamento.colecoes.ColecaoLaboratorio
	 * Este metodo estatico (submenuLaboratorio), é utilizado gerir tudo que for relacionado a modificação da Coleção de Laboratorios.
	 * @param cole_curso ColecaoLaboratorio - Coleção que guarda objetos do tipo Laboratorio.
	 */
	private static void submenuLaboratorio(ColecaoLaboratorio cole_laboratorio, ColecaoProfessor cole_professor) throws Exception {
		
		Integer opmenu = 0;
		
		do{
			
				System.out.println("====================================================");
				System.out.println("MENU PRINCIPAL DA COLECAO DE LABORATORIOS");
				System.out.println("====================================================");
				System.out.println("Digite [1] para adicionar um novo laboratorio: ");
				System.out.println("====================================================");
				System.out.println("Digite [2] para ver os ambientes cadastrados: ");
				System.out.println("====================================================");
				System.out.println("Digite [3] para pesquisar um laboratorio pelo horario: ");
				System.out.println("====================================================");
				System.out.println("Digite [4] para remover um laboratorio pelo horario: ");
				System.out.println("====================================================");
				System.out.println("Digite [5] para salvar os dados da ram no arquivo:");
				System.out.println("====================================================");
				System.out.println("Digite [6] para ler os dados do arquivo:");
				System.out.println("====================================================");
				System.out.println("Digite [0] para voltar:");
				System.out.println("====================================================");
		
				opmenu=leInteiro();
		
				switch(opmenu) {
		
				case 1:
					Laboratorio lab_tmp = new Laboratorio();
					lab_tmp.criarAmbiente();
					lab_tmp.criarLaboratorio();
					System.out.print("Digite a matricula do professor solicitador do laboratorio: ");
					lab_tmp.setSolicitador(cole_professor.pesquisarProfessor(leString() ));
					cole_laboratorio.adicionarLaboratorio(lab_tmp);
					break;
				
				case 2:
					cole_laboratorio.verColecaoLaboratorio();
					break;
					
				case 3:
					HorarioAmbiente horario_de_pesquisa = new HorarioAmbiente();
					horario_de_pesquisa.criarHorarioAmbiente();
					cole_laboratorio.procurarlaboratorio(horario_de_pesquisa);
					break;
				
				case 4:
					HorarioAmbiente horario_pesquisa = new HorarioAmbiente();
					horario_pesquisa.criarHorarioAmbiente();
					cole_laboratorio.removerlaboratorio(horario_pesquisa);
					break;
					
				case 5:
					cole_laboratorio.salvarEmXml();
					break;
					
				case 6:
					cole_laboratorio.lerDoXml();
					break;
					
					
				case 0:
					break;
		
				default:
					System.out.println("Digite uma opcao valida [1-5] ou [0]");
					break;
				}
		
		
			}while(opmenu!=0);
	}
	
	
	/**
	 * @see processamento.colecoes.ColecaoProfessor
	 * Este metodo estatico (submenuProfessor), é utilizado gerir tudo que for relacionado a modificação da Coleção de Professores.
	 * @param cole_curso ColecaoLaboratorio - Coleção que guarda objetos do tipo Professor.
	 */
	private static void submenuProfessor(ColecaoProfessor cole_professor, ColecaoSetorLogico cole_set_logico) throws Exception {
		
		Integer opmenu = 0;
		
		do{
			
				System.out.println("=========================================================================");
				System.out.println("MENU PRINCIPAL DA COLECAO DE PROFESSORES");
				System.out.println("=========================================================================");
				System.out.println("Digite [1] para adicionar um novo professor: ");
				System.out.println("=========================================================================");
				System.out.println("Digite [2] para pesquisar um professor pela matricula: ");
				System.out.println("=========================================================================");
				System.out.println("Digite [3] para remover um professor pela matricula: ");
				System.out.println("=========================================================================");
				System.out.println("Digite [4] para adicionar um setor logico a um professor pela matricula: ");
				System.out.println("=========================================================================");
				System.out.println("Digite [5] para salvar os dados da ram no arquivo:");
				System.out.println("=========================================================================");
				System.out.println("Digite [6] para ler os dados do arquivo:");
				System.out.println("=========================================================================");
				System.out.println("Digite [0] para voltar:");
				System.out.println("=========================================================================");
		
				opmenu=leInteiro();
		
				switch(opmenu) {
		
				case 1:		
					Professor prof = new Professor();
					prof.criarProfessor();					
					cole_professor.adicionarProfessor(prof);
					break;
				
				case 2:
					String mat_de_pesquisa = leString();
					cole_professor.pesquisarProfessor(mat_de_pesquisa);
					break;
				
				case 3:
					String mat_pesquisa = leString();
					cole_professor.removerProfessor(mat_pesquisa);
					break;
					
				case 4:
					String mat_de_pesq = leString();
					Professor prof2 = cole_professor.pesquisarProfessor(mat_de_pesq);
					prof2.setUa(cole_set_logico.pesquisarSetorLogico(leString() ));
					break;
					
				case 5:
					cole_professor.salvarEmXml();
					break;
					
				case 6:
					cole_professor.lerDoXml();
					break;
					
					
				case 0:
					break;
		
				default:
					System.out.println("Digite uma opcao valida [1-6] ou [0]");
					break;
				}
		
		
			}while(opmenu!=0);
	}
	
	/**
	 * @see processamento.colecoes.SetorLogico
	 * Este metodo estatico (submenuSetorLogico), é utilizado gerir tudo que for relacionado a modificação da Coleção de Setores Logicos.
	 * @param cole_curso ColecaoLaboratorio - Coleção que guarda objetos do tipo SetorLogico.
	 */
	private static void submenuSetorLogico(ColecaoSetorLogico cole_set_logico, ColecaoProfessor cole_professor, ColecaoCurso cole_curso) throws Exception {
		
		Integer opmenu = 0;
		
		do{
			
				System.out.println("====================================================");
				System.out.println("MENU PRINCIPAL DA COLECAO DE SETORES LOGICOS");
				System.out.println("====================================================");
				System.out.println("Digite [1] para adicionar um novo setor logico: ");
				System.out.println("====================================================");
				System.out.println("Digite [2] para adicionar um novo curso na UA: ");
				System.out.println("====================================================");
				System.out.println("Digite [3] para pesquisar um novo setor logico pelo id: ");
				System.out.println("====================================================");
				System.out.println("Digite [4] para remover um novo setor logico pelo id: ");
				System.out.println("====================================================");
				System.out.println("Digite [5] para salvar os dados da ram no arquivo:");
				System.out.println("====================================================");
				System.out.println("Digite [6] para ler os dados do arquivo:");
				System.out.println("====================================================");
				System.out.println("Digite [0] para voltar:");
				System.out.println("====================================================");
		
				opmenu=leInteiro();
		
				switch(opmenu) {
		
				case 1:
					SetorLogico uatmp = new SetorLogico();
					uatmp.criarUnidadeAcademica();
					uatmp.setCoordenador(cole_professor.pesquisarProfessor(leString() ));
					cole_set_logico.adicionarSetorLogico(uatmp);
					break;
				
				case 2:
					System.out.print("Digite o codigo do Curso: ");
					Curso ctmp = cole_curso.pesquisarCurso(leString() );
					System.out.print("Digite a id do SetorLogico: ");
					String uaid_de_pesq = leString();
					cole_set_logico.pesquisarSetorLogico(uaid_de_pesq).adcionarCurso(ctmp);
					break;
					
				case 3:
					String uaid_de_pesquisa = leString();
					cole_set_logico.pesquisarSetorLogico(uaid_de_pesquisa);
					break;
				
				case 4:
					String uaid_pesquisa = leString();
					cole_set_logico.removerSetorLogico(uaid_pesquisa);
					break;
					
				case 5:
					cole_set_logico.salvarEmXml();
					break;
					
				case 6:
					cole_set_logico.lerDoXml();
					break;
					
					
				case 0:
					break;
		
				default:
					System.out.println("Digite uma opcao valida [1-5] ou [0]");
					break;
				}
		
		
			}while(opmenu!=0);	
	}
	
	/**
	 * @see processamento.colecoes.ColecaoAmbiente
	 * @see processamento.colecoes.ColecaoLaboratorio
	 * @see processamento.colecoes.ColecaoProfessor
 	 * 
 	 * Este metodo estatico (submenuSockets), é utilizado gerir tudo que for relacionado a sockets
 	 *   
 	 * @param cole_ambiente ColecaoAmbiente - Coleção que guarda objetos do tipo Ambiente.
 	 * @param cole_laboratorio ColecaoLaboratorio - Coleção que guarda objetos do tipo Laboratorio.
 	 * @param cole_professor ColecaoProfessor - Coleção que guarda objetos do tipo Professor.
 	 * 
 	 * @return void
 	 */
	private static void submenuSockets(ColecaoAmbiente cole_ambiente, ColecaoLaboratorio cole_laboratorio, ColecaoProfessor cole_professor) throws Exception {
	
	}
	
	
}//fim da classe Aplicacao
