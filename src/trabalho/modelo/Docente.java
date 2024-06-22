/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.modelo;

/**
 *
 * @author renna
 */

public abstract class Docente extends Funcionario {
    private String titulacao;
    
    public Docente() {
        super();
        this.titulacao = titulacao;
    }

    public Docente(String nome, String codigo, double salario, String nivel, String tipo, String titulacao) {
        super(nome, codigo, salario, nivel, tipo);
        this.titulacao = titulacao;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String disciplina) {
        this.titulacao = disciplina;
    }

    public void exibirFunc(){
        super.exibirFunc();
        System.out.println("Titulação: "+titulacao);
    }
    
    
}


