package com.osshell.util;

import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reflector extends URLClassLoader {

  private HashMap<String, FieldInfo> hookMap;
  
  public Reflector(URL[] urls) {
    super(urls);
  }
  
  public Field getField(String className, String fieldName) {
	try {
		return loadClass(className).getDeclaredField(fieldName);
	} catch (NoSuchFieldException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
  }

  public Object getFieldValue(String identifier) {
    FieldInfo f = hookMap.get(identifier);
    return getFieldValueByDetails(f.getClassName(), f.getFieldName());
  }

  /**
   * getFieldValueByDetails - Attemps to find a field's value based on className and fieldName.
   * @param className = Class name.
   * @param fieldName = Field name.
   * @return = FIeld's value if found, null otherwise.
   */
  public Object getFieldValueByDetails(String className, String fieldName) {
    Object o = null;
    try {
      Field field = loadClass(className).getDeclaredField(fieldName);
      field.setAccessible(true);
      return field.get(null);
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(Reflector.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalArgumentException ex) {
      Logger.getLogger(Reflector.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      Logger.getLogger(Reflector.class.getName()).log(Level.SEVERE, null, ex);
    } catch (NoSuchFieldException ex) {
      Logger.getLogger(Reflector.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SecurityException ex) {
      Logger.getLogger(Reflector.class.getName()).log(Level.SEVERE, null, ex);
    }
    return o;
  }

  public void setHooks(HashMap<String, FieldInfo> hookMap) {
    this.hookMap = hookMap;
  }
}