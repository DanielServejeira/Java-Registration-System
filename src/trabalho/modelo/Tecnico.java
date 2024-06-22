/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.modelo;

/**
 *
 * @author renna
 */

public class Tecnico extends Funcionario {
    public static final String tipo = Constantes.TECNICO;
    protected String funcao;
    double adicional = 0;

    public Tecnico(){
        super();
        this.funcao = "Indefinido";
    }

    public Tecnico(String nome, String codigo, double salario, String nivel, String funcao) { //tirar o pedido de tipo?
        super(nome, codigo, salario, nivel, tipo);
        this.funcao = funcao;
    }

    public double calcularSalario(){
        switch (nivel) {
            case "T1":
                adicional = Constantes.TECNICO_T1;  //10%
                break;
            case "T2":
                adicional = Constantes.TECNICO_T2;   //20%
                break;
            default:
                break;
        }
        return salario*(1+adicional);
    }

    public void exibir(){
        super.exibirFunc();
        System.out.println("Função: "+funcao);
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String cargo) {
        this.funcao = cargo;
    }

    
}

