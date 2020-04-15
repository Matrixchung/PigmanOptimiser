package com.matrix.pigmanoptimiser.tasks;

import com.matrix.pigmanoptimiser.PigZombieAI;
import com.matrix.pigmanoptimiser.PigmanOptimiser;
import com.matrix.pigmanoptimiser.manager.AIManager;
import com.matrix.pigmanoptimiser.manager.ChunkManager;
import com.matrix.pigmanoptimiser.manager.MyChunk;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.scheduler.BukkitScheduler;

public class MainTimerTask implements Runnable {
    @Override
    public void run() {
        for(World w: PigmanOptimiser.getPlugin().getServer().getWorlds()){
            for(MyChunk chunk:ChunkManager.chunkList){
                if(w.getName().equals(chunk.getWorldName())){
                    Chunk chunk1 = w.getChunkAt(chunk.getX(),chunk.getZ());
                    for(Entity e:chunk1.getEntities()){
                        try {
                            PigZombieAI.applyCustomAI((LivingEntity)e);
                        } catch (IllegalAccessException illegalAccessException) {
                            illegalAccessException.printStackTrace();
                        } catch (NoSuchFieldException noSuchFieldException) {
                            noSuchFieldException.printStackTrace();
                        } catch (ClassNotFoundException classNotFoundException) {
                            classNotFoundException.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
