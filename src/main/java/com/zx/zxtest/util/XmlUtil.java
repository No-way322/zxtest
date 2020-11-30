//package com.zx.zxtest.util;
//
//import com.alibaba.fastjson.JSONObject;
//import org.dom4j.Document;
//import org.dom4j.DocumentException;
//import org.dom4j.DocumentHelper;
//import org.dom4j.Element;
//import java.util.*;
//
//public class XmlUtil {
//    @SuppressWarnings("unchecked")
//    public static Map<String, Object> xml2Map(String xml) throws DocumentException{
//        Document doc = doc = DocumentHelper.parseText(xml);
//        Map<String, Object> map = new HashMap<String, Object>();
//        if (doc == null)
//            return map;
//        Element rootElement = doc.getRootElement();
//        element2Map(rootElement,map);
//        return map;
//    }
//
//    /**
//     *
//     */
//    @SuppressWarnings("unchecked")
//    public static void element2Map(Element element,Map<String,Object> parentMap){
//        //
//        if(element==null){
//            return;
//        }
//
//        String elementName=element.getName();
//        if(element.isTextOnly()){
//            parentMap.put(element.getName(),element.getText());
//        }else{
//            Map<String,Object> subMap=new HashMap<String,Object>();
//            List<Element> elementList=(List<Element>)element.elements();
//            for(Element subElement:elementList){
//                element2Map(subElement,subMap);
//            }
//            Object first=parentMap.get(elementName);
//            if(first==null){
//                parentMap.put(elementName,subMap);
//            }else{
//                if(first instanceof List<?>){
//                    ((List) first).add(subMap);
//                }else{
//                    List<Object> subMapList=new ArrayList<Object>();
//                    subMapList.add(first);
//                    subMapList.add(subMap);
//                    parentMap.put(elementName,subMapList);
//                }
//            }
//        }
//    }
//
//    /**
//     *
//     */
//    @SuppressWarnings("unchecked")
//    public static String map2Xml(Map<String,Object> map,String rootName){
//        Set<Map.Entry<String,Object>> entrySet=map.entrySet();
//        Document document=DocumentHelper.createDocument();
//        Element rootElement=document.addElement(rootName);
//        if(map==null){
//            return "";
//        }
//        map2Element(map,rootElement);
//        return rootElement.asXML();
//    }
//
//    /**
//     *
//     */
//    @SuppressWarnings("unchecked")
//    public static void map2Element(Map<String,Object> parentMap,Element parentElement){
//        if(parentMap==null){
//            return ;
//        }
//        Set<Map.Entry<String,Object>> entrySet = parentMap.entrySet();
//        for(Map.Entry<String,Object> entry:entrySet){
//            Object object=entry.getValue();
//            if(object instanceof Integer||object instanceof String||object instanceof Float||object instanceof Long||object instanceof Boolean||object instanceof Double){
//                Element subElement=parentElement.addElement(entry.getKey());
//                subElement.setText(entry.getValue().toString());
//            }else if (object instanceof Map){
//                Element subElement=parentElement.addElement(entry.getKey());
//                map2Element((Map<String, Object>) object,subElement);
//            }else if (object instanceof List){
//                for(Object object1:(List)object){
//                    Map<String,Object> subMap=(Map<String,Object>)object1;
//                    Element subElement=parentElement.addElement(entry.getKey());
//                    map2Element(subMap,subElement);
//                }
//            }
//        }
//    }
//
//    @SuppressWarnings("unchecked")
//    public static void main(String[] args) {
////        String xml="<PACKET>" +
////                "    <FAMILY>" +
////                "        <COLOR>red</COLOR>" +
////                "        <ADDRESS>绍兴兰亭</ADDRESS>" +
////                "    </FAMILY>" +
////                "    <MASTER_LIST>" +
////                "        <MASTER>" +
////                "            <NAME></NAME>" +
////                "            <CAT>" +
////                "                <COLOR>yellow</COLOR>" +
////                "            </CAT>" +
////                "            <CAT>\n" +
////                "                <COLOR>grey</COLOR>" +
////                "            </CAT>" +
////                "        </MASTER>" +
////                "        <MASTER>" +
////                "            <NAME>Baba</NAME>" +
////                "            <DOG>" +
////                "                <COLOR>black</COLOR>" +
////                "            </DOG>" +
////                "        </MASTER>" +
////                "        <MASTER>" +
////                "            <NAME>Son</NAME>" +
////                "            <RABBIT>" +
////                "                <COLOR>white</COLOR>" +
////                "            </RABBIT>" +
////                "        </MASTER>" +
////                "    </MASTER_LIST>" +
////                "</PACKET>";
//        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
//                "<root ver=\"1.0.0\" >\n" +
//                "    <element devtypename=\"站内-断路器\" keyid=\"40700002144\" assetid=\"PD_0305_138636804\" rdfid=\"PD_30500000_22619302\" pmsRdfid=\"PD_30500000_602359\" />\n" +
//                "    <element devtypename=\"柱上-断路器\" keyid=\"1350200014471\" assetid=\"PD_0111_634b10997aff8080815cd6d9fb015d6347e5cc6164\" rdfid=\"PD_201000044_76287066\" pmsRdfid=\"PD_11100000_361941\" />\n" +
//                "    <element devtypename=\"柱上-断路器\" keyid=\"1350200014470\" assetid=\"PD_0111_7160c10a52ff8080815f53a7dd015f715fab1f4dfe\" rdfid=\"PD_201000044_73624303\" pmsRdfid=\"PD_11100000_379166\" />\n" +
//                "</root>";
//        try {
//            // String xmlString = XmlUtil.map2Xml(requestJSon, "body");
//
//            Map map=xml2Map(xml);
//            JSONObject jsonObject=(JSONObject)JSONObject.toJSON(map);
//            System.out.println("jsonObject:"+jsonObject.toString());
////            map.toString();
////            ((Map)map.get("PACKET")).put("FAMILY",null);
////            String xml2=map2Xml(map,"body");
////            System.out.println(xml2);
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
