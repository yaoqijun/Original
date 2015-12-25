package org.yqj.original.demo;

/**
 * Created by yaoqijun.
 * Date:2015-12-03
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class Demo {
    public static void main(String[] args) {
//        try {
//            Security.addProvider(new BouncyCastleProvider());
//            String encryptStr= "根据早先规划和RC候版的情况，这个版本主要在显卡驱动磁盘文件方面做了完善，包括默认启Intel Skylake第九代核显ntel其他核显小幅改进、初步开源支持AMD Fiji R9系列显卡、NVIDIA Nouveau DRM�?源驱动大幅度重写、VMware支持OpenGL 3.3、移除EXT3驱动、XFS/EXT4/F2FS文件系统大量修正等等";
//
//            //密钥字符串
//            String pubStr = "MFUwEwYHKoZIzj0CAQYIKoZIzj0DAQQDPgAEdWm4qAYlcpz/3irjz4KK5UsK+Eg4CHjPlQrLiJEKJifkC760U8mtLjY9Mb32TeaKPN8ZVSxu86Eovb6r";
//            String priStr = "MIGNAgEAMBMGByqGSM49AgEGCCqGSM49AwEEBHMwcQIBAQQeO6/9VI83Y46/MJyBlssmu5jaz2NIh+H/lLLjStlooAoGCCqGSM49AwEEoUADPgAEdWm4qAYlcpz/3irjz4KK5UsK+Eg4CHjPlQrLiJEKJifkC760U8mtLjY9Mb32TeaKPN8ZVSxu86Eovb6r";
//
//            //通过字符串的调用的方法一般用于临时密钥的情况,比如交易业务
//            String encodedData2 = CipherUtils.encrypt(encryptStr, pubStr);
//            String decodedData2 = CipherUtils.decrypt(encodedData2, priStr);
//            String outputStr2 = new String(decodedData2);
//            System.err.println("第一种方法:");
//            System.out.println("加密前: " + encryptStr);
//            System.out.println("加密后: " + encodedData2);
//            System.out.println("解密后: " + outputStr2);
//
//            //通过密钥字符串得到密钥
//            PublicKey pubKey = CipherUtils.getPublicKey(pubStr);
//            PrivateKey priKey = CipherUtils.getPrivateKey(priStr);
//
//            String encodedData3 = CipherUtils.encrypt(encryptStr, pubKey);
//            String decodedData3 = CipherUtils.decrypt(encodedData3, priKey);
//            String outputStr3 = new String(decodedData3);
//            System.err.println("第三种方法:");
//            System.out.println("加密前: " + encryptStr);
//            System.out.println("加密后: " + encodedData3);
//            System.out.println("解密后: " + outputStr3);
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
        System.out.println("test");
    }
}
