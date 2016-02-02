package com.shc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonParseException;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.mozilla.universalchardet.UniversalDetector;

import java.io.*;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by uchaudh on 6/22/2015.
 */
public class DynamicJsonParser {

    /**
     * Entry Point For Program
     * @param args
     */
    public static void main(String[] args) {
        try {
            File folder = new File("C:\\Users\\uchaudh\\json_data");
            File[] listOfFiles = folder.listFiles();

            for (File file : listOfFiles) {
                if (file.isFile()) {
                    File newDirectory = new File("C:\\Users\\uchaudh\\json_data\\flatten_out\\" + file.getName());
                    if (newDirectory.mkdir() == true)
                        System.out.println("Directory " + newDirectory.getAbsolutePath() + " Created Successfully!");
                    else
                        System.out.println("Error in Creating Directory");

//                FileInputStream fis= new FileInputStream(file);
//                byte[] buf = new byte[4096];
//                UniversalDetector detector = new UniversalDetector(null);
//
//                // (2)
//                int nread;
//                while ((nread = fis.read(buf)) > 0 && !detector.isDone()) {
//                    detector.handleData(buf, 0, nread);
//                }
//                // (3)
//                detector.dataEnd();
//
//                String encoding = detector.getDetectedCharset();
//                if (encoding != null)
//                    System.out.println("Detected encoding = " + encoding);
//                 else
//                    System.out.println("No encoding detected.");

                    ObjectMapper mapper = new ObjectMapper();
                    Map<String, Map<String, String>> map = mapper.readValue(file, Map.class);
                    for (String key : map.keySet()) {
                        Map<String, String> innerMap = map.get(key);
                        createFlattenFile(newDirectory.getAbsolutePath() + "\\" + key + ".txt", innerMap);
                    }
                }
            }

        } catch (IOException ex) {

            ex.printStackTrace();
        }
    }

    /**
     * Creates individual files for each segment
     * @param fName
     * @param innerMap
     */
    private static void createFlattenFile(String fName, Map<String,String> innerMap) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fName, true));
            for (String segmentIterator : innerMap.keySet()) {
                writer.write(segmentIterator + ": \t" + innerMap.get(segmentIterator) + "");
                writer.newLine();
            }
            writer.close();
        } catch (JsonParseException gex) {
            //System.out.println("Error In Writing File :"+ fName);
        } catch (IOException ioex) {

            //To Do
        }

    }

}
