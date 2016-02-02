package com.shc;

import java.io.*;

/**
 * Created by uchaudh on 6/29/2015.
 */
public class EncodedJsonWriter {

    public static void main(String[] args)
    {
        try {
            File folder = new File("C:\\Users\\uchaudh\\Faulty Messages");
            File[] listOfFiles = folder.listFiles();

            for (File file : listOfFiles) {
                if (file.isFile()) {

                    FileInputStream fis = new FileInputStream(file);
                    InputStreamReader isr = new InputStreamReader(fis, "ISO-8859-1");
                    Reader in = new BufferedReader(isr);
                    File encodedFile = new File("C:\\Users\\uchaudh\\encoded_out\\" + file.getName());
                    FileOutputStream fos = new FileOutputStream(encodedFile);
                    OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
                    Writer out = new BufferedWriter(osw);
                    int ch;
                    while ((ch = in.read()) > -1) {
                        out.write(ch);
                    }
                    out.close();
                    in.close();
                }
            }
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }

    }

    /**
     * Method to Change Encoding
     * @param inputFile
     * @param encodingIn
     * @param outPutFile
     * @param encodingOut
     */
    public void changeEncoding(File inputFile, String encodingIn, File outPutFile, String encodingOut)
    {
        try {
            FileInputStream fis = new FileInputStream(inputFile);
            InputStreamReader isr = new InputStreamReader(fis, encodingIn);
            Reader in = new BufferedReader(isr);
            FileOutputStream fos = new FileOutputStream(outPutFile);
            OutputStreamWriter osw = new OutputStreamWriter(fos, encodingOut);
            Writer out = new BufferedWriter(osw);
            int ch;
            while ((ch = in.read()) > -1) {
                out.write(ch);
            }
            out.close();
            in.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }


}
