package com.schedule;

public class WsPayload {

    public synchronized String getPayload(SchedulePOJO sP) {

        String payload =
            "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:pub=\"http://xmlns.oracle.com/oxp/service/PublicReportService\">\n" +
            "   <soapenv:Header/>\n" +
            "   <soapenv:Body>\n" +
            "      <pub:runReport>\n" +
            "         <pub:reportRequest>\n" +
            "            <pub:parameterNameValues>\n" +
            "               <pub:item>\n" +
            "                  <pub:name>p_last_update_date</pub:name>\n" +
            "                  <pub:values>\n" +
            "                     <pub:item>" + sP.getParamVal() +
            "</pub:item>\n" +
            "                  </pub:values>\n" +
            "               </pub:item>\n" +
            "            </pub:parameterNameValues>\n" +
            "            <pub:reportAbsolutePath>/" + sP.getRptPath().trim() +
            "/" + sP.getRptName().trim() + ".xdo</pub:reportAbsolutePath>\n" +
            "         </pub:reportRequest>\n" +
            "         <pub:userID>" + sP.getUserName() + "</pub:userID>\n" +
            "         <pub:password>" + sP.getPassWord() +
            "</pub:password>\n" +
            "      </pub:runReport>\n" +
            "   </soapenv:Body>\n" +
            "</soapenv:Envelope>";

        return payload;
    }
}
