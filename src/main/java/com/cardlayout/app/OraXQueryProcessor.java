/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cardlayout.app;

import static java.lang.System.out;

import java.util.StringTokenizer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;

import oracle.xml.xquery.OXQDataSource;
import oracle.xml.xquery.OXQConnection;
import oracle.xml.xquery.OXQView;
import oracle.xml.xquery.OXQEntityResolver;
import oracle.xml.xquery.OXQEntity;
import oracle.xml.xquery.OXQEntityKind;
import oracle.xml.xquery.OXQEntityLocator;
import oracle.xml.xquery.OXQEntityResolverRequestOptions;

//import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQStaticContext;

/**
 *
 * @author narayan.punekar@yahoo.com
 */
public class OraXQueryProcessor {

    private class clsEntityResolver extends OXQEntityResolver {
        @Override
        public OXQEntity resolveEntity(OXQEntityKind oxqek, OXQEntityLocator oxqel, OXQEntityResolverRequestOptions oxqr) throws XQException, IOException {
            if (oxqek == OXQEntityKind.DOCUMENT) {
                URI systemId = oxqel.getSystemIdAsURI();
                if ("file".equals(systemId.getScheme())) {
                    File file = new File(systemId);
                    FileInputStream input = new FileInputStream(file);
                    OXQEntity result = new OXQEntity(input);
                    result.enlistCloseable(input);
                    return result;
                }
            }
            return null;
        }
    }

    public StringTokenizer executeXQuery(File fileXQuery) {
        try {
            String strXQueryRetVal = new String();
            StringTokenizer stXQueryRetVal = null;

            OXQDataSource oxqds = new OXQDataSource();
            XQConnection xqconn = oxqds.getConnection();
            OXQConnection oxqconn = OXQView.getConnection(xqconn);
            oxqconn.setEntityResolver(new clsEntityResolver());

            //XQConnection xqconn = getConnection();
            // Relative URIs are resolved against the base URI before invoking the entity resolver.
            // The relative URI 'ProductBacklog.xml' used in the query will be resolved against this URI.
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
            return stXQueryRetVal;
        } catch (XQException xqe) {
            xqe.printStackTrace();
            return null;
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        OraXQueryProcessor clsOraXqueryProcessor = new OraXQueryProcessor();

        File file1 = new File("xquery1.xq");
        out.println("XQuery1");
        StringTokenizer stXQueryRetVal1 = clsOraXqueryProcessor.executeXQuery(file1);
        while(stXQueryRetVal1.hasMoreTokens()){
            out.println(stXQueryRetVal1.nextToken());
        }
        out.println("");

        File file2 = new File("xquery2.xq");
        out.println("XQuery2");
        StringTokenizer stXQueryRetVal2 = clsOraXqueryProcessor.executeXQuery(file2);
        while(stXQueryRetVal2.hasMoreTokens()){
            out.println(stXQueryRetVal2.nextToken());
        }
        out.println("");

        File file3 = new File("xquery3.xq");
        out.println("XQuery3");
        StringTokenizer stXQueryRetVal3 = clsOraXqueryProcessor.executeXQuery(file3);
        while(stXQueryRetVal3.hasMoreTokens()){
            out.println(stXQueryRetVal3.nextToken());
        }
        out.println("");

        File file4 = new File("xquery4.xq");
        out.println("XQuery4");
        StringTokenizer stXQueryRetVal4 = clsOraXqueryProcessor.executeXQuery(file4);
        while(stXQueryRetVal4.hasMoreTokens()){
            out.println(stXQueryRetVal4.nextToken());
        }
        out.println("");

        File file5 = new File("xquery5.xq");
        out.println("XQuery5");
        StringTokenizer stXQueryRetVal5 = clsOraXqueryProcessor.executeXQuery(file5);
        while(stXQueryRetVal5.hasMoreTokens()){
            out.println(stXQueryRetVal5.nextToken());
        }
        out.println("");

        File file6 = new File("xquery6.xq");
        out.println("XQuery6");
        StringTokenizer stXQueryRetVal6 = clsOraXqueryProcessor.executeXQuery(file6);
        while(stXQueryRetVal6.hasMoreTokens()){
            out.println(stXQueryRetVal6.nextToken());
        }
        out.println("");

        File file7 = new File("xquery7.xq");
        out.println("XQuery7");
        StringTokenizer stXQueryRetVal7 = clsOraXqueryProcessor.executeXQuery(file7);
        while(stXQueryRetVal7.hasMoreTokens()){
            out.println(stXQueryRetVal7.nextToken());
        }
        out.println("");

        File file8 = new File("xquery8.xq");
        out.println("XQuery8");
        StringTokenizer stXQueryRetVal8 = clsOraXqueryProcessor.executeXQuery(file8);
        while(stXQueryRetVal8.hasMoreTokens()){
            out.println(stXQueryRetVal8.nextToken());
        }
        out.println("");

        File file9 = new File("xquery9.xq");
        out.println("XQuery9");
        StringTokenizer stXQueryRetVal9 = clsOraXqueryProcessor.executeXQuery(file9);
        while(stXQueryRetVal9.hasMoreTokens()){
            out.println(stXQueryRetVal9.nextToken());
        }
        out.println("");
    }
}
