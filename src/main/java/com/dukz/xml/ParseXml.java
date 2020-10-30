package com.dukz.xml;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.*;

/**
 * @author dukezheng
 * @ClassName ParseXml
 * @Description TODO
 * @date 2020/9/24 10:29
 * @Version 1.0
 */
public class ParseXml {

    public static void main(String[] args) throws DocumentException {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + "<params>\n"
            + "    <CBhAj>8CEC13DD08C7AEA198E0A460E7812791</CBhAj>\n" + "    <NAjlx></NAjlx>\n"
            + "    <CAjlx></CAjlx>\n" + "    <NJflx></NJflx>\n" + "    <NSjjn>0.01</NSjjn>\n"
            + "    <CJkrId></CJkrId>\n" + "    <CJkrmc></CJkrmc>\n" + "    <CJkrzjhm></CJkrzjhm>\n"
            + "    <NJnfs>6</NJnfs>\n" + "    <NFsjg></NFsjg>\n" + "    <CLy>7</CLy>\n"
            + "    <DTjksj>2020-09-23 16:08:36</DTjksj>\n" + "    <CDzph>2020092316083690425</CDzph>\n"
            + "    <CYyid></CYyid>\n" + "    <CYwxtJlid>0C03C367C632C74507C9717F2C767F39</CYwxtJlid>\n"
            + "    <CXtckh>2020092316083690425</CXtckh>\n" + "    <CShh></CShh>\n" + "    <CFyId>3900</CFyId>\n"
            + "    <CLxxs>\n" + "        <CLxx>\n" + "            <wslx>91</wslx>\n" + "            <wsmc>交费凭证</wsmc>\n"
            + "            <wsurl>\n"
            + "                http://156.0.0.119:8080/sfgk/pub/download.do?path=dzsd/wsjf20200923/6de1cccdfd07ec7aeea7a772f0cbe1c4/电子交费凭证.pdf\n"
            + "            </wsurl>\n" + "            <zfbz></zfbz>\n" + "            <wsgs>pdf</wsgs>\n"
            + "        </CLxx>\n" + "    </CLxxs>\n" + "</params>";

        Map<String, String> params = getConditionParam(xml);
        System.out.println(params);
        System.out.println("----------------------------");
        List<Map<String, String>> jfhzList = getJfhzList(xml);
        System.out.println(jfhzList);

        String CTaskId = params.get("CTaskId");
        System.err.println("CTaskId: "+CTaskId);
        String CBh = params.get("CBh");
        System.err.println("CBh: "+CBh);
        String NFsjg = params.get("NFsjg");
        System.err.println("NFsjg: "+NFsjg);
    }


    public static Map<String, String> getConditionParam(String conditionXml) throws DocumentException {

        if(StringUtils.isBlank(conditionXml)) {
            return Collections.emptyMap();
        }
        Map<String, String> paramMap = new HashMap<String, String>();
        // 解析参数 XML 字符串
        Document docParam = DocumentHelper.parseText(conditionXml);
        Element root = docParam.getRootElement();
        for (Iterator ele = root.elementIterator(); ele.hasNext();) {
            Element elem = (Element) ele.next();
            paramMap.put(elem.getName(), elem.getTextTrim());
        }
        return paramMap;
    }
    private static List<Map<String, String>> getJfhzList(String condition) throws DocumentException {
        if(StringUtils.isBlank(condition)) {
            return Collections.EMPTY_LIST;
        }
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        // 解析参数 XML 字符串
        Document docParam = DocumentHelper.parseText(condition);
        Element root = docParam.getRootElement();
        if(root.element("CLxxs") == null){
            return Collections.EMPTY_LIST;
        }
        List<Element> clxxList= root.element("CLxxs").elements("CLxx");
        for(Element clxx : clxxList){
            Map<String, String> paramMap = new HashMap<String, String>();
            for( Iterator it=clxx.elementIterator();it.hasNext();){
                Element ssclEle= (Element)it.next();
                paramMap.put(ssclEle.getName(), ssclEle.getTextTrim());
            }
            list.add(paramMap);
        }
        return list;
    }
}
