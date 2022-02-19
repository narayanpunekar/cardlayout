/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cardlayout.app;

import java.util.StringTokenizer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;

//import net.sf.saxon.xqj.SaxonXQDataSource;

import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQStaticContext;

/**
 *
 * @author narayan.punekar@yahoo.com
 */
public class XQueryProcessor {

    public StringTokenizer executeXQuery(File fileXQuery) {
        try {
            String strXQueryRetVal = new String();
            StringTokenizer stXQueryRetVal = null;

            /*
            XQDataSource xqds = new SaxonXQDataSource();
            XQConnection xqconn = xqds.getConnection();
            */

            // Relative URIs are resolved against the base URI before invoking the entity resolver.
            // The relative URI 'ProductBacklog.xml' used in the query will be resolved against this URI.
            /*
            XQStaticContext ctx = xqconn.getStaticContext();
            ctx.setBaseURI(fileXQuery.toURI().toString());

            FileInputStream fis = new FileInputStream(fileXQuery);
            XQPreparedExpression xqpe = xqconn.prepareExpression(fis, ctx);
            fis.close();
            XQResultSequence xqrs = xqpe.executeQuery();
            while(xqrs.next()) {
                strXQueryRetVal += xqrs.getItemAsString(null);
            }
            stXQueryRetVal = new StringTokenizer(strXQueryRetVal);
            xqrs.close();
            xqpe.close();
            xqconn.close();
            */
            return stXQueryRetVal;
            /*
        } catch (XQException xqe) {
            xqe.printStackTrace();
            return null;
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
            return null;
            */
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        XQueryProcessor clsXqueryProcessor = new XQueryProcessor();

        File file1 = new File("xquery1.xq");
        System.out.println("XQuery1");
        StringTokenizer stXQueryRetVal1 = clsXqueryProcessor.executeXQuery(file1);
        while(stXQueryRetVal1.hasMoreTokens()){
            System.out.println(stXQueryRetVal1.nextToken());
        }
        System.out.println("");

        File file2 = new File("xquery2.xq");
        System.out.println("XQuery2");
        StringTokenizer stXQueryRetVal2 = clsXqueryProcessor.executeXQuery(file2);
        while(stXQueryRetVal2.hasMoreTokens()){
            System.out.println(stXQueryRetVal2.nextToken());
        }
        System.out.println("");

        File file3 = new File("xquery3.xq");
        System.out.println("XQuery3");
        StringTokenizer stXQueryRetVal3 = clsXqueryProcessor.executeXQuery(file3);
        while(stXQueryRetVal3.hasMoreTokens()){
            System.out.println(stXQueryRetVal3.nextToken());
        }
        System.out.println("");

        File file4 = new File("xquery4.xq");
        System.out.println("XQuery4");
        StringTokenizer stXQueryRetVal4 = clsXqueryProcessor.executeXQuery(file4);
        while(stXQueryRetVal4.hasMoreTokens()){
            System.out.println(stXQueryRetVal4.nextToken());
        }
        System.out.println("");
   }
}
