package com.msy.travel.common;

import java.io.ByteArrayInputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JaxbUtil
{

 public static String encodeXml(Class c,Object o,String charsetname)throws Exception{
        
        //生成xml
        JAXBContext jb = JAXBContext.newInstance(c);
        Marshaller ma = jb.createMarshaller();
        ma.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        ma.setProperty(Marshaller.JAXB_ENCODING, charsetname);// 设置输出编码,默认为UTF-8
        ma.setProperty(Marshaller.JAXB_FRAGMENT, false);// 是否省略xml头信息
        StringWriter writer = new StringWriter();
        ma.marshal(o, writer);

        return writer.getBuffer().toString();
         
    }
    
    /**
     * jaxb解析xml
    *
    * @Title: decodeXml 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param responeStr
    * @param @param c
    * @param @return
    * @param @throws Exception    设定文件 
    * @return Object    返回类型 
    * @throws
     */
    public static Object decodeXml(String responeStr,Class c,String charsetname) throws Exception{
        
        ByteArrayInputStream is = new ByteArrayInputStream(
                responeStr.getBytes(charsetname));

        //解析xml
        JAXBContext jb = JAXBContext.newInstance(c);
        Unmarshaller u = jb.createUnmarshaller();
       
        return  u.unmarshal(is);
    }
    
}
