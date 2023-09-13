package com.schedule;


public class SchedulePOJO {
    long freqMin;
    String schdName;
    //    static String prgmName;
    String rptPath;
    String rptName;
    String rfshPkg;
    static String stat;
    String paramVal;
    static boolean stopStat;
    static long backOff;
    static String userName ;//= "snagarajan@emsmobile.com"; //"PA.EHS";
    static String passWord ;//= "Dubai123"; //"welcome@1234";
    static String dbSrc = "jdbc/prism";
    static String pod;
    

    public SchedulePOJO() {
    }

    public SchedulePOJO(String schdName, String rptPath, String rptName,
                        String rfshPkg, String paramVal) {
        this.schdName = schdName;
        this.rptPath = rptPath;
        this.rptName = rptName;
        this.rfshPkg = rfshPkg;
        //        this.freqMin = freqMin;
        this.paramVal = paramVal;
    }


    public void setFreqMin(long freqMin) {
        this.freqMin = freqMin;
    }

    public long getFreqMin() {
        return freqMin;
    }

    public void setSchdName(String schdName) {
        this.schdName = schdName;
    }

    public String getSchdName() {
        return schdName;
    }

    public void setRptPath(String rptPath) {
        this.rptPath = rptPath;
    }

    public String getRptPath() {
        return rptPath;
    }

    public void setRptName(String rptName) {
        this.rptName = rptName;
    }

    public String getRptName() {
        return rptName;
    }

    public void setRfshPkg(String rfshPkg) {
        this.rfshPkg = rfshPkg;
    }

    public String getRfshPkg() {
        return rfshPkg;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setParamVal(String paramVal) {
        this.paramVal = paramVal;
    }

    public String getParamVal() {
        return paramVal;
    }

    public static void setStopStat(boolean stopStat) {
        SchedulePOJO.stopStat = stopStat;
    }

    public static boolean isStopStat() {
        return stopStat;
    }

    public static void setDbSrc(String dbSrc) {
        SchedulePOJO.dbSrc = dbSrc;
    }

    public static String getDbSrc() {
        return dbSrc;
    }

    public static void setStat(String stat) {
        SchedulePOJO.stat = stat;
    }

    public static String getStat() {
        return stat;
    }

    public static void setBackOff(long backOff) {
        SchedulePOJO.backOff = backOff;
    }

    public static long getBackOff() {
        return backOff;
    }

    public static void setPod(String pod) {
        SchedulePOJO.pod = pod;
    }

    public static String getPod() {
        return pod;
    }
}
