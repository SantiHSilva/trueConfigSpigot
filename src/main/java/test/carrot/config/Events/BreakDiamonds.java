package test.carrot.config.Events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import static test.carrot.config.Utils.PlayerData.*;

public class BreakDiamonds implements Listener {

    @EventHandler
    private void onBreakDiamonds(BlockBreakEvent e){
        if(e.getBlock().getType().equals(Material.DIAMOND_ORE)){
            Player target = e.getPlayer();
            int amount = getDiamonds(target);
            target.sendMessage("§7You have §a" + amount + "§7 diamonds");
            setPlayerData(target, "diamonds", String.valueOf(amount + 1));
            target.sendMessage("§7You now have §a" + getDiamonds(target) + "§7 diamonds");
        }
    }

}
