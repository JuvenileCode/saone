package com.bademo.jeight.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

/**
 * @Description
 * @Author Bin.Liu
 * @Date 2018/10/26 15:06
 */
public class TextMsgMain {

    public static void main(String[] args) throws Exception{
        String xml ="<xml>\n" +
                "    <ToUserName>< ![CDATA[toUser] ]>\n" +
                "    </ToUserName>\n" +
                "    <FromUserName>< ![CDATA[fromUser] ]>\n" +
                "    </FromUserName>\n" +
                "    <CreateTime>1348831860</CreateTime>\n" +
                "    <MsgType>< ![CDATA[image] ]>\n" +
                "    </MsgType>\n" +
                "    <PicUrl>< ![CDATA[this is a url] ]>\n" +
                "    </PicUrl>\n" +
                "    <MediaId>< ![CDATA[media_id] ]>\n" +
                "    </MediaId>\n" +
                "    <MsgId>1234567890123456</MsgId>\n" +
                "</xml>";

        JAXBContext jaxbContext = JAXBContext.newInstance( TextMsg.class );
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        TextMsg countres = (TextMsg)jaxbUnmarshaller.unmarshal(new StringReader(xml));
        System.out.println( countres );
    }
}
