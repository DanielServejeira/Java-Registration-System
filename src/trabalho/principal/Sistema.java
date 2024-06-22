package trabalho.principal;

import java.util.Scanner;

import trabalho.controlador.Controlador;

    public class Sistema {
        Controlador control = new Controlador();
        private int menu(Scanner sc) {
            String menu = "====================== MENU =======================\n"
                        + "| 1  <= Cadastrar Departamento                    |\n"
                        + "| 2  <= Cadastrar Funcionários                    |\n"
                        + "| 3  <= Exibir Resumo dos Departamentos           |\n"
                        + "| 4  <= Exibir Departamentos por Faixa de Gasto   |\n"
                        + "| 5  <= Exibir Funcionários por Faixa de Salário  |\n"
                        + "| 6  <= Relatório Geral                           |\n"
                        + "| 7  <= Menu de Exibicao                          |\n"
                        + "| 8  <= Buscar Dados de Departamento              |\n"
                        + "| 0  <= Sair                                      |\n"
                        + "|=================================================|\n";
            System.out.println(menu);
            int op = Integer.parseInt(sc.nextLine());
            return op;
        }

        private void menuExibirDocente(Scanner sc){
            String menuEx = "============ MENU DE EXIBICAO DE FUNCIONARIOS =============\n"
                        + "| 1  <= Exibir Todos os Técnicos                          |\n"
                        + "| 2  <= Exibir Todos os Docentes                          |\n"
                        + "| 3  <= Exibir Todos os Docentes Efetivos                 |\n"     
                        + "| 4  <= Exibir Todos os Docentes Substitutos              |\n"     
                        + "| 5  <= Buscar Dados de funcionario (p/ nome)             |\n"                           
                        + "| 6  <= Buscar Dados de funcionario (p/ codigo)           |\n"                           
                        + "| 0  <= Voltar Menu Principal                             |\n"
                        + "|=========================================================|\n";
            System.out.println(menuEx);
            int option;
            String nome, codigo;
            do{
                System.out.println(menuEx);
                option = Integer.parseInt(sc.nextLine());
                switch (option) {
                    case 1:
                        control.exibirTecnicos();
                        break;
                    case 2:
                        control.exibirDocentes();
                        break;
                    case 3:
                        control.exibirEfetivos();
                        break;
                    case 4:
                        control.exibirSubstitutos();
                        break;
                    case 5:
                        System.out.print("Nome do funcionário: ");
                        nome = sc.nextLine();
                        control.buscarFunc_Nome(nome);
                        break;
                    case 6:
                        System.out.print("Codigo do Funcionario: ");
                        codigo = sc.nextLine();
                       
                        control.buscarFunc_Code(codigo);
                        break;
                    case 0:
                        System.out.println("Encerrando Cadastro de Funcionários\nVoltando ao Menu Principal");
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            }while(option!=0);
            executar(sc);
        }

        private void menuFuncionario(Scanner sc) {
            String menuFunc = "============== CADASTRO DE FUNCIONÁRIOS ============== \n"
                        + "| 1 <= Cadastrar Técnico                             |\n"
                        + "| 2 <= Cadastrar Docente Efetivo                     |\n"
                        + "| 3 <= Cadastrar Docente Substitutivo                |\n"
                        + "| 0 <= Voltar para Menu Principal                    |\n"
                        + "=====================================================|\n";
            //System.out.println(menuFunc);
            int opt;
            
            String nome, code, nivel, funcao, codeDept, titulacao, area;
            int cargaHor;
            double salario;
            do{
                System.out.println(menuFunc);
                opt = Integer.parseInt(sc.nextLine());
                switch (opt) {
                    case 1:
                        System.out.print("Nome: ");
                        nome = sc.nextLine();
                        System.out.print("Código: ");
                        code = sc.nextLine();
                        System.out.print("Função: ");
                        funcao = sc.nextLine();
                        System.out.print("Nível: ");
                        nivel = sc.nextLine();
                        System.out.print("Salário base: ");
                        salario = Double.parseDouble(sc.nextLine());
                        System.out.print("Código do Departamento vinculado: ");
                        codeDept = sc.nextLine();
                        System.out.println(("CODE: "+codeDept));
                        
                        control.addTecnico(nome, code, salario, nivel, funcao, codeDept);
                        break;
                    case 2:
                        System.out.print("Nome: ");
                        nome = sc.nextLine();
                        System.out.print("Código: ");
                        code = sc.nextLine();
                        System.out.print("Titulação: ");
                        titulacao = sc.nextLine();
                        System.out.print("Nível: ");
                        nivel = sc.nextLine();
                        System.out.print("Área: ");
                        area = sc.nextLine();
                        System.out.print("Salário base: ");
                        salario = Double.parseDouble(sc.nextLine());
                        System.out.print("Código do Departamento vinculado: ");
                        codeDept = sc.nextLine();

                        control.addEfetivo(nome, code, salario, nivel, titulacao, area, codeDept);
                        break;
                        case 3:
                        System.out.print("Nome: ");
                        nome = sc.nextLine();
                        System.out.print("Código: ");
                        code = sc.nextLine();
                        System.out.print("Titulação: ");
                        titulacao = sc.nextLine();

                        System.out.print("Nível: ");
                        nivel = sc.nextLine();
                        System.out.print("Carga Horária: ");
                        cargaHor = Integer.parseInt(sc.nextLine());
                        System.out.print("Salário base: ");
                        salario = Double.parseDouble(sc.nextLine());
                        System.out.print("Código do Departamento vinculado: ");
                        codeDept = sc.nextLine();

                        control.addSubstituto(nome, code, salario, nivel, titulacao, cargaHor, codeDept);
                        break;
                    case 0:
                        System.out.println("Encerrando Cadastro de Funcionários\nVoltando ao Menu Principal");
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            }while(opt != 0);
            executar(sc);
        }
        
        public void executar(Scanner sc){
            int op;
            String nomeDept, codeDept;
            double max, min;
            
            
            do{
                op = menu(sc);
                switch (op) {
                    case 1:
                        System.out.print("Nome do Departamento: ");
                        nomeDept = sc.nextLine();
                        System.out.print("Codigo: ");
                        codeDept = sc.nextLine();
                        
                        control.addDepts(nomeDept, codeDept);
                        break;
                    case 2:
                        menuFuncionario(sc);

                        break;
                    case 3:
                        control.resumoDepts();
                        break;
                    case 4:
                        System.out.print("Estabeleça a faixa de gasto: ");
                        System.out.print("Minimo: ");
                        min = Integer.parseInt(sc.nextLine());
                        System.out.print("Maximo: ");
                        max = Integer.parseInt(sc.nextLine());
                       
                        control.deptFaixa(min, max);    
                        break;
                    case 5:
                        System.out.print("Estabeleça a faixa de gasto: ");
                        System.out.print("Minimo: ");
                        min = Integer.parseInt(sc.nextLine());
                        System.out.print("Maximo: ");
                        max = Integer.parseInt(sc.nextLine());
                    
                        control.FuncFaixa(min, max);
                        break;
                    case 6:
                        control.relatorioGeral();
                        break;
                    case 7:
                        menuExibirDocente(sc);
                        break;
                    case 8:
                        System.out.print("Codigo do Funcionario: ");
                        codeDept = sc.nextLine();
                        control.exibirDeptEscolhido(codeDept);
                        break;
                    case 0:
                        System.out.println("Até logo!");
                        break;
                
                    default:
                        break;
                }
            }while(op!=0);
            sc.close();
        }

     
}





