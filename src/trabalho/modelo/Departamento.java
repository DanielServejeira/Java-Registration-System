/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author renna
 */

public class Departamento implements Cloneable{ //Retirar esse clone???
        private String nome;
        private String codigoDept;
        private Funcionario funcionarios[];
        private int MAX = Constantes.MAX_FUNC;
        private int count;
        private double gasto;

    //criar um ngc vazio?

    public Departamento(){
        funcionarios = new Funcionario[MAX];
        this.count = 0;
    }
    
    public Departamento(String nome, String codigo){
        this.nome = nome;
        this.codigoDept = codigo;
        funcionarios = new Funcionario [MAX];
        this.count = 0;
        this.gasto = 0;
    }

    public Funcionario [] getFuncionarios(){
        return this.funcionarios;
    }

    public int getNumFunc(){
        return this.count;
    }

    public void addFunc(Funcionario f){
        if(count < MAX){
            if(buscaNome(f.getNome()) == null && buscaCodigo(f.getCodigo()) == null ){
                funcionarios[count] = f;
                count++;
            }else{
                System.out.println("Erro: Código ou nome repetidos");
            }
        }else{
            System.out.println("Não há mais espaço para cadastro");
        }
    }

    public Funcionario buscaCodigo(String code){
        for(int i = 0; i < count; i++){
            if(funcionarios[i] != null && funcionarios[i].getCodigo().equals(code)){
                try{
                    return funcionarios[i].clone();
                }catch (CloneNotSupportedException ex) {
                    Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }            
        }
        return null;
    }

    public Funcionario buscaNome(String nome){
        for(int i = 0; i < count; i++){
            if(funcionarios[i] != null &&funcionarios[i].getNome().equals(nome)){
                try{
                    return funcionarios[i].clone();
                }catch (CloneNotSupportedException ex) {
                    Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }            
        }
        
        return null;
    }

    public double getTotalGastoDept(){
        gasto = 0;
        for(int i = 0; i < count; i++){
            //System.out.println("SOMA: "+funcionarios[i].getSalario());
            gasto += funcionarios[i].getSalario();
        }
        
        return gasto;
    }

    public void exibirDept(){   ///GASTO TOTAL
        System.out.println("--------------DEPARTAMENTO: "+getNomeDept()+"-------------- ");
        System.out.println("Código: "+getCodigoDept());
        System.out.println("Total de funcionários: "+getNumFunc());
        System.out.println("Gasto total com funcionários: "+getTotalGastoDept());
        System.out.println("Média Salarial: "+(getTotalGastoDept()/(double)getNumFunc()));
        System.out.println("Funcionários: ");
            for(int i=0;i<count;i++){
                System.out.println("--------------------------");
                funcionarios[i].exibirFunc();
            }
    }

    public void exibirResumoDept(){
            System.out.println("Departamento: "+getNomeDept()+" ("+getCodigoDept()+")");
            System.out.println("Total de funcionários: "+getNumFunc());
            System.out.println("Gasto total com funcionários: "+getTotalGastoDept());
    }

    public void exibirTecnicos_fromDept(){  //AAAAAAAAAAAAAAAAAA todos
        for(int i=0; i < count; i++){
            if(funcionarios[i].getTipo().equals(Constantes.TECNICO)){
                funcionarios[i].exibirFunc();
            }
        }
    }

    public void exibirDocente_fromDept(){
        
        for(int i = 0; i < count; i++){
            if(funcionarios[i].getTipo().equals(Constantes.EFETIVO) || funcionarios[i].getTipo().equals(Constantes.SUBSTITUTO)){
                funcionarios[i].exibirFunc();
            }
        }
    }

    public void exibirDocEfetivo_fromDept(){
        for(int i=0; i < count; i++){
            if(funcionarios[i].getTipo().equals(Constantes.EFETIVO) && funcionarios[i].getTipo().equals(Constantes.SUBSTITUTO)){
                funcionarios[i].exibirFunc();
            }
        }
    }

    public void exibirDocSubstituto_fromDept(){
        for(int i=0; i < count; i++){
            if(funcionarios[i].getTipo().equals(Constantes.SUBSTITUTO)){
                funcionarios[i].exibirFunc();
            }
        }
    }

    public void exibirFunc_fromDept(){
        for(int i = 0; i < count; i++){
            System.out.println("-----------------------------");
            funcionarios[i].exibirFunc();
        }
    }

    public String getNomeDept() {
        return nome;
    }

    public void setNomeDept(String nome) {
        this.nome = nome;
    }

    public String getCodigoDept() {
        return codigoDept;
    }

    public void setCodigoDept(String codigo) {
        this.codigoDept = codigo;
    }

    public void setFuncionariosDept(Funcionario[] funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Departamento clone() throws CloneNotSupportedException{
        return (Departamento) super.clone();
    }

    
    
}


