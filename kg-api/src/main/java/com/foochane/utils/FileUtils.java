package com.foochane.utils;

import java.io.*;

public class FileUtils {

    /**
     * 读取json文件，返回json字符串
     * @param fileName
     * @return
     */
    public static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);

            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


//        public static String readJsonFile(File file){
//
//            int len;
//            byte[] b = new byte[1024];
//            StringBuffer sb = new StringBuffer();
//
//
//            try {
//
//                FileInputStream fis = new FileInputStream(file);
//                while (( len= fis.read(b))!=-1) {
//                    sb.append(new String(b,0,len));//  len 每次读取的有效字节个数
//                }
//                fis.close();
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return sb.toString();
//        }

    public static String readJsonFile(File file){

        int b;
        StringBuffer sb = new StringBuffer();


        try {

            FileInputStream fis = new FileInputStream(file);
            Reader reader = new InputStreamReader(new FileInputStream(file),"utf-8");
            while (( b = reader.read())!=-1) {
                sb.append((char)b);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }


}
