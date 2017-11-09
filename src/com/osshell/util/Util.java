package com.osshell.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import com.osshell.Loader;
import com.osshell.RSApplet;
import com.osshell.settings.SettingsIO;

public class Util {
	public static int size;

    public static void downloadGamePack() throws UnsupportedEncodingException, IOException {
        BufferedInputStream in = null;
        FileOutputStream out = null;

        try {
            URL url = new URL(RSApplet.GamePack.toString());
            URLConnection conn = url.openConnection();
            size = conn.getContentLength();

            if (size < 0) {
                System.out.println("Could not get the file size");
            } else {
                System.out.println("File size: " + size);
            }
            
            File file = new File(System.getProperty("user.home") + "/OSLite/");
            File file2 = new File(System.getProperty("user.home") + "/OSLite/gamepack.jar");
            file.mkdir();
            file2.createNewFile();

            in = new BufferedInputStream(url.openStream());
            out = new FileOutputStream(file2);
            byte data[] = new byte[1024];
            int count;
            double sumCount = 0.0;

            while ((count = in.read(data, 0, 1024)) != -1) {
                out.write(data, 0, count);

                sumCount += count;
                if (size > 0) {
                    Loader.progress=(int) (sumCount / size * 100.0);
                }
            }

        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            if (out != null)
                try {
                    out.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            
            SettingsIO.updateGamePackSize(size);
            Loader.init=true;
        }
    }
    
    public static String GetParamName(String param)
    {
        try{
            int StartIndex = param.indexOf("<param name=\"") + 13;
            int EndIndex = param.indexOf("\" value");
            return param.substring(StartIndex, EndIndex);
        }catch(StringIndexOutOfBoundsException e)//classic handles some differently so why not just catch it =P
        {
            int StartIndex = param.indexOf("<param name=") + 12;
            int EndIndex = param.indexOf(" value");
            return param.substring(StartIndex, EndIndex);
        }
    }

    public static String GetParamValue(String param)
    {
        try{
            int StartIndex = param.indexOf("value=\"") + 7;
            int EndIndex = param.indexOf("\">');");
            return param.substring(StartIndex, EndIndex);
        }catch(StringIndexOutOfBoundsException e)//and again :D
        {
            int StartIndex = param.indexOf("value=") + 6;
            int EndIndex = param.indexOf(">');");
            return param.substring(StartIndex, EndIndex);
        }
    }
    
    public static int getFileSize(URL url) {
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("HEAD");
            conn.getInputStream();
            return conn.getContentLength();
        } catch (IOException e) {
            return -1;
        } finally {
            conn.disconnect();
        }
    }
    
    public static void GetParams(URL url) throws IOException
    {
    	RSApplet.gameUrl=url.toString();
    	boolean init = false;
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        List<String> params = new ArrayList<String>();
        while((line = reader.readLine()) != null)
        {
            if(line.contains("param name")) {
                params.add(line);
                System.out.println(line);
            }
            
            if (!init) {
                if(RSApplet.GamePack == null) {
                    if(line.contains("archive")) {
                    	RSApplet.GamePack = new URL(RSApplet.gameUrl + line.substring(line.indexOf("archive=") + 8, line.indexOf(" ');")));
            			System.out.println(RSApplet.GamePack);
                    }
                }

                else if(RSApplet.MClass == null) {
                    if(line.contains("code="))
                    	RSApplet.MClass = line.substring(line.indexOf("code=") + 5, line.indexOf(".class"));
                }else {
                	init = true;
                }
            }
        }
        reader.close();

        for(String s : params)
        {
        	RSApplet.Parameters.put(GetParamName(s), GetParamValue(s));
        }
        System.out.println("Finished loading paramaters. Gamepack size: "+getFileSize(RSApplet.GamePack));
    }
    
    public static int checkLocalGamePack() {
    	File file = new File(System.getProperty("user.home") + "/OSLite/gamepack.jar");
		return (int) file.length();
    	
    }
}
