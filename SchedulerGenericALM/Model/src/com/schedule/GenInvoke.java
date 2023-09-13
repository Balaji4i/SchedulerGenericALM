package com.schedule;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.sql.DataSource;

public class GenInvoke {


    public synchronized void processData(SchedulePOJO sP) {

        Context ctx;
        Connection con = null;
        CallableStatement stmt = null, stmt1 = null;
        Statement stmt2 = null;
        ResultSet rs = null;
        List<SchedulePOJO> sPr = new ArrayList<SchedulePOJO>();
        sPr = getData(sP);

        for (SchedulePOJO r : sPr) {
            /****************************CHANGING STATUS TO RUNNING************************************/
            try {
                ctx = new InitialContext();
                DataSource ds = (DataSource)ctx.lookup(sP.getDbSrc());
                con = ds.getConnection();
                String query =
                    "UPDATE  XXFND_SCHEDULE_LIST_T " + "SET  SCHEDULE_STATUS = 'RUNNING'" +
                    "WHERE  SCHEDULE_STATUS= 'PENDING'" +
                    "and    SCHEDULE_NAME = '" + r.getSchdName() + "'";
                stmt2 = con.createStatement();
                int i1 = stmt2.executeUpdate(query);
            } catch (Exception e) {
                System.err.println("Exception in Update Running " + e);
            } finally {
                closeCon(rs, stmt2, stmt, stmt1, con);
            }

            try {
                GenInvokeN gi = new GenInvokeN();
                String temp = gi.invokeReport(r);
                if (temp != null) {
                    throw new Exception(temp);
                }

            } catch (Exception e) {
                /****************************CHANGING STATUS TO ERROR************************************/
                try {
                    ctx = new InitialContext();
                    DataSource ds = (DataSource)ctx.lookup(sP.getDbSrc());
                    con = ds.getConnection();
                    String query =
                        "UPDATE  XXFND_SCHEDULE_LIST_T " + "SET  SCHEDULE_STATUS = 'ERROR'," +
                        "ERROR_MESSAGE = '" + e.getMessage() + "'" +
                        //                    "ERROR_MESSAGE = '" + e + "'" +
                        "WHERE  SCHEDULE_STATUS= 'RUNNING'" +
                        "and    SCHEDULE_NAME = '" + r.getSchdName() + "'";
                    stmt2 = con.createStatement();
                    int i3 = stmt2.executeUpdate(query);
                } catch (Exception e1) {
                    System.err.println("Exception in Update ERROR " + e1);
                } finally {
                    closeCon(rs, stmt2, stmt, stmt1, con);
                }
            }

            /****************************CHANGING STATUS TO COMPLETED************************************/
            try {
                ctx = new InitialContext();
                DataSource ds = (DataSource)ctx.lookup(sP.getDbSrc());
                con = ds.getConnection();
                String query =
                    "UPDATE  XXFND_SCHEDULE_LIST_T " + "SET  SCHEDULE_STATUS = 'COMPLETED'" +
                    "WHERE  SCHEDULE_STATUS= 'RUNNING'" +
                    "and    SCHEDULE_NAME = '" + r.getSchdName() + "'";
                stmt2 = con.createStatement();
                int i2 = stmt2.executeUpdate(query);
            } catch (Exception e) {
                System.err.println("Exception in Update COMPLETED " + e);
            } finally {
                closeCon(rs, stmt2, stmt, stmt1, con);
            }

        }
    }


    public synchronized List<SchedulePOJO> getData(SchedulePOJO sP) {

        Context ctx;
        Connection con = null;
        CallableStatement stmt = null, stmt1 = null;
        Statement stmt2 = null;
        ResultSet rs = null;
        String val = null;
        List<SchedulePOJO> sPl = new ArrayList<SchedulePOJO>();
        try {
            ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup(sP.getDbSrc());
            con = ds.getConnection();
            stmt =
con.prepareCall("{call xxfnd_schedule_pkg.generate_schedule}");
            stmt.executeUpdate();

            String query =
                "SELECT  SCHEDULE_NAME, BI_REPORT_PATH, BI_REPORT_NAME, DB_REFRESH_PKG , LAST_REFRESH_TIME" +
                "                FROM XXFND_SCHEDULE_LIST_T" +
                "               WHERE  SCHEDULE_STATUS= 'PENDING'";
            stmt2 = con.createStatement();
            rs = stmt2.executeQuery(query);
            while (rs.next()) {
                if (rs.getString("LAST_REFRESH_TIME") == null) {
                    val = "01-01-2010 00:00:00";
                } else {
                    val =
new SimpleDateFormat("MM-dd-yyyy HH:mm:ss").format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("LAST_REFRESH_TIME")));
                }

                sPl.add(new SchedulePOJO(rs.getString("SCHEDULE_NAME"),
                                         rs.getString("BI_REPORT_PATH"),
                                         rs.getString("BI_REPORT_NAME"),
                                         rs.getString("DB_REFRESH_PKG"), val));
            }
        } catch (Exception e) {
            System.err.println("Exception in getData " + e);
            e.printStackTrace();
        } finally {
            closeCon(rs, stmt2, stmt, stmt1, con);
        }
        return sPl;
    }

    public void closeCon(ResultSet rs, Statement stmt2, CallableStatement stmt,
                         CallableStatement stmt1, Connection con) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt2 != null) {
                stmt2.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (stmt1 != null) {
                stmt1.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            System.err.println("Exception in Close Connection block " + e);
        }
    }
}
