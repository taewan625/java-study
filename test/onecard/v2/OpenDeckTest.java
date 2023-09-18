package onecard.v2;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class OpenDeckTest {
    OpenDeck openDeck = new OpenDeck();
    int lastOneCard(int kind, int number) {
        // 게임 시작시 어차피 첫 셋팅 때 card 한장을 나눠주게 된다.
        openDeck.openDeckList.add(new OneCard(0,0)); // 첫 셋팅
        openDeck.openDeckList.add(new OneCard(kind,number));
        openDeck.openCard=openDeck.getOpenCard();
        return openDeck.openCard.kind;
    }



    @Test
    void lastOneCardTest() {
        assertEquals(1, lastOneCard(1,2));
        assertEquals(3, lastOneCard(3,2));
        assertEquals(5, lastOneCard(5,2));
        assertEquals(5, lastOneCard(5,6));
        assertEquals(3, lastOneCard(3,8));
        assertEquals(4, lastOneCard(4,12));
    }

}