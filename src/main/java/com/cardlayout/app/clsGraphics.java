/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cardlayout.app;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;

/**
 *
 * @author narayan.punekar@yahoo.com
 */
public class clsGraphics extends Canvas {
    
    Color colorBlack = Color.black;
    Color colorRed = Color.red;
    Color colorGreen = Color.green;
    Color colorBlue = Color.blue;
    boolean flag = true;

    public void paint(Graphics g) {
        try {
            DocumentBuilderFactory dbFactory = null;
            DocumentBuilder documentBuilder = null;
            Document xmlDocumentPieChart = null;
            Document xmlDocument = null;
            dbFactory = DocumentBuilderFactory.newInstance();
            documentBuilder = dbFactory.newDocumentBuilder();
            xmlDocumentPieChart = documentBuilder.parse(new File("PieChartData.xml"));
            xmlDocument = documentBuilder.parse(new File("ProductBacklog.xml"));
            XPath xpath = XPathFactory.newInstance().newXPath();

            String strSolvedcnt = "/PieChartData/SolvedCnt[last()]";
            Double dSolvedcntVal = (Double)xpath.evaluate(strSolvedcnt, xmlDocumentPieChart, XPathConstants.NUMBER);
            int iSolvedCntVal = dSolvedcntVal.intValue();
        
            String strSolvednum = "/PieChartData/SolvedNum[last()]";
            Double dSolvednumVal = (Double)xpath.evaluate(strSolvednum, xmlDocumentPieChart, XPathConstants.NUMBER);
            int iSolvedNumVal = dSolvednumVal.intValue();

            String strSnocnt = "/ProductBacklog/SNo[last()]/@cnt";
            Double dSnocntVal = (Double)xpath.evaluate(strSnocnt, xmlDocument, XPathConstants.NUMBER);
            int iSnocntVal = dSnocntVal.intValue();

            double dMultiplier = 10.5;
            int iTotal = iSolvedCntVal + iSolvedNumVal + iSnocntVal;
            double dSolvedCntRect = ((double)iSolvedCntVal*100*dMultiplier)/(double)iTotal;
            double dSolvedNumRect = ((double)iSolvedNumVal*100*dMultiplier)/(double)iTotal;
            double dSnocntRect = ((double)iSnocntVal*100*dMultiplier)/(double)iTotal;
            
            //Color color = new Color(245,155,200);
            g.setColor(colorBlack);
            //X-axis
            g.drawLine(200, 490, 800, 490);
            //Y-axis
            g.drawLine(200, 490, 200, 100);

            g.setColor(colorRed);
            g.fill3DRect(200, 200, (int)dSnocntRect, 30, flag);
            g.drawString("Count = " + iSnocntVal, (int)dSnocntRect+300, 215);

            g.setColor(colorGreen);
            g.fill3DRect(200, 280, (int)dSolvedCntRect, 30, flag);
            g.drawString("Solved Num = " + iSolvedCntVal, (int)dSolvedCntRect+300, 295);

            g.setColor(colorBlue);
            g.fill3DRect(200, 360, (int)dSolvedNumRect, 30, flag);
            g.drawString("Solved Cnt = " + iSolvedNumVal, (int)dSolvedNumRect+300, 375);

            g.setColor(getForeground());
            g.drawString("Value", 100, 300);
        } catch(Exception ex1) {
            ex1.printStackTrace();
        } 
    }

    public static void main (String args[]) {
        clsGraphics cg = new clsGraphics();
        Frame frame = new Frame();
        frame.add(cg);
        frame.setVisible(true);
    }
    
}
