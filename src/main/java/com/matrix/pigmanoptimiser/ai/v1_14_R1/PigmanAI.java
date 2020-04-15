package com.matrix.pigmanoptimiser.ai.v1_14_R1;

import com.matrix.pigmanoptimiser.reflect.ReflectionManager;
import net.minecraft.server.v1_14_R1.*;
import org.bukkit.event.entity.EntityTargetEvent;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PigmanAI extends PathfinderGoalHurtByTarget {
    public PigmanAI(EntityPigZombie entitypigzombie) {
        super(entitypigzombie, new Class[0]);
        this.a(new Class[]{EntityZombie.class});
    }
    public void a(EntityInsentient entityinsentient, EntityLiving entityliving) {
        try {
            Method method = ReflectionManager.getPigManClass().getDeclaredMethod("i",EntityLiving.class);
            method.setAccessible(true);
            method.invoke((EntityLiving)entityinsentient,entityliving);
        } catch (NoSuchMethodException noSuchMethodException) {
            noSuchMethodException.printStackTrace();
        } catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        } catch (InvocationTargetException invocationTargetException) {
            invocationTargetException.printStackTrace();
        }
        if (entityinsentient instanceof EntityPigZombie && this.e.hasLineOfSight(entityliving) ) {
            entityinsentient.setGoalTarget(entityliving, EntityTargetEvent.TargetReason.TARGET_ATTACKED_NEARBY_ENTITY, true);
        }

    }
}
