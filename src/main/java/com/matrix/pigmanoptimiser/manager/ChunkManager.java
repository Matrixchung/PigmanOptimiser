package com.matrix.pigmanoptimiser.manager;

import org.bukkit.Chunk;

import java.util.*;

public class ChunkManager {
    public static HashMap<int[],String> chunkList = new HashMap<>();
    public static void add(Chunk chunk){
        String worldName = chunk.getWorld().getName();
        int[] xz = new int[3];
        xz[0]=chunk.getX();
        xz[1]=chunk.getZ();
        chunkList.put(xz,worldName);
    }
    public static void add(int x, int z, String worldName){
        int[] xz = new int[3];
        xz[0]=x;
        xz[1]=z;
        chunkList.put(xz,worldName);
    }
    public static boolean check(Chunk chunk){
        String worldName = chunk.getWorld().getName();
        int[] xz = new int[3];
        xz[0]=chunk.getX();
        xz[1]=chunk.getZ();
        if(chunkList.containsKey(xz)){
            return chunkList.get(xz).equals(worldName);
        }
        return false;
    }
    public static ArrayList<String> printAll(){
        ArrayList<String> result = new ArrayList<>();
        Iterator iter = chunkList.entrySet().iterator();
        int[] xz;
        while(iter.hasNext()){
            Map.Entry entry = (Map.Entry) iter.next();
            xz= (int[]) entry.getKey();
            result.add("X: "+xz[0]+" Z: "+xz[1]+" World: "+entry.getValue());
        }
        return result;
    }
}
