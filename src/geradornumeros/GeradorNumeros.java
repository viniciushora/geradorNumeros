/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package geradornumeros;
import java.io.File;
import java.util.Scanner;  
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *
 * @author Vinicius Corte
 */
public class GeradorNumeros {
    private static GeradorNumeros instance;
    
    private Integer ultimoNumero;
    
    public synchronized static GeradorNumeros getInstance(){
        if (instance == null){
            instance = new GeradorNumeros();
            instance.carregarNumero();
        }
        return instance;
    }
    
    private GeradorNumeros(){};
    
    private synchronized void carregarNumero(){
        try {
            File myObj = new File("./ultimonumero.txt");
            if (myObj.createNewFile()) {
              this.ultimoNumero = 999990101;
            } else {
              Scanner sc = new Scanner(myObj);
              String str = sc.nextLine();
              this.ultimoNumero = Integer.parseInt(str);
            }
        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
    }
    
    public synchronized void salvarArquivo(){
        try {
            FileWriter file = new FileWriter("./ultimonumero.txt");
            BufferedWriter out = new BufferedWriter(file);
            String s = String.valueOf(ultimoNumero);
            out.write(s);
            out.close();
        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
    }
    
    public synchronized Integer getNextNumero(){
        return ++ultimoNumero;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
