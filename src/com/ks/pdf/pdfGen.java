/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ks.pdf;
import java.io.FileOutputStream;
import java.io.OutputStream;
import javax.swing.JTable;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.Font;
import java.util.Random;


/**
 *
 * @author thyler
 */
public class pdfGen {
    
    public String genPdf(JTable table,String type) {
        int min = 1;
        int max = 10000;
        Random random = new Random();
        int randomNumber = random.nextInt(max - min + 1) + min;
        String name = "./generatedPDF/"+type+"/Table"+randomNumber+".pdf";
        
        
        try{
            Document document = new Document(PageSize.A4.rotate());
            
            OutputStream out = new FileOutputStream(name);

            PdfWriter.getInstance(document, out);
            document.open();
            
            Paragraph title = new Paragraph("Liste des "+type+"s\n\n",new Font(Font.FontFamily.HELVETICA, 22, Font.BOLD));
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            PdfPTable pdfTable = new PdfPTable(table.getColumnCount());

            // add table headers
            for (int i = 0; i < table.getColumnCount(); i++) {
                PdfPCell cell = new PdfPCell();
                Paragraph p = new com.itextpdf.text.Paragraph(table.getColumnName(i),new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD));
                cell.setPhrase(p);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfTable.addCell(cell);
            }

            // add table rows
            for (int i = 0; i < table.getRowCount(); i++) {
                for (int j = 0; j < table.getColumnCount(); j++) {
                    PdfPCell cell = new PdfPCell();
                    cell.setPhrase(new com.itextpdf.text.Paragraph(table.getValueAt(i, j).toString()));
                    pdfTable.addCell(cell);
                }
            }
            
            

            document.add(pdfTable);
            document.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return name;

    }
    
}
