package com.matrix.pigmanoptimiser.manager;

import org.bukkit.Chunk;

import java.util.Objects;

public class MyChunk {
    private final int coordX;
    private final int coordZ;
    private final String world;
    public MyChunk(Chunk chunk){
        this.coordX=chunk.getX();
        this.coordZ=chunk.getZ();
        this.world=chunk.getWorld().getName();
    }
    public MyChunk(int x, int z, String name){
        this.coordX=x;
        this.coordZ=z;
        this.world=name;
    }
    public int getX() { return this.coordX; }
    public int getZ() { return this.coordZ; }
    public String getWorldName() { return this.world; }
    @Override
    public int hashCode() {
        return Objects.hash(coordX, coordZ, world);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyChunk myChunk = (MyChunk) o;
        return coordX == myChunk.coordX &&
                coordZ == myChunk.coordZ &&
                world.equals(myChunk.world);
    }
}
