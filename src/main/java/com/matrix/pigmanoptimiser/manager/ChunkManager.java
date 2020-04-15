package com.matrix.pigmanoptimiser.manager;

import org.bukkit.Chunk;

import java.util.*;

public class ChunkManager {
    public static HashSet<MyChunk> chunkList =new HashSet<>();
    public static void add(Chunk chunk){
        MyChunk chunk1 = new MyChunk(chunk);
        if(!chunkList.contains(chunk1))  chunkList.add(chunk1);
    }
    public static void add(int x, int z, String worldName){
        MyChunk chunk1 = new MyChunk(x,z,worldName);
        if(!chunkList.contains(chunk1)) chunkList.add(chunk1);
    }
    public static boolean check(Chunk chunk){
        MyChunk chunk1 = new MyChunk(chunk);
        if(chunkList.contains(chunk1)) return true;
        return false;
    }
    public static ArrayList<String> printAll(){
        ArrayList<String> result = new ArrayList<>();
        for(MyChunk chunk:chunkList){
            result.add("X: "+chunk.getX()+" Z: "+chunk.getZ()+" World: "+chunk.getWorldName());
        }
        return result;
    }
}
