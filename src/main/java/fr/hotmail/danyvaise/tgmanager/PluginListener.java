package fr.hotmail.danyvaise.tgmanager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
 
public class PluginListener implements Listener, Runnable
    {
    private PlayerJoinEvent playerJoinEvent;
    
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e)
        {
        playerJoinEvent = e;
        
        //New thread to don't impact the main thread
        new Thread(this){{ start(); }};
        }

    @Override
    public void run()
        {
        Player p = playerJoinEvent.getPlayer();
        String title = "TitisGames";
        String subtitle = "Welcome " + p.getName() + " !";
        Title t = new Title(title, subtitle);
        t.setTitleColor(ChatColor.GOLD);
        t.setSubtitleColor(ChatColor.RED);
        t.send(p);
        
        for(int i=0; i<10; i++)
            {
            try
                {
                Thread.sleep(500);
                }
            catch (InterruptedException ex)
                {
                Logger.getLogger(PluginListener.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1, i);
            }
        }
    }