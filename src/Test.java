import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test {

//    public static void main(String[] args) {
//        try {
//            String url = "http://10.5.198.118:7777/eai_enu/start.swe?SWEExtSource=WebService&SWEExtCmd=Execute&WSSOAP=1";
//            URL obj = new URL(url);
//            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//            con.setRequestMethod("POST");
//            con.setRequestProperty("Content-Type","application/soap+xml; charset=utf-8");
//            String countryCode="Canada";
//            String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> " +
//                    "<soapenv:Envelope xmlns:soapenv=\\\"http://schemas.xmlsoap.org/soap/envelope/\\\" xmlns:cus=\\\"http://siebel.com/CustomUI\\\" xmlns:btf=\\\"http://www.siebel.com/xml/BTFLY%20UploadDocs%20Response%20IO\\\"> " +
//                        "<soapenv:Header xmlns:web=\\\"http://siebel.com/webservices\\\"> " +
//                            "<web:PasswordText>ESBUSER</web:PasswordText> " +
//                            "<web:UsernameToken>ESBUSER</web:UsernameToken> " +
//                    "</soapenv:Header> " +
//                    "<soapenv:Body> " +
//                        "<cus:UploadDocs_Input> " +
//                            "<btf:ListOfBtflyUploaddocsResponseIo> " +
//                                "<btf:Account> " +
//                                    "<btf:OrderNumber>1-36074946449</btf:OrderNumber> " +
//                                    "<btf:AccountId>1-32158717789</btf:AccountId> " +
//                                    "<btf:ListOfAccountAttachment> " +
//                                    "<btf:AccountAttachment> " +
//                                    "<btf:DocumentId>A1LDOIDX</btf:DocumentId> " +
//                                    "<btf:UploadedDate>09/08/2017</btf:UploadedDate> " +
//                                    "<btf:FileExt>pdf</btf:FileExt> " +
//                                    "<btf:FileName>File_By_Ashok</btf:FileName> " +
//                                    "<btf:AccntFileSize></btf:AccntFileSize> " +
//                                    "<btf:Category>POA</btf:Category> " +
//                                    "<btf:IssuingDate>08/22/2011</btf:IssuingDate> " +
//                                    "<btf:ExpiryDate>08/22/2025</btf:ExpiryDate> " +
//                                    "<btf:IssuingAuthority>Central Government Or State Government</btf:IssuingAuthority> " +
//                                    "<btf:IssuingPlace>Pune</btf:IssuingPlace> " +
//                                    "<btf:Reference>A1LDOIDX</btf:Reference> " +
//                                    "<btf:Type>Arms License</btf:Type> " +
//                                    "<btf:Attachment>JVBERi0xLjEKJcKlwrHDqwoKMSAwIG9iagogIDw8IC9UeXBlIC9DYXRhbG9nCiAgICAgL1BhZ2VzIDIgMCBSCiAgPj4KZW5kb2JqCgoyIDAgb2JqCiAgPDwgL1R5cGUgL1BhZ2VzCiAgICAgL0tpZHMgWzMgMCBSXQogICAgIC9Db3VudCAxCiAgICAgL01lZGlhQm94IFswIDAgMzAwIDE0NF0KICA+PgplbmRvYmoKCjMgMCBvYmoKICA8PCAgL1R5cGUgL1BhZ2UKICAgICAgL1BhcmVudCAyIDAgUgogICAgICAvUmVzb3VyY2VzCiAgICAgICA8PCAvRm9udAogICAgICAgICAgIDw8IC9GMQogICAgICAgICAgICAgICA8PCAvVHlwZSAvRm9udAogICAgICAgICAgICAgICAgICAvU3VidHlwZSAvVHlwZTEKICAgICAgICAgICAgICAgICAgL0Jhc2VGb250IC9UaW1lcy1Sb21hbgogICAgICAgICAgICAgICA+PgogICAgICAgICAgID4+CiAgICAgICA+PgogICAgICAvQ29udGVudHMgNCAwIFIKICA+PgplbmRvYmoKCjQgMCBvYmoKICA8PCAvTGVuZ3RoIDU1ID4+CnN0cmVhbQogIEJUCiAgICAvRjEgMTggVGYKICAgIDAgMCBUZAogICAgKEhlbGxvIFdvcmxkKSBUagogIEVUCmVuZHN0cmVhbQplbmRvYmoKCnhyZWYKMCA1CjAwMDAwMDAwMDAgNjU1MzUgZiAKMDAwMDAwMDAxOCAwMDAwMCBuIAowMDAwMDAwMDc3IDAwMDAwIG4gCjAwMDAwMDAxNzggMDAwMDAgbiAKMDAwMDAwMDQ1NyAwMDAwMCBuIAp0cmFpbGVyCiAgPDwgIC9Sb290IDEgMCBSCiAgICAgIC9TaXplIDUKICA+PgpzdGFydHhyZWYKNTY1CiUlRU9GCg==</btf:Attachment> " +
//                                    "</btf:AccountAttachment> " +
//                                    "</btf:ListOfAccountAttachment> " +
//                                "</btf:Account> " +
//                            "</btf:ListOfBtflyUploaddocsResponseIo> " +
//                        "</cus:UploadDocs_Input> " +
//                    "</soapenv:Body> " +
//                    "</soapenv:Envelope>";
//            con.setDoOutput(true);
//            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
//            wr.writeBytes(xml);
//            wr.flush();
//            wr.close();
//            String responseStatus = con.getResponseMessage();
//            System.out.println(responseStatus);
//            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//            String inputLine;
//            StringBuffer response = new StringBuffer();
//            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//            }
//            in.close();
//            System.out.println("response:" + response.toString());
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }


    public static void main(String[] args) {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("fileid", "ankit");
            JSONArray jsonArray = new JSONArray();
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put("attachment", jsonObject);
            String url = "http://10.5.213.40:8011/AuthorizeCredit/proxyservices/uploadDocument";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type","application/soap+xml; charset=utf-8");
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(String.valueOf(jsonObject1));
            wr.flush();
            wr.close();
            String responseStatus = con.getResponseMessage();
            System.out.println(responseStatus);
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println("response:" + response.toString());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
