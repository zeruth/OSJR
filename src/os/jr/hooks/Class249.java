package os.jr.hooks;

import os.jr.hooks.loader.RSClass;

public class Class249 extends RSClass{
	
	public static final String NetCache_socket = "NetCache_socket";
	public static final String NetCache_pendingPriorityWrites = "NetCache_pendingPriorityWrites";
	public static final String NetCache_pendingPriorityWritesCount = "NetCache_pendingPriorityWritesCount";
	public static final String NetCache_pendingPriorityResponses = "NetCache_pendingPriorityResponses";
	public static final String NetCache_pendingPriorityResponsesCount = "NetCache_pendingPriorityResponsesCount";
	public static final String NetCache_pendingWritesQueue = "NetCache_pendingWritesQueue";
	public static final String NetCache_pendingWrites = "NetCache_pendingWrites";
	public static final String NetCache_pendingWritesCount = "NetCache_pendingWritesCount";
	public static final String NetCache_pendingResponses = "NetCache_pendingResponses";
	public static final String NetCache_pendingResponsesCount = "NetCache_pendingResponsesCount";
	public static final String NetCache_responseHeaderBuffer = "NetCache_responseHeaderBuffer";
	public static final String NetCache_crc = "NetCache_crc";
	public static final String NetCache_indexCaches = "NetCache_indexCaches";

	public Class249() {
		super(Hooks.classNames.get("class249"));
	}
	
	public Class159 getNetCacheSocket() {
		return new Class159(getField(NetCache_socket).getValue(reference));
	}
	
	public HashTable getNetCache_pendingPriorityWrites() {
		return new HashTable(getField(NetCache_pendingPriorityWrites).getValue(reference));
	}
	
	public int getNetCache_pendingPriorityWritesCount() {
		return (int) getField(NetCache_pendingPriorityWritesCount).getValue(reference);
	}
	
	public int getNetCache_pendingPriorityResponses() {
		return (int) getField(NetCache_pendingPriorityResponses).getValue(reference);
	}
	
	public int getNetCache_pendingPriorityResponsesCount() {
		return (int) getField(NetCache_pendingPriorityResponsesCount).getValue(reference);
	}
	
	public Node2LinkedList getNetCache_pendingWritesQueue() {
		return new Node2LinkedList(getField(NetCache_pendingWritesQueue).getValue(reference)); 
	}
	
	public HashTable getNetCache_pendingWrites() {
		return new HashTable(getField(NetCache_pendingWrites).getValue(reference)); 
	}
	
	public int NetCache_pendingWritesCount() {
		return (int) getField(NetCache_pendingWritesCount).getValue(reference);
	}

	public HashTable getNetCache_pendingResponses() {
		return new HashTable(getField(NetCache_pendingResponses).getValue(reference)); 
	}
	
	public int NetCache_pendingResponsesCount() {
		return (int) getField(NetCache_pendingResponsesCount).getValue(reference);
	}
	
	public Buffer getNetCache_responseHeaderBuffer() {
		return new Buffer(getField(NetCache_pendingResponses).getValue(reference)); 
	}
	
	public IndexData[] getNetCache_indexCaches() {
		Object[] os = (Object[]) getField(NetCache_indexCaches).getValue(reference);
		IndexData[] NetCache_indexCaches = new IndexData[os.length];
		int i = 0;
		for (Object o : os) {
			NetCache_indexCaches[i] = new IndexData(o);
			i++;
		}
		return NetCache_indexCaches; 
	}
}