/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geradornumeros;

import javax.swing.JOptionPane;

/**
 *
 * @author Vinicius Corte
 */
public class EmpresaTelefonia {
    private static GeradorNumeros instance = GeradorNumeros.getInstance();

    
    public void gerarNumero(){
        String escolha = JOptionPane.showInputDialog("Gerar número? (s/n)");
        while(escolha.equalsIgnoreCase("s")) {
            System.out.println("Numero gerado: " + instance.getNextNumero());
            escolha = JOptionPane.showInputDialog("Gerar número? (s/n)");
        }
    }
    
    public void finalizar(){
        instance.salvarArquivo();
    }
}
