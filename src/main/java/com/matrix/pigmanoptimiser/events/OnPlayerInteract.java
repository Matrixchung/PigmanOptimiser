package com.matrix.pigmanoptimiser.events;

import com.matrix.pigmanoptimiser.PigmanOptimiser;
import com.matrix.pigmanoptimiser.entity.MyEntity;
import com.matrix.pigmanoptimiser.manager.AIManager;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class OnPlayerInteract implements Listener {
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerInteract(PlayerInteractEvent e) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        if (e.hasItem() && (e.getItem().getType().equals(Material.ZOMBIE_PIGMAN_SPAWN_EGG))) {
            e.setCancelled(true);
            MyEntity entity = new MyEntity(EntityType.PIG_ZOMBIE, e.getClickedBlock().getLocation().add(0,1,0));
            entity.spawnEntity();
            //entity.removeAttackAI();
            //manager.killAI();
            //entity.getBukkitEntity().setAI(false);
            AIManager manager = entity.getAIManager();
            //manager.addOpenDoorAI(true,1);
            //manager.addFleeSunAI(10,0);
            manager.killAI();
            e.getPlayer().sendMessage("LivingEntity: "+entity.getBukkitEntity());
            if (entity.isSpawned()) {
                PigmanOptimiser.getPlugin().getLogger().info("MyPigman Spawned!");
            }
        }
    }
}
