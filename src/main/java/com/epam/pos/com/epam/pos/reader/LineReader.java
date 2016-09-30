package com.epam.pos.com.epam.pos.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class LineReader {
    private LineReader(){
    }

    public static String readString(){
        String result = null;
        BufferedReader inputStream = null;
        try{
            inputStream = new BufferedReader(new InputStreamReader(System.in));
            result = inputStream.readLine();
        } catch (IOException exception){
            exception.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException exception){
                exception.printStackTrace();
            }
        }
        return result;
    }

    public static int readNumber(){
        return Integer.parseInt(readString());
    }
}
