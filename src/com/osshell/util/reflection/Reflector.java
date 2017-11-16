package com.osshell.util.reflection;

import java.net.URL;
import java.net.URLClassLoader;

public class Reflector extends URLClassLoader {
  public Reflector(URL[] urls) {
    super(urls);
  }
}