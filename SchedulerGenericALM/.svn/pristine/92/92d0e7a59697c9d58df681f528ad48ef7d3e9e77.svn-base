package view.backing;

import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichToolbar;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.nav.RichCommandToolbarButton;
import oracle.adf.view.rich.component.rich.output.RichPanelCollection;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.DialogEvent;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import Utils.JSFUtils;
import Utils.ADFUtils;

import com.schedule.SchedulePOJO;

import oracle.jbo.RowSetIterator;

import com.schedule.Scheduler;

import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.layout.RichGridCell;
import oracle.adf.view.rich.component.rich.layout.RichGridRow;
import oracle.adf.view.rich.component.rich.layout.RichPanelGridLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelLabelAndMessage;
import oracle.adf.view.rich.component.rich.nav.RichCommandImageLink;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.component.rich.output.RichSeparator;
import oracle.adf.view.rich.component.rich.output.RichSpacer;

import org.apache.myfaces.trinidad.event.AttributeChangeEvent;

public class ScheduleFrag {
    private RichTable t1;
    private RichPanelCollection pc1;
    private RichToolbar t2;
    private RichCommandToolbarButton ctb1;
    private RichCommandButton cb1;
    private RichCommandButton cb2;
    private RichInputText it9;
    private RichSpacer s1;
    private RichCommandToolbarButton ctb2;
    private RichPanelGroupLayout pgl2;
    private RichSeparator s2;
    private RichTable t3;
    private RichPanelCollection pc2;
    private RichSpacer s3;
    private RichCommandButton cb4;
    private RichPanelGroupLayout pgl3;
    private RichOutputText ot18;
    private RichSelectBooleanCheckbox sbc2;
    private RichCommandImageLink cil2;
    private RichCommandImageLink cil3;
    private RichCommandImageLink cil4;
    private RichSeparator s4;
    private RichSpacer s5;
    private RichSpacer s6;
    private RichSpacer s7;
    private RichSpacer s8;
    private RichPanelLabelAndMessage plam1;
    private RichOutputText ot19;
    private RichSpacer s9;
    private RichSpacer s10;
    private RichSpacer s11;
    private RichSeparator s12;
    private RichCommandToolbarButton ctb3;
    private RichPanelGroupLayout pgl4;
    private RichOutputText ot20;
    private RichSpacer s13;
    private RichPopup p1;
    private RichDialog d1;
    private RichPanelGroupLayout pgl1;
    private RichPanelGridLayout pgl5;
    private RichGridRow gr1;
    private RichGridCell gc1;
    private RichGridCell gc2;
    private RichGridRow gr2;
    private RichGridCell gc3;
    private RichGridCell gc4;
    private RichGridRow gr3;
    private RichGridCell gc5;
    private RichGridCell gc6;
    private RichInputText it11;
    private RichInputText it13;
    private RichInputText it12;
    private RichOutputText ot21;
    private RichOutputText ot22;
    private RichOutputText ot23;
    private RichInputText it14;
    private RichInputText it15;
    private RichInputText it16;


    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
    }

    public void setPc1(RichPanelCollection pc1) {
        this.pc1 = pc1;
    }

    public RichPanelCollection getPc1() {
        return pc1;
    }

    public void setT2(RichToolbar t2) {
        this.t2 = t2;
    }

    public RichToolbar getT2() {
        return t2;
    }

    public void setCtb1(RichCommandToolbarButton ctb1) {
        this.ctb1 = ctb1;
    }

    public RichCommandToolbarButton getCtb1() {
        return ctb1;
    }


    public void setCb1(RichCommandButton cb1) {
        this.cb1 = cb1;
    }

    public RichCommandButton getCb1() {
        return cb1;
    }

    public void setCb2(RichCommandButton cb2) {
        this.cb2 = cb2;
    }

    public RichCommandButton getCb2() {
        return cb2;
    }

    public void setIt9(RichInputText it9) {
        this.it9 = it9;
    }

    public RichInputText getIt9() {
        return it9;
    }

    SchedulePOJO sP = new SchedulePOJO();
    Scheduler st = new Scheduler();

    public void invoke(ActionEvent actionEvent) {

        String freqMin =
            getIt9().getValue() == null ? "null" : getIt9().getValue().toString();
        //        String pod =
        //            getIt11().getValue() == null ? "null" : getIt11().getValue().toString();
        //        String uname =
        //            getIt12().getValue() == null ? "null" : getIt12().getValue().toString();
        //        String pwd =
        //            getIt13().getValue() == null ? "null" : getIt13().getValue().toString();

        String pod =
            getIt14().getValue() == null ? "null" : getIt14().getValue().toString();
        String uname =
            getIt15().getValue() == null ? "null" : getIt15().getValue().toString();
        String pwd =
            getIt16().getValue() == null ? "null" : getIt16().getValue().toString();

        if (!freqMin.equals("null") && !freqMin.equals("0") &&
            !pod.equals("null") && !uname.equals("null") &&
            !pwd.equals("null")) {
            ViewObject vo =
                ADFUtils.findIterator("XxfndScheduleT_VO2Iterator").getViewObject();
            Long duration = Long.valueOf(freqMin);
            sP.setBackOff(duration);
            sP.setStopStat(false);
            sP.setPod(pod);
            sP.setUserName(uname);
            sP.setPassWord(pwd);
            RowSetIterator rs = vo.createRowSetIterator(null);
            while (rs.hasNext()) {
                Row r = rs.next();
                try {
                    r.setAttribute("RunStatus", "Y");
                    r.setAttribute("ScheduleName",
                                   r.getAttribute("ScheduleName"));
                    r.setAttribute("BiReportPath",
                                   r.getAttribute("BiReportPath"));
                    r.setAttribute("BiReportName",
                                   r.getAttribute("BiReportName"));
                    r.setAttribute("DbRefreshPkg",
                                   r.getAttribute("DbRefreshPkg"));
                    r.setAttribute("FrequencyMin",
                                   new Long(r.getAttribute("FrequencyMin").toString()));
                    r.setAttribute("Status", r.getAttribute("Status"));
                    r.getAttribute("ScheduleId");
                } catch (Exception e) {
                    System.err.println("Excpetion in rowset " + e);
                }
            }
            rs.closeRowSetIterator();

            RichCommandButton cb1 =
                (RichCommandButton)JSFUtils.findComponentInRoot("cb1");
            cb1.setDisabled(Boolean.TRUE);

            AdfFacesContext.getCurrentInstance().addPartialTarget(cb1);
            RichInputText it9 =
                (RichInputText)JSFUtils.findComponentInRoot("it9");
            it9.setDisabled(Boolean.TRUE);

            AdfFacesContext.getCurrentInstance().addPartialTarget(it9);
            RichTable t1 = (RichTable)JSFUtils.findComponentInRoot("t1");
            AdfFacesContext.getCurrentInstance().addPartialTarget(t1);

            ADFUtils.findOperation("Commit").execute();
            st.runSchedule(sP);
        } else {
            if (freqMin.equals("null")) {
                JSFUtils.addFacesErrorMessage("Back Off Duration is mandatory");
            }
            if (freqMin.equals("0")) {
                JSFUtils.addFacesErrorMessage("Back Off Duration should be greater than 0");
            }
            if (pod.equals("null")) {
                JSFUtils.addFacesErrorMessage("URL in Credentials is mandatory");
            }
            if (uname.equals("null")) {
                JSFUtils.addFacesErrorMessage("User Name in Credentials is mandatory");
            }
            if (pwd.equals("null")) {
                JSFUtils.addFacesErrorMessage("Password in Credentials is mandatory");
            }
        }
    }

    public void onStop(ActionEvent actionEvent) {

        ViewObject vo =
            ADFUtils.findIterator("XxfndScheduleT_VO2Iterator").getViewObject();

        /************ TO SET RUNSTATUS "N" ****************************/
        RowSetIterator rs = vo.createRowSetIterator(null);
        while (rs.hasNext()) {
            Row r = rs.next();
            r.setAttribute("RunStatus", "N");
        }
        rs.closeRowSetIterator();

        RichCommandButton cb1 =
            (RichCommandButton)JSFUtils.findComponentInRoot("cb1");
        cb1.setDisabled(Boolean.FALSE);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cb1);

        RichInputText it9 = (RichInputText)JSFUtils.findComponentInRoot("it9");
        it9.setDisabled(Boolean.FALSE);
        AdfFacesContext.getCurrentInstance().addPartialTarget(it9);


        RichTable t1 = (RichTable)JSFUtils.findComponentInRoot("t1");
        AdfFacesContext.getCurrentInstance().addPartialTarget(t1);

        ADFUtils.findOperation("Commit").execute();
        sP.setStopStat(true);
        st.runSchedule(sP);
    }

    public void onClickStat(ValueChangeEvent valueChangeEvent) {
        ViewObject vo =
            ADFUtils.findIterator("XxfndScheduleT_VO2Iterator").getViewObject();
        if (valueChangeEvent.getNewValue() != null &&
            valueChangeEvent.getNewValue().equals(Boolean.TRUE)) {
            RowSetIterator rs = vo.createRowSetIterator(null);
            while (rs.hasNext()) {
                Row r = rs.next();
                r.setAttribute("Status", "Y");
            }
            rs.closeRowSetIterator();
        }
        if (valueChangeEvent.getNewValue() != null &&
            valueChangeEvent.getNewValue().equals(Boolean.FALSE)) {
            RowSetIterator rs = vo.createRowSetIterator(null);
            while (rs.hasNext()) {
                Row r = rs.next();
                r.setAttribute("Status", "N");
            }
            rs.closeRowSetIterator();
        }

        RichTable t1 = (RichTable)JSFUtils.findComponentInRoot("t1");
        AdfFacesContext.getCurrentInstance().addPartialTarget(t1);
    }


    public void setS1(RichSpacer s1) {
        this.s1 = s1;
    }

    public RichSpacer getS1() {
        return s1;
    }

    public void setCtb2(RichCommandToolbarButton ctb2) {
        this.ctb2 = ctb2;
    }

    public RichCommandToolbarButton getCtb2() {
        return ctb2;
    }

    public void setPgl2(RichPanelGroupLayout pgl2) {
        this.pgl2 = pgl2;
    }

    public RichPanelGroupLayout getPgl2() {
        return pgl2;
    }

    public void setS2(RichSeparator s2) {
        this.s2 = s2;
    }

    public RichSeparator getS2() {
        return s2;
    }

    public void setT3(RichTable t3) {
        this.t3 = t3;
    }

    public RichTable getT3() {
        return t3;
    }

    public void setPc2(RichPanelCollection pc2) {
        this.pc2 = pc2;
    }

    public RichPanelCollection getPc2() {
        return pc2;
    }

    public void setS3(RichSpacer s3) {
        this.s3 = s3;
    }

    public RichSpacer getS3() {
        return s3;
    }

    public void setCb4(RichCommandButton cb4) {
        this.cb4 = cb4;
    }

    public RichCommandButton getCb4() {
        return cb4;
    }


    public void setPgl3(RichPanelGroupLayout pgl3) {
        this.pgl3 = pgl3;
    }

    public RichPanelGroupLayout getPgl3() {
        return pgl3;
    }


    public void setOt18(RichOutputText ot18) {
        this.ot18 = ot18;
    }

    public RichOutputText getOt18() {
        return ot18;
    }

    public void setSbc2(RichSelectBooleanCheckbox sbc2) {
        this.sbc2 = sbc2;
    }

    public RichSelectBooleanCheckbox getSbc2() {
        return sbc2;
    }


    public void setCil2(RichCommandImageLink cil2) {
        this.cil2 = cil2;
    }

    public RichCommandImageLink getCil2() {
        return cil2;
    }

    public void setCil3(RichCommandImageLink cil3) {
        this.cil3 = cil3;
    }

    public RichCommandImageLink getCil3() {
        return cil3;
    }

    public void setCil4(RichCommandImageLink cil4) {
        this.cil4 = cil4;
    }

    public RichCommandImageLink getCil4() {
        return cil4;
    }

    public void setS4(RichSeparator s4) {
        this.s4 = s4;
    }

    public RichSeparator getS4() {
        return s4;
    }

    public void setS5(RichSpacer s5) {
        this.s5 = s5;
    }

    public RichSpacer getS5() {
        return s5;
    }

    public void setS6(RichSpacer s6) {
        this.s6 = s6;
    }

    public RichSpacer getS6() {
        return s6;
    }

    public void setS7(RichSpacer s7) {
        this.s7 = s7;
    }

    public RichSpacer getS7() {
        return s7;
    }

    public void setS8(RichSpacer s8) {
        this.s8 = s8;
    }

    public RichSpacer getS8() {
        return s8;
    }

    public void setPlam1(RichPanelLabelAndMessage plam1) {
        this.plam1 = plam1;
    }

    public RichPanelLabelAndMessage getPlam1() {
        return plam1;
    }

    public void setOt19(RichOutputText ot19) {
        this.ot19 = ot19;
    }

    public RichOutputText getOt19() {
        return ot19;
    }

    public void setS9(RichSpacer s9) {
        this.s9 = s9;
    }

    public RichSpacer getS9() {
        return s9;
    }

    public void setS10(RichSpacer s10) {
        this.s10 = s10;
    }

    public RichSpacer getS10() {
        return s10;
    }

    public void setS11(RichSpacer s11) {
        this.s11 = s11;
    }

    public RichSpacer getS11() {
        return s11;
    }

    public void setS12(RichSeparator s12) {
        this.s12 = s12;
    }

    public RichSeparator getS12() {
        return s12;
    }

    public void setCtb3(RichCommandToolbarButton ctb3) {
        this.ctb3 = ctb3;
    }

    public RichCommandToolbarButton getCtb3() {
        return ctb3;
    }

    public void setPgl4(RichPanelGroupLayout pgl4) {
        this.pgl4 = pgl4;
    }

    public RichPanelGroupLayout getPgl4() {
        return pgl4;
    }

    public void setOt20(RichOutputText ot20) {
        this.ot20 = ot20;
    }

    public RichOutputText getOt20() {
        return ot20;
    }

    public void setS13(RichSpacer s13) {
        this.s13 = s13;
    }

    public RichSpacer getS13() {
        return s13;
    }

    public void setP1(RichPopup p1) {
        this.p1 = p1;
    }

    public RichPopup getP1() {
        return p1;
    }

    public void setD1(RichDialog d1) {
        this.d1 = d1;
    }

    public RichDialog getD1() {
        return d1;
    }


    public void setPgl1(RichPanelGroupLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichPanelGroupLayout getPgl1() {
        return pgl1;
    }


    public void setPgl5(RichPanelGridLayout pgl5) {
        this.pgl5 = pgl5;
    }

    public RichPanelGridLayout getPgl5() {
        return pgl5;
    }

    public void setGr1(RichGridRow gr1) {
        this.gr1 = gr1;
    }

    public RichGridRow getGr1() {
        return gr1;
    }

    public void setGc1(RichGridCell gc1) {
        this.gc1 = gc1;
    }

    public RichGridCell getGc1() {
        return gc1;
    }

    public void setGc2(RichGridCell gc2) {
        this.gc2 = gc2;
    }

    public RichGridCell getGc2() {
        return gc2;
    }

    public void setGr2(RichGridRow gr2) {
        this.gr2 = gr2;
    }

    public RichGridRow getGr2() {
        return gr2;
    }

    public void setGc3(RichGridCell gc3) {
        this.gc3 = gc3;
    }

    public RichGridCell getGc3() {
        return gc3;
    }

    public void setGc4(RichGridCell gc4) {
        this.gc4 = gc4;
    }

    public RichGridCell getGc4() {
        return gc4;
    }

    public void setGr3(RichGridRow gr3) {
        this.gr3 = gr3;
    }

    public RichGridRow getGr3() {
        return gr3;
    }

    public void setGc5(RichGridCell gc5) {
        this.gc5 = gc5;
    }

    public RichGridCell getGc5() {
        return gc5;
    }

    public void setGc6(RichGridCell gc6) {
        this.gc6 = gc6;
    }

    public RichGridCell getGc6() {
        return gc6;
    }


    public void setIt11(RichInputText it11) {
        this.it11 = it11;
    }

    public RichInputText getIt11() {
        return it11;
    }

    public void setIt13(RichInputText it13) {
        this.it13 = it13;
    }

    public RichInputText getIt13() {
        return it13;
    }

    public void setIt12(RichInputText it12) {
        this.it12 = it12;
    }

    public RichInputText getIt12() {
        return it12;
    }

    public void setOt21(RichOutputText ot21) {
        this.ot21 = ot21;
    }

    public RichOutputText getOt21() {
        return ot21;
    }

    public void setOt22(RichOutputText ot22) {
        this.ot22 = ot22;
    }

    public RichOutputText getOt22() {
        return ot22;
    }

    public void setOt23(RichOutputText ot23) {
        this.ot23 = ot23;
    }

    public RichOutputText getOt23() {
        return ot23;
    }

    public void setIt14(RichInputText it14) {
        this.it14 = it14;
    }

    public RichInputText getIt14() {
        return it14;
    }

    public void setIt15(RichInputText it15) {
        this.it15 = it15;
    }

    public RichInputText getIt15() {
        return it15;
    }

    public void setIt16(RichInputText it16) {
        this.it16 = it16;
    }

    public RichInputText getIt16() {
        return it16;
    }

    public void callCommitM() {
        ADFUtils.findOperation("callCommit").execute();
    }

    public void onClckOk(DialogEvent dialogEvent) {
        if (dialogEvent.getOutcome() == DialogEvent.Outcome.ok) {
//            ViewObject vo =
//                ADFUtils.findIterator("XxpmSetupDetailVO1Iterator").getViewObject();
//            RowSetIterator rsi = vo.createRowSet(null);
//            Row r = rsi.first();
            callCommitM();
        }
    }
}
