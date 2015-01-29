package fr.hotmail.danyvaise.tgmanager;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TGManager extends JavaPlugin
    {
    @Override
    public void onEnable()
        {
        Listener l = new PluginListener();
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(l, this);
        }
    
    @Override
    public void onDisable()
        {
        }
    }