package com.matrix.pigmanoptimiser.manager;

import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.HashSet;

public class BlockManager {
    public static HashSet<MyBlock> blockList =new HashSet<>();
    public static HashSet<String> addList = new HashSet<>();
    public static void add(Block block){
        MyBlock block1 = new MyBlock(block);
        blockList.add(block1);
    }
    public static void add(int x, int y, int z, String worldName){
        MyBlock block1 = new MyBlock(x,y,z,worldName);
        blockList.add(block1);
    }
    public static boolean check(Block block){
        MyBlock block1 = new MyBlock(block);
        if(blockList.contains(block1)) return true;
        return false;
    }
    public static ArrayList<String> printAll(){
        ArrayList<String> result = new ArrayList<>();
        for(MyBlock block:blockList){
            result.add("X: "+block.getCoordX()+" Y: "+block.getCoordY()+" Z: "+block.getCoordZ()+" World: "+block.getWorldName());
        }
        return result;
    }
    public static void addToFile(int x,int y,int z,String worldName){
        addList.add(worldName+" "+x+" "+y+" "+z);
    }
}
