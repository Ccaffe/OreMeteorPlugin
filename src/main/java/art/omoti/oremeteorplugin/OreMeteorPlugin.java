package art.omoti.oremeteorplugin;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.scheduler.BukkitRunnable;

public final class OreMeteorPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
        // プラグインが有効になったときに呼ばれるメソッド
        // BukkitRunnableのサブクラスのインスタンスを作る
        SandTask task = new SandTask(this);
        // タスクを開始する
        task.runTaskTimer(this, 0, 5); // 0秒後から20ティック（1秒）ごとに実行する
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
