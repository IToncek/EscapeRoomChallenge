package me.itoncek.fem3xescaperoom.util;

import me.itoncek.fem3xescaperoom.Fem3xEscapeRoom;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Sign;
import org.bukkit.block.data.Rotatable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MapBuilder {

    public static void buildMap(Fem3xEscapeRoom plugin, World world) {
        fill(new Location(world, -8, -61, -8),new Location(world, 24, -27, 24), Material.LIGHT);
        fill(new Location(world, -7, -61, -7),new Location(world, 23, -61, 23), Material.BEDROCK);
        fill(new Location(world, -7, -27, -7),new Location(world, 23, -27, 23), Material.BEDROCK);
        fill(new Location(world, -8, -61, -8),new Location(world, -8, -27, 24), Material.BEDROCK);
        fill(new Location(world, -8, -61, -8),new Location(world, 24, -27, -8), Material.BEDROCK);
        fill(new Location(world, -8, -61, 24),new Location(world, 24, -27, 26), Material.BEDROCK);
        fill(new Location(world, 24, -61, -8),new Location(world, 24, -27, 26), Material.BEDROCK);
        fill(new Location(world, 25, -60, 6),new Location(world, 29, -56, 10), Material.LIGHT);
        fill(new Location(world, 48, -60, 6),new Location(world, 52, -56, 10), Material.LIGHT);
        //TODO: DEEPSLATE!!
        fill(new Location(world, 30, -60, 6),new Location(world, 47, -56, 10), Material.DEEPSLATE);
        fill(new Location(world, 25, -60, 5),new Location(world, 52, -56, 5), Material.BEDROCK);
        fill(new Location(world, 53, -60, 6),new Location(world, 53, -56, 10), Material.BEDROCK);
        fill(new Location(world, 25, -61, 6),new Location(world, 52, -61, 10), Material.BEDROCK);
        fill(new Location(world, 25, -61, 6),new Location(world, 29, -61, 10), Material.GOLD_BLOCK);
        fill(new Location(world, 25, -60, 11),new Location(world, 52, -56, 11), Material.BEDROCK);
        fill(new Location(world, 25, -55, 6),new Location(world, 52, -55, 10), Material.BEDROCK);
        fill(new Location(world, 49, -61, 7),new Location(world, 51, -61, 9), Material.DIAMOND_BLOCK);
        setBlock(new Location(world, 8, -61, 8), Material.DIAMOND_BLOCK);
        setBlock(new Location(world, -7, -61, 23), Material.NETHERITE_BLOCK);
        setBlock(new Location(world, 39, -55, 11), Material.BEDROCK);
        setBlock(new Location(world, 39, -54, 10), Material.BEDROCK);
        setBlock(new Location(world, 39, -55, 10), Material.BEACON);
        //stage3 prep
        fill(new Location(world, 53, -61, 5),new Location(world, 59, -55, 11), Material.BEDROCK);
        fill(new Location(world, 54, -60, 6),new Location(world, 58, -56, 10), Material.LIGHT);
        setSign(new Location(world, 55, -60, 6), "!!WARNING!!\n" +
                "Intensive block\n" +
                "operations ahead\n" +
                "!PROCEED SAFELY!", BlockFace.SOUTH);
        setSign(new Location(world, 56, -60, 7), "Next part of map\n" +
                "requires a bit\n" +
                "more building\n" +
                "to do...", BlockFace.WEST_SOUTH_WEST);
        setSign(new Location(world, 56, -60, 8), "Type /yes\n" +
                "only if you have\n" +
                "pretty beefy\n" +
                "server.", BlockFace.WEST);
        setSign(new Location(world, 56, -60, 9), "Also, I'll be\n" +
                "downloading\n" +
                "some files from\n" +
                "Internet...", BlockFace.WEST_NORTH_WEST);
        setSign(new Location(world, 55, -60, 10), "More info:\n" +
                "c.itoncek.cf/\n" +
                "stage3\n" +
                " ", BlockFace.NORTH);
        setBlock(new Location(world, 58, -60, 8), Material.REDSTONE_BLOCK);
        setBlock(new Location(world, 58, -58, 8), Material.REDSTONE_BLOCK);
        setBlock(new Location(world, 58, -57, 8), Material.REDSTONE_BLOCK);
        setBlock(new Location(world, 58, -56, 8), Material.REDSTONE_BLOCK);
    }

    public static void stage3(){
        String data = download()
    }

    public static String download(String url){
        try {
            URL conn = new URL(url);
            URLConnection urlcon = conn.openConnection();
            BufferedReader out = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));
            return out.readLine();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    public static void fill(Location from, Location to, Material mat) {
        for(int i = from.getBlockX(); i <= to.getBlockX(); i++) {
            for(int j = from.getBlockZ(); j <= to.getBlockZ(); j++) {
                for(int k = from.getBlockY(); k <= to.getBlockY(); k++) {
                    Location location = new Location(from.getWorld(), i, k, j);
                    setBlock(location, mat);
                }
            }
        }

    }

    public static void setBlock(Location loc, Material mat) {
        loc.getBlock().setType(mat);
    }

    public static void setSign(Location loc, String text, BlockFace face) {
        loc.getBlock().setType(Material.BIRCH_SIGN);
        Rotatable signRotatable = (Rotatable) loc.getBlock().getBlockData();
        signRotatable.setRotation(face);
        loc.getBlock().setBlockData(signRotatable);
        Sign sign = (Sign) loc.getBlock().getState();
        String [] lines = text.split("\\r?\\n");
        sign.setLine(0, lines[0]);
        sign.setLine(1, lines[1]);
        sign.setLine(2, lines[2]);
        sign.setLine(3, lines[3]);
        sign.setGlowingText(true);
        sign.setColor(DyeColor.RED);
        sign.update();
    };
}
