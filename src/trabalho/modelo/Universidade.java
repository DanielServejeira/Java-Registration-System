/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.modelo;

/**
 *
 * @author renna
 */

import trabalho.persistencia.DataBase;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Universidade {
        private DataBase db ;
        private String nomeFacul;

    public Universidade(){
        this.nomeFacul = "FCT-UNESP";
        this.db = new DataBase();
    }

    public void addDepts(String nome, String codigoDep){
        Departamento dept = new Departamento (nome,codigoDep);
        if(dept != null) db.addDepts(dept);
        
    }

    public void addTecnico(String nome, String codigoFunc, double salario, String nivel, String funcao, String codigoDept){
        Tecnico t = new Tecnico(nome, codigoFunc, salario, nivel, funcao);
        

        Departamento dept = db.buscarDeptCodigo(codigoDept);
       // System.out.println("Departamento encontrado: " + dept);

        if(dept==null) System.out.println("Codigo nao encontrado");
        else db.addF_to_Dept(t, dept);    


    }

    public void addEfetivo(String nome, String codigoFunc, double salario, String nivel, String titulacao, String Area, String codigoDept){
        Efetivo D = new Efetivo(nome, codigoFunc, salario, nivel, titulacao, Area);
        Departamento dept = db.buscarDeptCodigo(codigoDept);
        if(dept==null) System.out.println("Codigo nao encontrado");
        else db.addF_to_Dept(D, dept);     
    }

    public void addSubstituto(String nome, String codigoFunc, double salario, String nivel,String titulacao, int cargaHor, String codigoDept){
        Substituto s = new Substituto(nome,codigoFunc,salario,nivel,titulacao,cargaHor);
        Departamento dept = db.buscarDeptCodigo(codigoDept);
        if(dept==null) System.out.println("Codigo nao encontrado");
        else db.addF_to_Dept(s, dept);   
    }


    public void resumoDepts(){
        Departamento depts[] = db.getDepartamentos();
        Integer max = db.getNumDpts();
        System.out.println("=================== RELATÓRIO GERAL (Resumo) ===================");
        for(int i = 0; i < max; i++){
            depts[i].exibirResumoDept();
            System.out.println("--------------------------------------\n");
        }
    }

    public void deptFaixa(double min, double max){
        Departamento depts[] = db.getDepartamentos();
        Integer total = db.getNumDpts();
        double gastoTotal;
        System.out.println("Departamentos que gastam na faixa ("+min+"-"+max+")");
        for(int i = 0; i < total; i++){
            gastoTotal = depts[i].getTotalGastoDept();
            if(gastoTotal >= min && gastoTotal <= max){
                depts[i].exibirResumoDept();   
                System.out.println("--------------------------------------\n");
            }
        }
    }

    public void FuncFaixa(double min, double max){//AAAAAAAAAAAAAA
        Departamento depts[] = db.getDepartamentos();
        Integer totalDepts = db.getNumDpts();
        double gastoTotal;

        System.out.println("Funcionários que ganham na faixa ("+min+"-"+max+")");
        System.out.println("================================================\n");
        for(int i = 0; i < totalDepts; i++){
            gastoTotal = depts[i].getTotalGastoDept();
            if(gastoTotal >= min && gastoTotal <= max){        
                depts[i].exibirFunc_fromDept();
                System.out.println("================================================\n");
            }
        }
    }

    public void relatorioGeral(){
        Departamento depts[] = db.getDepartamentos();
        Integer totalDepts = db.getNumDpts();
        System.out.println("=================== RELATÓRIO GERAL ===================");
        for(int i = 0; i < totalDepts; i++){
            depts[i].exibirDept();
        }
    }

    public void exibirTecnicos(){ //Ta safe
        Departamento depts[] = db.getDepartamentos();
        Integer totalDepts = db.getNumDpts();
        System.out.println("=================== RELATÓRIO GERAL (Técnicos) ===================");
        for(int i = 0; i < totalDepts; i++){
           depts[i].exibirTecnicos_fromDept();
            System.out.println("--------------------------------------------------------------");
        }
    }

    public void exibirDocentes(){
        Departamento depts[] = db.getDepartamentos();
        Integer totalDepts = db.getNumDpts();
        System.out.println("=================== RELATÓRIO GERAL (Docentes) ===================");
        for(int i = 0; i < totalDepts; i++){
           depts[i].exibirDocente_fromDept();
            System.out.println("--------------------------------------------------------------");
        }
    }

    public void exibirEfetivos(){
        Departamento depts[] = db.getDepartamentos();
        Integer totalDepts = db.getNumDpts();
        System.out.println("=================== RELATÓRIO GERAL (Docentes Efetivos) ===================");
        for(int i = 0; i < totalDepts; i++){
           depts[i].exibirDocEfetivo_fromDept();
        }
    }

    public void exibirSubstitutos(){
        Departamento depts[] = db.getDepartamentos();
        Integer totalDepts = db.getNumDpts();
        System.out.println("=================== RELATÓRIO GERAL (Docentes Substitutos) ===================");
        for(int i = 0; i < totalDepts; i++){
           depts[i].exibirDocSubstituto_fromDept();
        }
    }

    public void exibirDeptEscolhido(String codigoDept){
        Departamento dept =  db.buscarDeptCodigo(codigoDept);   
        System.out.println("Departamento encontrado: " + dept);     
        if(dept != null){
            dept.exibirDept();
        }else{
            System.out.println("Departamento não existe\n");
        }
    }

    public Funcionario buscarFunc_Code(String codigo){
       // Funcionario funcionario[] = new Departamento();
        Departamento depts[] = db.getDepartamentos();    //implementar try e catch
        Funcionario funcionario;
        Integer totalDepts = db.getNumDpts();
        for(int i = 0; i < totalDepts; i++){
            funcionario = depts[i].buscaCodigo(codigo); //aqui já vai retornar um clone
            if(funcionario != null){
                funcionario.exibirFunc();           
                return funcionario;
            }
        }
        return null;
    }

    public Funcionario buscarFunc_Nome(String nome){
        // Funcionario funcionario[] = new Departamento();
         Departamento depts[] = db.getDepartamentos();          //implementar try e catch
         Funcionario funcionario;
         Integer totalDepts = db.getNumDpts();
         for(int i = 0; i < totalDepts; i++){
             funcionario = depts[i].buscaCodigo(nome);
             if(funcionario != null){
                try{
                    funcionario.exibirFunc();
                    return funcionario.clone();         //Clone do clone dá problema?
                }catch(CloneNotSupportedException ex) {
                    Logger.getLogger(Universidade.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
         }
         return null;
     }


}
	


