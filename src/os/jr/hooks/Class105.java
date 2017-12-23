package os.jr.hooks;

public class Class105 extends Node{
	
	public static final String payload = "paylaod";
	public static final String position = "position";
	public static final String bitPosition = "bitposition";
	public static final String blockSize0 = "blockSize0";
	public static final String blockSize1 = "blockSize1";
	public static final String codeBooks = "codeBooks";
	public static final String floors = "floors";
	public static final String residues = "residues";
	public static final String mappings = "mappings";
	public static final String modeBlockFlags = "modeBlockFlags";
	public static final String modeMappings = "modeMappings";

	public Class105() {
		super(Hooks.classNames.get("class105"));
	}
	
	public byte[] getPayload() {
		return (byte[]) getField(payload).getValue(reference);
	}
	
	public int getPosition() {
		return (int) getField(position).getValue(reference);
	}
	
	public int getBitPosition() {
		return (int) getField(bitPosition).getValue(reference);
	}
	
	public int getBlockSize0() {
		return (int) getField(blockSize0).getValue(reference);
	}
	
	public int getBlockSize1() {
		return (int) getField(blockSize1).getValue(reference);
	}
	
	public CodeBook[] getCodeBooks() {
		Object[] os = (Object[]) getField(codeBooks).getValue(reference);
		CodeBook[] codeBooks = new CodeBook[os.length];
 		int i = 0;
		for (Object o : os) {
			codeBooks[i] = new CodeBook(o);
			i++;
		}
		return codeBooks;
	}
	
	public Floor1[] getFloors() {
		Object[] os = (Object[]) getField(floors).getValue(reference);
		Floor1[] floors = new Floor1[os.length];
 		int i = 0;
		for (Object o : os) {
			floors[i] = new Floor1(o);
			i++;
		}
		return floors;
	}
	
	public Residue[] getResidues() {
		Object[] os = (Object[]) getField(residues).getValue(reference);
		Residue[] residues = new Residue[os.length];
 		int i = 0;
		for (Object o : os) {
			residues[i] = new Residue(o);
			i++;
		}
		return residues;
	}
	
	public Mapping[] getMappings() {
		Object[] os = (Object[]) getField(mappings).getValue(reference);
		Mapping[] mappings = new Mapping[os.length];
 		int i = 0;
		for (Object o : os) {
			mappings[i] = new Mapping(o);
			i++;
		}
		return mappings;
	}
	
	public boolean[] getModeBlockFlags() {
		return (boolean[]) getField(modeBlockFlags).getValue(reference);
	}
	
	public int[] getModeMappings() {
		return (int[]) getField(modeMappings).getValue(reference);
	}

}