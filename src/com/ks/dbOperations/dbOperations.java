/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ks.dbOperations;
import java.sql.*;
import javax.swing.table.*;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author thyler
 */
public class dbOperations {
    
    public Connection Connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/java";
            String username = "thyler";
            String password = "k";
            Connection conn = DriverManager.getConnection(url, username, password);
            
            return conn;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public TableModel listEntreprise(){
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Numero");
        model.addColumn("Nom");
        try{
            
            ResultSet rs = this.Connect().createStatement().executeQuery("select numEntreprise, nomEntreprise from entreprise order by numEntreprise asc");
            
            while(rs.next()){
                Object[] row = new Object[2];
                row[0] = rs.getString("numEntreprise");
                row[1] = rs.getString("nomEntreprise");
                model.addRow(row);
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return model;
        
    }
    
    public TableModel listEmployee(){
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Numero");
        model.addColumn("Nom");
        model.addColumn("Adresse");
        try{
            
            ResultSet rs = this.Connect().createStatement().executeQuery("select numEmployee, nomEmployee, adresseEmployee from employee order by numEmployee asc");
            
            while(rs.next()){
                Object[] row = new Object[3];
                row[0] = rs.getString("numEmployee");
                row[1] = rs.getString("nomEmployee");
                row[2] = rs.getString("adresseEmployee");
                model.addRow(row);
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return model;
        
    }
    
    public boolean addEntreprise(String num, String nom){
        
        try{
            
            PreparedStatement stmt = this.Connect().prepareStatement("insert into entreprise(numEntreprise,nomEntreprise) values(?,?)");
            
            stmt.setString(1, num);
            stmt.setString(2,nom);
            
            int n = stmt.executeUpdate();
            
            if(n>0){
                return true;
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
        
    }
    
    public boolean addEmployee(String num, String nom, String adr){
        
        try{
            
            PreparedStatement stmt = this.Connect().prepareStatement("insert into employee(numEmployee,nomEmployee, adresseEmployee) values(?,?,?)");
            
            stmt.setString(1, num);
            stmt.setString(2,nom);
            stmt.setString(3,adr);
            
            int n = stmt.executeUpdate();
            
            if(n>0){
                return true;
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
        
    }

    public boolean deleteEntreprise(String num){
        
        try{
            
            PreparedStatement stmt = this.Connect().prepareStatement("delete from entreprise where numEntreprise='"+num+"'");
            
            int n = stmt.executeUpdate();
            
            if(n>0){
                PreparedStatement stmt2 = this.Connect().prepareStatement("delete from travail where numEntreprise='"+num+"'");
            
                int k = stmt2.executeUpdate();
                
                return true;
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
        
    }
    
    public boolean deleteEmployee(String num){
        
        try{
            
            PreparedStatement stmt = this.Connect().prepareStatement("delete from employee where numEmployee='"+num+"'");
            
            int n = stmt.executeUpdate();
            
            if(n>0){
                PreparedStatement stmt2 = this.Connect().prepareStatement("delete from travail where numEmployee='"+num+"'");
            
                int k = stmt2.executeUpdate();
                
                return true;
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
        
    }
    
    public boolean updateEntreprise(String prevNum,String newNum,String newNom){
        
        try{
            
            PreparedStatement stmt = this.Connect().prepareStatement("update entreprise set numEntreprise=?, nomEntreprise=? where numEntreprise=?");
            stmt.setString(1, newNum);
            stmt.setString(2,newNom);
            stmt.setString(3,prevNum);
            
            int n = stmt.executeUpdate();
            
            if(n>0){
                return true;
            }    
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public boolean updateEmployee(String prevNum,String newNum,String newNom, String newAdr){
        
        try{
            
            PreparedStatement stmt = this.Connect().prepareStatement("update employee set numEmployee=?, nomEmployee=?, adresseEmployee=? where numEmployee=?");
            stmt.setString(1, newNum);
            stmt.setString(2,newNom);
            stmt.setString(3,newAdr);
            stmt.setString(4,prevNum);
            
            int n = stmt.executeUpdate();
            
            if(n>0){
                return true;
            }    
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public TableModel searchEntreprise(String key){
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Numero");
        model.addColumn("Nom");
        try{
            
            ResultSet rs = this.Connect().createStatement().executeQuery("select numEntreprise, nomEntreprise from entreprise where numEntreprise like '%"+key+"%' or nomEntreprise like '%"+key+"%' order by numEntreprise asc");
            
            while(rs.next()){
                Object[] row = new Object[2];
                row[0] = rs.getString("numEntreprise");
                row[1] = rs.getString("nomEntreprise");
                model.addRow(row);
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return model;
        
    }
    public TableModel searchEmployee(String key){
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Numero");
        model.addColumn("Nom");
        model.addColumn("Adresse");
        try{
            
            ResultSet rs = this.Connect().createStatement().executeQuery("select numEmployee, nomEmployee, adresseEmployee from employee where numEmployee like '%"+key+"%' or nomEmployee like '%"+key+"%' or adresseEmployee like '%"+key+"%' order by numEmployee asc");
            
            while(rs.next()){
                Object[] row = new Object[3];
                row[0] = rs.getString("numEmployee");
                row[1] = rs.getString("nomEmployee");
                row[2] = rs.getString("adresseEmployee");
                model.addRow(row);
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return model;
        
    }
    
    
    public boolean checkNumEntreprise(String num){
        try{
            ResultSet rs = this.Connect().createStatement().executeQuery("select numEntreprise from entreprise where numEntreprise='"+num+"'");
            
            if(rs.next()){
                return true;
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }        
        return false;
    }
    public boolean checkNumEmployee(String num){
        try{
            ResultSet rs = this.Connect().createStatement().executeQuery("select numEmployee from employee where numEmployee='"+num+"'");
            
            if(rs.next()){
                return true;
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }        
        return false;
    }
    
    public DefaultPieDataset getChartDataset(){
        
        DefaultPieDataset dataset = new DefaultPieDataset();
        try{
            
            ResultSet rs = this.Connect().createStatement().executeQuery("select employee.nomEmployee,SUM(travail.tauxHoraire*travail.nbHeures) as salaireEmployee from employee join travail on travail.numEmployee=employee.numEmployee group by travail.numEmployee");

            while(rs.next()){                
                dataset.setValue(rs.getString("nomEmployee")+" ("+rs.getInt("salaireEmployee")+"Ar)", rs.getInt("salaireEmployee"));            
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }        
        return dataset;        
    }
    
}
