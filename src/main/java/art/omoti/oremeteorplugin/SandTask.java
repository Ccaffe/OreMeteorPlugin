package art.omoti.oremeteorplugin;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import java.util.Random;
import org.bukkit.util.Vector;
import org.bukkit.block.data.BlockData;




public class SandTask  extends BukkitRunnable {
    private Plugin plugin; // プラグインのインスタンスを保持する
    private Random random; // ランダムな数値を生成する

    public SandTask(Plugin plugin) {
        // コンストラクタでプラグインのインスタンスを受け取る
        this.plugin = plugin;
        this.random = new Random();
    }

    @Override
    public void run() {
        // 定期的に実行されるメソッド
        // サーバーに接続しているすべてのプレイヤーに対して砂を降らせる
        for (Player player : plugin.getServer().getOnlinePlayers()) {
            // プレイヤーの位置を取得する
            Location location = player.getLocation();
            // プレイヤーの上方向に砂のブロックを生成する

            int x = random.nextInt(61) - 10; // -30から30までのランダムな数値を生成する
            int z = random.nextInt(61) - 10; // -30から30までのランダムな数値を生成する

            location.add(x, 40, z); // 10ブロック分上に移動する
            Vector velocity = new Vector(-5, -10, -5); // xとz方向に逆方向、y方向に下方向に速度ベクトルを作る
            // 砂のブロックのBlockDataを取得する
            BlockData sandData = Material.SAND.createBlockData();
            // FallingBlockを生成して、BlockDataと速度をセットする
            FallingBlock fallingBlock = location.getWorld().spawnFallingBlock(location, sandData); // 砂のブロ
            velocity.normalize(); // 速度ベクトルを単位ベクトルにする（大きさを1にする）
            velocity.multiply(2.5); // 速度ベクトルの大きさを0.5倍にする（適当な値）
            fallingBlock.setVelocity(velocity); // FallingBlockに速度ベクトルをセットする
            // 重力を無くす
            fallingBlock.setGravity(false); // FallingBlockの重力をfalseにする
            // アイテム化を無くす
            fallingBlock.setDropItem(false); // FallingBlockのアイテム化をfalseにする
            // block_displayを召喚する
            //BlockDisplay blockDisplay = location.getWorld().spawn(location, BlockDisplay.class); // block_displayを生成する
            //blockDisplay.setBlock(Material.SAND.createBlockData()); // block_displayのブロックを砂にする

        }
    }

}
