package com.common.Basecode;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

//import com.modernmedia.mw.tag.Messages;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Crypt {
// --------------------------------------------------------------------------------------------
// 获得密钥
public SecretKey getKey(String s) throws Exception {
char[] ss = s.toCharArray();
String sss="";
    for(int i = 0;i<ss.length;i=i+2)
    {
    sss = sss + ss[i];
    }
SecretKeyFactory kf = SecretKeyFactory.getInstance("DES");
DESKeySpec ks = new DESKeySpec(sss.substring(0,8).getBytes());
SecretKey kd = kf.generateSecret(ks);
return kd;
}

// --------------------------------------------------------------------------------------------------
// 返回加密后的字符串
// key是用于生成密钥的字符串，input是要加密的字符串
public String getEncryptedString(String key, String input) {
String base64 = "";
try {
Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
cipher.init(Cipher.ENCRYPT_MODE, getKey(key));
byte[] inputBytes = input.getBytes("UTF8");
byte[] outputBytes = cipher.doFinal(inputBytes);
BASE64Encoder encoder = new BASE64Encoder();
base64 = encoder.encode(outputBytes);
} catch (Exception e) {
base64 = e.getMessage();
}
return base64;
}

// --------------------------------------------------------------------------------------------------
// 返回解密后的字符串
// key是用于生成密钥的字符串，input是要解密的字符串
public String getDecryptedString(String key, String input) {
String result = null;
try {
Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
cipher.init(Cipher.DECRYPT_MODE, getKey(key));
BASE64Decoder decoder = new BASE64Decoder();
byte[] raw = decoder.decodeBuffer(input);
byte[] stringBytes = cipher.doFinal(raw);
result = new String(stringBytes, "UTF8");
} catch (Exception e) {
result = e.getMessage();
}
return result;
}

public static void main(String[] args){
Crypt mycrypt = new Crypt();
try {
//SecretKey skey = mycrypt.getKey("g8TlgLEc6oqZxdwGe6pDiKB8Y");
String ss = mycrypt.getEncryptedString("6678912345678906", "胖子");
System.out.println("ss=="+ss);
String ss2 = mycrypt.getDecryptedString("6678912345678906",ss);
System.out.println("ss2=="+ss2);
} catch (Exception e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
}
//String ss = Messages.getString("SendToMemberTag.5");
//System.out.print(ss);