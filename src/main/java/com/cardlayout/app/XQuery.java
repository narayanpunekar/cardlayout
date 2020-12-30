/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cardlayout.app;

import net.sf.saxon.xqj.SaxonXQDataSource;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;
import javax.xml.xquery.XQException;

/**
 *
 * @author narayan.punekar@yahoo.com
 */
public class XQuery {

    public void executeXQuery() {
        try {
            String strXQuery1 = new String();
            strXQuery1 = "for $xquery1 in /ProductBacklog/SNo "; 
            strXQuery1 = strXQuery1 + "return ";
            strXQuery1 = strXQuery1 + "<Last>{max($xquery1/@cnt)}</Last> ";

            XQDataSource xqds1 = new SaxonXQDataSource();
            XQConnection xqconn1 = xqds1.getConnection();
            XQPreparedExpression xqpe1 = xqconn1.prepareExpression(strXQuery1);
            XQResultSequence xqrs1 = xqpe1.executeQuery();
            while(xqrs1.next()) {
                System.out.println(xqrs1.getItemAsString(null));
            }
        } catch (XQException xqe) {
            xqe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
