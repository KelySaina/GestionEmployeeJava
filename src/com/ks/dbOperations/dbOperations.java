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
    
    public TableModel listTravail(String numE, String annee){
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("N. Employee");
        model.addColumn("Nom");
        model.addColumn("Adresse");
        model.addColumn("Salaire");
        try{
            
            ResultSet rs = this.Connect().createStatement().executeQuery("select employee.numEmployee, employee.nomEmployee, employee.adresseEmployee, sum(travail.nbHeures*travail.tauxHoraire) as salaire from employee join travail on employee.numEmployee = travail.numEmployee where travail.numEntreprise = '"+numE+"' and year(travail.dateEmployee) like '%"+annee+"%' group by travail.numEmployee");
            
            while(rs.next()){
                Object[] row = new Object[4];
                row[0] = rs.getString("numEmployee");
                row[1] = rs.getString("nomEmployee");
                row[2] = rs.getString("adresseEmployee");
                row[3] = rs.getInt("salaire");
                model.addRow(row);
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return model;
        
    }
    
    public TableModel listAllTravail(String numE){
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("N. Employee");
        model.addColumn("Nom");
        model.addColumn("Adresse");
        model.addColumn("Salaire");
        try{
            
            ResultSet rs = this.Connect().createStatement().executeQuery("select employee.numEmployee, employee.nomEmployee, employee.adresseEmployee, sum(travail.nbHeures*travail.tauxHoraire) as salaire from employee join travail on employee.numEmployee = travail.numEmployee where travail.numEntreprise = '"+numE+"' group by travail.numEmployee");
            
            while(rs.next()){
                Object[] row = new Object[4];
                row[0] = rs.getString("numEmployee");
                row[1] = rs.getString("nomEmployee");
                row[2] = rs.getString("adresseEmployee");
                row[3] = rs.getInt("salaire");
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
    
    public boolean addTravail(String numE, String numS, int nbH, int tauxH, String dateE){
        try{
            
            ResultSet r = this.Connect().createStatement().executeQuery("select * from travail where numEmployee = '"+numE+"' and numEntreprise = '"+numS+"'");
            while(r.next()){
                return false;
            }
            
            PreparedStatement stmt = this.Connect().prepareStatement("insert into travail(numEmployee,numEntreprise, nbHeures, tauxHoraire,dateEmployee) values(?,?,?,?,?)");
            
            stmt.setString(1, numE);
            stmt.setString(2,numS);
            stmt.setInt(3, nbH);
            stmt.setInt(4,tauxH);
            stmt.setString(5, dateE);
            
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
    
    public boolean deleteTravail(String numE,String numS ){
        
        try{
            
            PreparedStatement stmt = this.Connect().prepareStatement("delete from travail where numEntreprise='"+numS+"' and numEmployee='"+numE+"'");
            
            int n = stmt.executeUpdate();    
            return true;
            
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
    
    public boolean updateTravail(String numE, String numS, int nbH, int tauxH, String dateE){
        
        try{
            
            PreparedStatement stmt = this.Connect().prepareStatement("update travail set numEmployee=?, numEntreprise=?, nbHeures=?, tauxHoraire=?, dateEmployee=?  where numEntreprise=? and numEmployee=?");
            stmt.setString(1, numE);
            stmt.setString(2,numS);
            stmt.setInt(3, nbH);
            stmt.setInt(4,tauxH);
            stmt.setString(5, dateE);
            stmt.setString(6, numS);
            stmt.setString(7, numE);
            
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
    
    public String getNomEntreprise(String numE){
        String nomE="";
        try{
            ResultSet r = this.Connect().createStatement().executeQuery("select nomEntreprise from entreprise where numEntreprise = '"+numE+"'");
            
            while(r.next()){
                nomE = r.getString("nomEntreprise");
            }        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
       return nomE;
    }
    
    public int getNbEmployee(String ne,String an){
        int nb=0;
        try{
            ResultSet r = this.Connect().createStatement().executeQuery("select count(numEmployee) as nb from travail where numEntreprise = '"+ne+"' and year(dateEmployee) like '%"+an+"%'");
            
            while(r.next()){
                nb = r.getInt("nb");
            }        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return nb;
    }
    
    public int getNbEmployee(String ne){
        int nb=0;
        try{
            ResultSet r = this.Connect().createStatement().executeQuery("select count(numEmployee) as nb from travail where numEntreprise = '"+ne+"'");
            
            while(r.next()){
                nb = r.getInt("nb");
            }        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return nb;
    }
    
    public int getSalaireTotal(String ne, String an){
        int st=0;
        try{
            ResultSet r = this.Connect().createStatement().executeQuery("select sum(tauxHoraire*nbHeures) as st from travail where numEntreprise = '"+ne+"' and year(dateEmployee) like '%"+an+"%'");
            
            while(r.next()){
                st = r.getInt("st");
            }        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return st;
    }
    
    public int getSalaireTotal(String ne){
        int st=0;
        try{
            ResultSet r = this.Connect().createStatement().executeQuery("select sum(tauxHoraire*nbHeures) as st from travail where numEntreprise = '"+ne+"'");
            
            while(r.next()){
                st = r.getInt("st");
            }        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return st;
    }
    
    public TableModel salaireGlob(String key){
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("N. Employee");
        model.addColumn("Nom");
        model.addColumn("Salaire");
        try{
            
            ResultSet rs = this.Connect().createStatement().executeQuery("select employee.numEmployee, employee.nomEmployee, sum(travail.tauxHoraire*travail.nbHeures) as salaire from employee join travail on employee.numEmployee = travail.numEmployee where year(travail.dateEmployee) like '%"+key+"%' group by travail.numEmployee");
            
            while(rs.next()){
                Object[] row = new Object[3];
                row[0] = rs.getString("numEmployee");
                row[1] = rs.getString("nomEmployee");
                row[2] = rs.getInt("salaire");
                model.addRow(row);
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return model;
        
    }
    public int getSalaireGlobTotal(String an){
        int st=0;
        try{
            ResultSet r = this.Connect().createStatement().executeQuery("select sum(tauxHoraire*nbHeures) as st from travail where year(dateEmployee) like '%"+an+"%'");
            
            while(r.next()){
                st = r.getInt("st");
            }        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return st;
    }
    public int getSalaireGlobTotal(){
        int st=0;
        try{
            ResultSet r = this.Connect().createStatement().executeQuery("select sum(tauxHoraire*nbHeures) as st from travail");
            
            while(r.next()){
                st = r.getInt("st");
            }        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return st;
    }
    
    public String getTravailDetails(String numE, String numS){
        String res = "";
        
        try{
            ResultSet r = this.Connect().createStatement().executeQuery("select numEmployee, nbHeures, tauxHoraire, dateEmployee from travail where numEmployee = '"+numE+"' and numEntreprise = '"+numS+"'");
            
            while(r.next()){
                res = r.getString("numEmployee")+","+r.getInt("nbHeures")+","+r.getInt("tauxHoraire")+","+r.getString("dateEmployee");                
            }        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return res;
    }
    
    public DefaultPieDataset getChartDataset(){
        
        DefaultPieDataset dataset = new DefaultPieDataset();
        try{
            
            ResultSet rs = this.Connect().createStatement().executeQuery("select employee.nomEmployee,SUM(travail.tauxHoraire*travail.nbHeures) as salaireEmployee from employee join travail on travail.numEmployee=employee.numEmployee group by travail.numEmployee");

            while(rs.next()){                
                dataset.setValue(rs.getString("nomEmployee")+" ("+rs.getInt("salaireEmployee")+"Fmg", rs.getInt("salaireEmployee"));            
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }        
        return dataset;        
    }
    
}
