/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.persistencia;

/**
 *
 * @author renna
 */

import java.util.logging.Level;
import java.util.logging.Logger;
import trabalho.modelo.Constantes;
import trabalho.modelo.Departamento;

import trabalho.modelo.Funcionario;
//Instanciar os funcionários aqui também?

public class DataBase {
    private Departamento departamentos [];
    public static final int MAX = Constantes.MAX_DEPT;
    private  int countDept;
    int i;

    public DataBase(){
        departamentos = new Departamento [MAX];
        this.countDept = 0;
    }

    public Departamento[] getDepartamentos() {
        return departamentos;
    }

    public int getNumDpts(){
        return countDept;
    }


    public void addDepts(Departamento dept){
        if(countDept < MAX){
            if(buscarDeptCodigo(dept.getCodigoDept()) == null && buscarDeptNome(dept.getNomeDept()) == null){
                departamentos[countDept] = dept;
                countDept++;
                System.out.println("("+countDept+")");
            }else{
                System.out.println("Código ou nome repetidos");
            }
        }else{
            System.out.println("Atingiu capacidade máxima");
        }
    }

    public Departamento buscarDeptNome(String nome){
        for(i = 0; i < countDept; i++){
            if(departamentos != null && departamentos[i].getNomeDept().equals(nome)){
               try{
                    return departamentos[i].clone();
               }catch (CloneNotSupportedException ex) {
                   Logger.getLogger(Departamento.class.getName()).log(Level.SEVERE, null, ex);
               } 
           
            }
        }
        return null;
    }

    public Departamento buscarDeptCodigo(String codigo){
      //  System.out.println("DB: "+getNumDpts());
        for(i = 0; i < countDept; i++){
            if(departamentos[i] != null && departamentos[i].getCodigoDept().equals(codigo)){
                try{
                    return departamentos[i].clone();
                }catch (CloneNotSupportedException ex) {
                    Logger.getLogger(Departamento.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
        return null;
    }


    public void addF_to_Dept(Funcionario f, Departamento dept){
        dept.addFunc(f);
    }


}


