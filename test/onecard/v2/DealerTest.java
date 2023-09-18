package onecard.v2;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class DealerTest {

    Dealer dealer = new Dealer(); // shuffle 한 list
    Dealer fixedDealer = new Dealer(); // shuffle 안한 list


    boolean shuffle() {

        LinkedList<OneCard> oneCardList = dealer.oneCardDeck.oneCardList;
        dealer.shuffleOneCardDeck();
        System.out.println("oneCardList = " + oneCardList);

        LinkedList<OneCard> oneCardList1 = fixedDealer.oneCardDeck.oneCardList;
        System.out.println("oneCardList1 = " + oneCardList1);

        int same = 0;
        for (int i = 0; i < 54; i++) {
            boolean equals = Objects.equals(oneCardList.get(i), oneCardList1.get(i));
            if (equals) same++;
            if (same > 5) return false;
        }
        System.out.println("same = " + same);
        return true;
    }


//    이전 버전의 dealer의 giveCard를 이용하게 되면 실제 게임 코드도 아래와 같이 많이 작성하게 된다.
//    int playerDeck(int giveNum){ // 실제 게임에서는
//        Player player = new Player(); // method() 밖으로 꺼내면 size()가 중첩 됨
//        LinkedList<OneCard> playerDeck = player.playerDeck; -> 1. 생략됨
//        playerDeck.addAll(dealer.giveCard(giveNum));        -> 2. 생략ㄴ
//        return playerDeck.size();
//    }
    int playerDeck(int giveNum){ // 실제 게임에서는
        Player player = new Player(0); // method() 밖으로 꺼내면 size()가 중첩 됨
        dealer.giveCard(player, giveNum);
        return player.playerDeck.size();
    }

    int oneCardDeck(int giveNum){
        Player player = new Player(0); // method() 밖으로 꺼내면 size()가 중첩 됨
        dealer.giveCard(player, giveNum);
        return dealer.oneCardDeck.oneCardList.size();
    }

    OpenDeck openDeck = new OpenDeck();
    boolean resetCard() {
        LinkedList<OneCard> oneCardList = dealer.oneCardDeck.oneCardList;

        List<OneCard> oneCards = oneCardList.subList(0, 52);
        openDeck.openDeckList.addAll(oneCards);

        LinkedList copyList = new LinkedList(oneCards);
        oneCardList.removeAll(copyList);

        System.out.println("dealer.oneCardDeck.oneCardList = " + dealer.oneCardDeck.oneCardList);
        System.out.println("openDeck = " + openDeck.openDeckList);

        OneCard last = openDeck.openDeckList.getLast();
        dealer.resetCard(openDeck); // 핵심
        OneCard oneCard = openDeck.openDeckList.get(0);

        System.out.println("dealer.oneCardDeck.oneCardList1 = " + dealer.oneCardDeck.oneCardList);
        System.out.println("openDeck1 = " + openDeck.openDeckList);
        System.out.println("dealer.oneCardDeck.oneCardList.size() = " + dealer.oneCardDeck.oneCardList.size());

        return last == oneCard;
    }

    boolean getCard() {
        LinkedList<OneCard> oneCardList = dealer.oneCardDeck.oneCardList;
        Player player = new Player(1);
        player.playerDeck.add(new OneCard(2,2));
        player.playerDeck.add(new OneCard(1,2));

        dealer.getCard(openDeck, player, new OneCard(1,2));

        System.out.println(player.playerDeck);
        System.out.println(new OneCard(1,2));
        System.out.println(openDeck.getOpenCard());

        return Objects.equals(new OneCard(1,2), openDeck.getOpenCard());
    }



    @Test
    void shuffleTest() {
        assertTrue(shuffle()); // 동일한 위치에 동일한 카드가 5개 미만이면 true;
    }

    @Test
    void playerDeckSizeTest() {
        assertEquals(1, playerDeck(1));
        assertEquals(7, playerDeck(7));
        assertEquals(20, playerDeck(20));
        assertEquals(26, playerDeck(26));
    }

    @Test
    void oneCardDeckSizeTest(){
        assertEquals(54, oneCardDeck(0));
        assertEquals(53, oneCardDeck(1));
        assertEquals(43, oneCardDeck(10));
        assertEquals(33, oneCardDeck(10));
        assertEquals(0, oneCardDeck(33));

    }
    @Test
    void resetCardTest(){
        assertTrue(resetCard());
    }


    @Test
    void getCardTest() {
        assertTrue(getCard());
    }
}