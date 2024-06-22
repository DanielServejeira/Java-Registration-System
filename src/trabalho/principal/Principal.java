/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabalho.principal;

import java.util.Scanner;
import trabalho.principal.Sistema;
/**
 *
 * @author renna
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
        Sistema sistema = new Sistema();
        Scanner sc = new Scanner(System.in);
        sistema.executar(sc);
    
    }
    
}
