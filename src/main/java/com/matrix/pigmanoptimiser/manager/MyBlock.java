package com.matrix.pigmanoptimiser.manager;

import org.bukkit.block.Block;

import java.util.Objects;

public class MyBlock {
    private final int coordX;
    private final int coordY;
    private final int coordZ;
    private final String world;
    public MyBlock(Block block){
        this.coordX=block.getX();
        this.coordY=block.getY();
        this.coordZ=block.getZ();
        this.world=block.getWorld().getName();
    }
    public MyBlock(int x,int y,int z,String worldName){
        this.coordX=x;
        this.coordY=y;
        this.coordZ=z;
        this.world=worldName;
    }
    public int getCoordX() {
        return coordX;
    }
    public int getCoordY() {
        return coordY;
    }

    public int getCoordZ() {
        return coordZ;
    }
    public String getWorldName() {
        return world;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyBlock myBlock = (MyBlock) o;
        return coordX == myBlock.coordX &&
                coordY == myBlock.coordY &&
                coordZ == myBlock.coordZ &&
                world.equals(myBlock.world);
    }
    @Override
    public int hashCode() {
        return Objects.hash(coordX, coordY, coordZ, world);
    }
}
