/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.controlador;

import trabalho.modelo.Universidade;
import trabalho.modelo.Funcionario;


public class Controlador{
        private Universidade uni = new Universidade();

    public void addDepts(String nome, String codigoDep){
        uni.addDepts(nome, codigoDep);
    }

    public void addTecnico(String nome, String codigoFunc, double salario, String nivel, String funcao, String codigoDept){
        uni.addTecnico(nome, codigoFunc, salario, nivel, funcao, codigoDept);
    }

    public void addEfetivo(String nome, String codigoFunc, double salario, String nivel, String titulacao, String Area, String codigoDept){
        uni.addEfetivo(nome, codigoFunc, salario, nivel, titulacao, Area, codigoDept);
    }

    public void addSubstituto(String nome, String codigoFunc, double salario, String nivel,String titulacao, int cargaHor, String codigoDept){
        uni.addSubstituto(nome, codigoFunc, salario, nivel, titulacao, cargaHor, codigoDept);
    }

    public void resumoDepts(){
        uni.resumoDepts();
    }

    public void deptFaixa(double min, double max){
        uni.deptFaixa(min, max);
    }

    public void FuncFaixa(double min, double max){
        uni.FuncFaixa(min, max);
    }

    public void relatorioGeral(){
        uni.relatorioGeral();
    }

    public void exibirTecnicos(){
        uni.exibirTecnicos();
    }

    public void exibirDocentes(){
        uni.exibirDocentes();
    }

    public void exibirEfetivos(){
        uni.exibirEfetivos();
    }

    public void exibirSubstitutos(){
        uni.exibirSubstitutos();
    }

    public void exibirDeptEscolhido(String codigoDept){
        uni.exibirDeptEscolhido(codigoDept);
    }

    public Funcionario buscarFunc_Code(String codigo){
        return uni.buscarFunc_Code(codigo);
    }

    public Funcionario buscarFunc_Nome(String nome){
        return uni.buscarFunc_Nome(nome);
    }
}


