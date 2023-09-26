import models.Creature;
import models.Monster;
import models.Player;

public class Main {
    public static void main(String[] args) throws Exception{
        Player player = new Player(25, 25, 100, 1, 6);
        Monster boss = new Monster(20, 20, 2, 7, 9);
        boss.toHit(player);
        boss.toHit(player);
        player.toHeal();
        player.toHit(boss);
    }
}
