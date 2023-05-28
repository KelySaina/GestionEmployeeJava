/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionemployee;
import com.ks.ui.dashboardUI;
import com.ks.pdf.createDirectories;

/**
 *
 * @author thyler
 */
public class GestionEmployee {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        createDirectories c = new createDirectories();
        c.create("./generatedPDF");
        c.create("./generatedPDF/Employee");
        c.create("./generatedPDF/Entreprise");
        c.create("./generatedPDF/Travail");
        new dashboardUI().setVisible(true);
    }
    
}
