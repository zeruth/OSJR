package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class DState extends RSClass {
	
	public static final String urlRequester = "urlRequester";
	public static final String strm = "strm";
	public static final String next_in = "next_in";
	public static final String total_out_lo32 = "total_out_lo32";
	public static final String out = "out";
	public static final String next_out = "next_out";
	public static final String total_out_hi32 = "total_out_hi32";
	public static final String out_ch = "out_ch";
	public static final String out_len = "out_len";
	public static final String total_in_hi32 = "total_in_hi32";
	public static final String total_in_lo32 = "total_in_lo32";
	public static final String blockSize100k = "blockSize100k";
	public static final String tPos = "tPos";
	public static final String k0 = "k0";
	public static final String nblock_used = "nblock_used";
	public static final String nInUse = "nInUse";
	public static final String inUse = "inUse";
	public static final String seqToUnseq = "seqToUnseq";

	public DState(Object reference) {
		super(Hooks.classNames.get("DState"));
		this.reference = reference;
	}
	
	public UrlRequester getUrlRequester() {
		return new UrlRequester(getField(urlRequester).getValue(reference));
	}
	
	public Byte[] getStrm() {
		return (Byte[]) getField(strm).getValue(reference);
	}
	
	public int getNext_in() {
		return (int) getField(next_in).getValue(reference);
	}
	
	public int getTotal_out_lo32() {
		return (int) getField(total_out_lo32).getValue(reference);
	}
	
	public Byte[] getOut() {
		return (Byte[]) getField(out).getValue(reference);
	}
	
	public int getNext_out() {
		return (int) getField(next_out).getValue(reference);
	}
	
	public int getTotal_out_hi32() {
		return (int) getField(total_out_hi32).getValue(reference);
	}
	
	public Byte getOut_ch() {
		return (Byte) getField(out_ch).getValue(reference);
	}
	
	public int getOut_len() {
		return (int) getField(out_len).getValue(reference);
	}
	
	public int getTotal_in_hi32() {
		return (int) getField(total_in_hi32).getValue(reference);
	}
	
	public int getTotal_in_lo32() {
		return (int) getField(total_in_lo32).getValue(reference);
	}
	
	public int getBlockSize100k() {
		return (int) getField(blockSize100k).getValue(reference);
	}
	
	public int getTPos() {
		return (int) getField(tPos).getValue(reference);
	}
	
	public int getK0() {
		return (int) getField(k0).getValue(reference);
	}
	
	public int getNblock_used() {
		return (int) getField(nblock_used).getValue(reference);
	}
	
	public int getNInUse() {
		return (int) getField(nInUse).getValue(reference);
	}
	
	public boolean[] getInUse() {
		return (boolean[]) getField(inUse).getValue(reference);
	}
	
	
	public Byte[] getSeqToUnseq() {
		return (Byte[]) getField(seqToUnseq).getValue(reference);
	}
}
