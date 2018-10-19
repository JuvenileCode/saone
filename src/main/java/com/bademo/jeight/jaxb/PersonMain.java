package com.bademo.jeight.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @Description
 * @Author Bin.Liu
 * @Date 2018/10/19 13:26
 */
public class PersonMain {

    public static void main(String[] args) throws Exception {
        modelOfXml();
        System.out.println("-------------------");
        xmlOfModel();
    }

    /**
     * modle转Xml
     *
     * @throws JAXBException
     */
    public static void modelOfXml() throws JAXBException {
        Person person = new Person();
        person.setFirstName("net");
        person.setLastName("blogways");
        person.setCity("NanJing");
        person.setPostalCode(210000);
        person.setDate(LocalDateTime.now());
        person.setListString(Arrays.asList("扰扰中原", "山河无主", "二三其位", "羊终马始"));

        //init jaxb marshaler
        JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        //设置格式化输出
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        /*将java对象 编组 为xml (输出到文件或标准输出)
         * jaxbMarshaller.marshal( spain, new File( "country.xml" ) );
         *  jaxbMarshaller.marshal( spain, System.out );
         * */
        //jaxbMarshaller.marshal(person,new PrintWriter(System.out));
        StringWriter str = new StringWriter();
        jaxbMarshaller.marshal(person, str);
        System.out.println(str.toString());
    }

    /**
     * xml转model
     * @throws JAXBException
     */
    public static void xmlOfModel() throws JAXBException {
        String xml ="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<person>\n" +
                "    <city>NanJing</city>\n" +
                "    <date>2018-10-19T14:35:42.656</date>\n" +
                "    <firstName>net</firstName>\n" +
                "    <lastName>blogways</lastName>\n" +
                "    <email_mqs_string_list>\n" +
                "        <mqs_string>扰扰中原</mqs_string>\n" +
                "        <mqs_string>山河无主</mqs_string>\n" +
                "        <mqs_string>二三其位</mqs_string>\n" +
                "        <mqs_string>羊终马始</mqs_string>\n" +
                "    </email_mqs_string_list>\n" +
                "    <postalCode>210000</postalCode>\n" +
                "</person>";

        JAXBContext jaxbContext = JAXBContext.newInstance( Person.class );
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Person countres = (Person)jaxbUnmarshaller.unmarshal(new StringReader(xml));
        System.out.println( countres );
    }
}
