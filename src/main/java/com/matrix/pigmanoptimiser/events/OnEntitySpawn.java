package com.matrix.pigmanoptimiser.events;

import com.matrix.pigmanoptimiser.PigZombieAI;
import com.matrix.pigmanoptimiser.PigmanOptimiser;
import com.matrix.pigmanoptimiser.manager.ChunkManager;
import org.bukkit.entity.PigZombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class OnEntitySpawn implements Listener {
    @EventHandler(priority = EventPriority.HIGH)
    public void onEntitySpawn(CreatureSpawnEvent e) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        if(!PigmanOptimiser.disableWorlds.contains(e.getLocation().getWorld().getName())){
            if(e.getEntity() instanceof PigZombie){
                if(ChunkManager.check(e.getEntity().getChunk())){
                    if(e.getEntity().getWorld().getEntitiesByClass(PigZombie.class).size()<PigmanOptimiser.perWorldLimit&&e.getLocation().getChunk().getEntities().length<PigmanOptimiser.perChunkLimit){
                        CreatureSpawnEvent.SpawnReason reason = e.getSpawnReason();
                        if(!(reason.equals(CreatureSpawnEvent.SpawnReason.CUSTOM))){
                            PigZombieAI.applyCustomAI(e.getEntity());
                        }
                    }
                }
            }
        }
    }
}
