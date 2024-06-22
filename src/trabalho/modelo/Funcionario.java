/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.modelo;

/**
 *
 * @author renna
 */

public abstract class Funcionario implements Cloneable {
    protected String Nome;
    protected String codigo;
    protected double salario;
    protected String nivel;
    protected String tipo;
   
    public Funcionario(){
        this.Nome = "name";
        this.codigo = "*******";
        this.nivel = "nenhum";
        this.salario = 0;
        this.tipo = "Indefinido";

    }

    public Funcionario(String nome, String codigo, double salario, String nivel, String tipo) {
        Nome = nome;
        this.codigo = codigo;
        this.salario = salario;
        this.nivel = nivel;
        this.tipo = tipo;
    }
    
    public abstract double calcularSalario();

    public void exibirFunc() {
        System.out.println("Nome: " + Nome);
        System.out.println("Código: " + codigo);
        System.out.println("Salário: " + getSalario());
        System.out.println("Nível: " + nivel);
        System.out.println("Tipo: " + tipo);;
        
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getSalario() {
        return calcularSalario();
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Funcionario clone() throws CloneNotSupportedException{
        return (Funcionario) super.clone();
    }

}