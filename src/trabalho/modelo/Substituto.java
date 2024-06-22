/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.modelo;

/**
 *
 * @author renna
 */

public class Substituto extends Docente {
   // private String tipo = Constantes.SUBSTITUTO;
    private int cargaHor;
    private static final String tipo = Constantes.SUBSTITUTO;
    double adicional;

    public Substituto(){
        super();
        this.cargaHor = cargaHor;
    }

    public Substituto(String nome, String codigo, double salario, String nivel,String titulacao, int cargaHor){ //remover tipo
        super(nome,codigo,salario,nivel, tipo, titulacao);
        this.cargaHor = cargaHor;
    }

    public double calcularSalario(){
        switch (nivel) {
            case "S1":
                adicional = Constantes.DOCENTE_SUBSTITUTO_S1;                //5%
                break;
            case "S2":
                adicional = Constantes.DOCENTE_SUBSTITUTO_S2;               //10%
                break;
            default:
                break;
        }
        return salario * (1 + adicional) ;
    }

    public void exibirFunc() {
        super.exibirFunc();
        System.out.println("Carga Horária: "+cargaHor);

    }

    public int getCargaHor() {
        return cargaHor;
    }

    public void setCargaHor(int cargaHor) {
        this.cargaHor = cargaHor;
    }

    
}