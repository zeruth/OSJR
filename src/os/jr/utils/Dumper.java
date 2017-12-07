package os.jr.utils;

import os.jr.hooks.NPC;
import os.jr.utils.Dumpers.NPCdump;

public class Dumper {
	
	public static boolean dumpLocalNPCS = false;
	
	
	
	public static void main() {
		
	}
	
	public static void dumpLocalNPCS(NPC[] npcs) {
		
		if (dumpLocalNPCS) {
			for (NPC n: npcs) {
				try {
					NPCdump dump = new NPCdump(n);
					DumperIo.writeDumpedObject(String.valueOf(n.getNPCDefinition().getID())+ " - "+ n.getNPCDefinition().getName(), dump);	
				} catch (Exception e) {
					
				}
			}	
		}
	}

}
