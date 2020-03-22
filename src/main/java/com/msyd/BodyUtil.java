package com.msyd;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: hfr
 * @Date: 2019-08-15 17:36
 * @Version 1.0
 */
public class BodyUtil {

    public static String genBody(String queryParam) {
        StringBuffer sb = new StringBuffer();
        sb.append("<body>");
        String[] params = queryParam.split("&");
        Map<String, Map<String, Map<String, String>>> keyvaluelist = new HashMap<String, Map<String, Map<String, String>>>();
        int serial = 0;
        for (String param : params) {
            String[] map = param.split("=");
            if (map[0].indexOf(".") != -1) {
                String[] all = map[0].split("\\.");
                Map<String, Map<String, String>> keyvalue = keyvaluelist.get(all[0]);
                if (keyvalue == null) {
                    keyvalue = new HashMap<String, Map<String, String>>();
                }
                Map<String, String> value = keyvalue.get(all[1] + "_" + serial);
                if (value == null) {
                    value = new HashMap<String, String>();
                }
                String valold = value.get(all[2]);
                if (valold != null) {
                    value = new HashMap<String, String>();
                    serial++;
                }
                value.put(all[2], map.length > 1 ? map[1] : "");
                keyvalue.put(all[1] + "_" + serial, value);
                keyvaluelist.put(all[0], keyvalue);
            } else {
                String key = map[0];
                String value = map.length > 1 ? map[1] : "";
                sb.append("<").append(key).append(">").append(value).append("</").append(key).append(">");
            }
        }
        if (keyvaluelist.size() > 0) {
            Set<String> keyvaluelistkeys = keyvaluelist.keySet();
            for (String keyvaluelistkey : keyvaluelistkeys) {
                sb.append("<").append(keyvaluelistkey).append(">");
                Map<String, Map<String, String>> keyvalues = keyvaluelist.get(keyvaluelistkey);
                Set<String> keyvaluekeys = keyvalues.keySet();
                for (String keyvaluekey : keyvaluekeys) {
                    String keyOri = keyvaluekey;
                    if (keyvaluekey.indexOf("_") != -1) {
                        keyvaluekey = keyvaluekey.split("_")[0];
                    }
                    sb.append("<").append(keyvaluekey).append(">");
                    Map<String, String> values = keyvalues.get(keyOri);
                    Set<String> valuekeys = values.keySet();
                    for (String valuekey : valuekeys) {
                        sb.append("<").append(valuekey).append(">");
                        sb.append(values.get(valuekey));
                        sb.append("</").append(valuekey).append(">");
                    }
                    sb.append("</").append(keyvaluekey).append(">");
                }
                sb.append("</").append(keyvaluelistkey).append(">");
            }
        }
        sb.append("</body>");
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "merPlatAcctAlias=null&protocolNo=null&bankName=&accountNo=6222021001138178881&accountName=孙李&accountType=00&openProvince=广\n" +
                "东&openCity=深圳&openName=null&tradeAmount=16091.27&currency=CNY&bsnType=09900&certType=null&certNo=null&mobileNo=null&prodInfo=null&msgExt=null&notifyUrl=null&callbackUrl=null&prodName=XINDAI_PA\n" +
                "Y&openBankUnionNo=null&productCode=null&test=666";
        System.out.println(BodyUtil.genBody(str));
    }

}