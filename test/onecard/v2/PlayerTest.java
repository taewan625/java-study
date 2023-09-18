package onecard.v2;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    static OneCardDeck oneCardDeck = new OneCardDeck();
    Player player = new Player(0);

    boolean method(){
        List<OneCard> oneCards = oneCardDeck.oneCardList.subList(0, 4);
        player.playerDeck.addAll(oneCards);
        System.out.println("player = " + player);
        return Objects.equals(player.toString(), "1 Player : [CLOVER-A, CLOVER-2, CLOVER-3, CLOVER-4]");
    }

    @Test
    void test(){
        assertTrue(method());
    }


}