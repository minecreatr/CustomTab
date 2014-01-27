package net.amuricraft.customtab;


import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;


public class CustomTab extends JavaPlugin implements Listener {

    public void onEnable(){
        getLogger().info("Custom Tab has been enabled");
        getServer().getPluginManager().registerEvents(this, this);
    }

    public void onDisable(){
        getLogger().info("Custom Tab has been disabled");
    }

    public void mainTab(Player player){
        World world = player.getWorld();
        Player[] players = Bukkit.getServer().getOnlinePlayers();
        for (int i=0;i<players.length;i++){
            if (!(player.getWorld().getName().equals(players[i].getWorld().getName()))){
                player.hidePlayer(players[i]);
            }
        }
    }

    public void onPlayerInteract(PlayerInteractEvent e){
        mainTab(e.getPlayer());
    }


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        mainTab(e.getPlayer());
    }

}
