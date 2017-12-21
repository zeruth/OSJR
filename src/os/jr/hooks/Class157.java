package os.jr.hooks;

import java.io.File;

import os.jr.hooks.loader.GameClass;

public class Class157 extends GameClass{
	
	public static final String jagexClDat = "jagexClDat";
	public static final String idxCount = "idxCount";
	public static final String randomDat = "randomDat";
	public static final String dat2File = "dat2File";
	public static final String idx255File = "idx255File";
	public static final String idxFiles = "idxFiles";
	public static final String osNameLC = "osNameLC";

	public Class157() {
		super(Hooks.classNames.get("class157"));
	}
	
	public File getJagexClDat() {
		return (File) fields.get(jagexClDat).getValue(reference);
	}

	public int getIdxCount() {
		return (int) fields.get(idxCount).getValue(reference);
	}
	
	public CacheFile getRandomDat() {
		return new CacheFile(fields.get(randomDat).getValue(reference));
	}
	
	public CacheFile getDat2File() {
		return new CacheFile(fields.get(dat2File).getValue(reference));
	}
	
	public CacheFile getIdx255File() {
		return new CacheFile(fields.get(idx255File).getValue(reference));
	}
	
	public CacheFile[] getIdxFiles() {
		Object[] os = (Object[]) fields.get(idxFiles).getValue(reference);
		CacheFile[] idxFiles = new CacheFile[os.length];
		int i = 0;
		for (Object o : os) {
			idxFiles[i] = new CacheFile(o);
			i++;
		}
		return idxFiles;
	}
	
	public String getOsNameLC() {
		return (String) fields.get(osNameLC).getValue(reference);
	}
}