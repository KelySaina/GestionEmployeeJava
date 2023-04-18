/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ks.chart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author thyler
 */
public class chart {
    
    public JFreeChart createPieChart(String title, DefaultPieDataset dataset){
        JFreeChart chart = ChartFactory.createPieChart(title, dataset,true,true,false);
        return chart;
    }
    
}
