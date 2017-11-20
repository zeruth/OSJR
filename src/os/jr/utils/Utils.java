package os.jr.utils;

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

import os.jr.game.accessors.Client;
import os.jr.loader.Loader;
import os.jr.loader.RSAppletStub;
import os.jr.loader.Updater;

public class Utils {
	
	public static int size;

	public static void getParams() throws IOException {
		URL url = new URL(Loader.gameUrl);
		boolean init = false;
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		String line;
		List<String> params = new ArrayList<String>();
		while ((line = reader.readLine()) != null) {
			if (line.contains("param name")) {
				params.add(line);
				System.out.println(line);
			}
			if (!init) {
				if (Loader.gamepackURL== null) {
					if (line.contains("archive")) {

						Loader.gamepackURL = new URL(
								Loader.gameUrl + line.substring(line.indexOf("archive=") + 8, line.indexOf(" ');")));

						System.out.println(Loader.gamepackURL);
					}
				} else if (Loader.mainClass == null) {
					if (line.contains("code=")) {
						Loader.mainClass = line.substring(line.indexOf("code=") + 5, line.indexOf(".class"));
					}
				} else {
					init = true;
				}
			}
		}
		reader.close();
		for (String s : params) {
			RSAppletStub.parameters.put(getParamName(s), getParamValue(s));
		}
	}
	
	  public static int localGamePackSize() {
		    File file = new File(System.getProperty("user.home") + "/OSJR/gamepack.jar");
		    return (int) file.length();
		  }
	
	  /**
	   * getFileSize - Gets filesize of a given URL.
	   * @param url = URL to be sized.
	   * @return = filesize.
	   */
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
	
	  public static String getParamName(String param) {
	    try {
	      int startIndex = param.indexOf("<param name=\"") + 13;
	      int endIndex = param.indexOf("\" value");
	      return param.substring(startIndex, endIndex);
	    } catch (StringIndexOutOfBoundsException e) {
	      int startIndex = param.indexOf("<param name=") + 12;
	      int endIndex = param.indexOf(" value");
	      return param.substring(startIndex, endIndex);
	    }
	  }

	  /**
	   * getParamValue - Gets parameter's value.
	   * @param param - Parameter's identifier.
	   * @return = parameter.
	   */
	  public static String getParamValue(String param) {
	    try {
	      int startIndex = param.indexOf("value=\"") + 7;
	      int endIndex = param.indexOf("\">');");
	      return param.substring(startIndex, endIndex);
	    } catch (StringIndexOutOfBoundsException e) {
	      int startIndex = param.indexOf("value=") + 6;
	      int endIndex = param.indexOf(">');");
	      return param.substring(startIndex, endIndex);
	    }
	  }
	
	  public static void downloadGamePack() throws UnsupportedEncodingException, IOException {
		    BufferedInputStream in = null;
		    FileOutputStream out = null;
		    try {
		      URL url = Loader.gamepackURL;
		      URLConnection conn = url.openConnection();
		     size = conn.getContentLength();
		     Updater.maximum=size;
		      if (size < 0) {
		        System.out.println("Could not get the file size");
		      } else {
		        System.out.println("File size: " + size);
		      }            
		      File file = new File(System.getProperty("user.home") + "/OSJR/");
		      File file2 = new File(System.getProperty("user.home") + "/OSJR/gamepack.jar");
		      file.mkdir();
		      file2.createNewFile();
		      in = new BufferedInputStream(url.openStream());
		      out = new FileOutputStream(file2);
		      byte[] data = new byte[1024];
		      int count;
		      double sumCount = 0.0;
		      while ((count = in.read(data, 0, 1024)) != -1) {
		        out.write(data, 0, count);
		        sumCount += count;
		        if (size > 0) {
		          Updater.progress = (int) (sumCount);
		        }
		      }
		    } catch (MalformedURLException e1) {
		      e1.printStackTrace();
		    } catch (IOException e2) {
		      e2.printStackTrace();
		    } finally {
		      if (in != null) {
		        try {
		          in.close();
		        } catch (IOException e3) {
		          e3.printStackTrace();
		        }
		      }
		      if (out != null) {
		        try {
		          out.close();
		        } catch (IOException e4) {
		          e4.printStackTrace();
		        }
		      }       
		      SettingsIo.updateGamePackSize(size);
		    }
		  }
	
}
