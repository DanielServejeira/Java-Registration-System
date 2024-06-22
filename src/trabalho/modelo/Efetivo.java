/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.modelo;

/**
 *
 * @author renna
 */

public class Efetivo extends Docente {
    //protected String tipo = Constantes.EFETIVO;
    private String Area;
    private static final String tipo = Constantes.EFETIVO;
    double adicional;
    
    public Efetivo(){
        super();
        this.Area = "Área";
    }

    public Efetivo(String nome, String codigo, double salario, String nivel, String titulacao, String Area){ //remover tipo?
        super(nome,codigo,salario,nivel, tipo, titulacao);
        this.Area = Area;
    }

    public double calcularSalario(){
        switch (nivel) {
            case "D1":
                adicional = Constantes.DOCENTE_EFETIVO_D1;           //5%    
                break;
            case "D2":
                adicional = Constantes.DOCENTE_EFETIVO_D2;          //10%
                break;
            case "D3":
                adicional = Constantes.DOCENTE_EFETIVO_D3;          //20%
                break;
            default:
                break;
        }
        adicional = 1 + adicional + Constantes.EFETIVO_EXTRA;      //5%
       // System.out.println("Adcional = "+adicional);
        return salario *  adicional;
    }

    public void exibirFunc() {
        super.exibirFunc();
        System.out.println("Área: "+Area);

    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    
    
}

