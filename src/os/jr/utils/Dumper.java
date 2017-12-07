package os.jr.utils;

import os.jr.hooks.NPC;
import os.jr.utils.Dumpers.NPCdump;

public class Dumper {
	
	public static boolean enabled = true;
	
	
	public static void main() {
		
	}
	
	public static void dumpLocalNPCS(NPC[] npcs) throws NullPointerException{
		
		for (NPC n: npcs) {
			try {
				NPCdump dump = new NPCdump(n);
				DumperIo.writeDumpedObject(String.valueOf(n.getNPCDefinition().getID())+ " - "+ n.getNPCDefinition().getName(), dump);	
			} catch (Exception e) {
				
			}

		}
		
	}

}
