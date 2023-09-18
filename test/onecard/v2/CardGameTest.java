package onecard.v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardGameTest {

    int playerList(int playerNum, int order) {
        // player 수 설정
        CardGame cardGame = new CardGame();
        cardGame.playerList(playerNum);

        MyLinkedList playerLinkedList = cardGame.playerLinkedList;
        playerLinkedList.setCurrent(playerLinkedList.getHead());

        for (int i = 0; i < order; i++) {
            playerLinkedList.next();
        }
        Player data = (Player) (playerLinkedList.getCurrent()).data;

        return data.getPlayerNum();
    }

    int playerReverseList(int playerNum, int reverseOrder) {
        // player 수 설정
        CardGame cardGame = new CardGame();
        cardGame.playerList(playerNum);

        MyLinkedList playerLinkedList = cardGame.playerLinkedList;
        playerLinkedList.setCurrent(playerLinkedList.getHead());

        for (int i = 0; i < reverseOrder; i++) {
            playerLinkedList.prev();
        }
        Player data = (Player) (playerLinkedList.getCurrent()).data;

        return data.getPlayerNum();
    }

    int playerMixList(int playerNum, int order, int reverseOrder) {
        // player 수 설정
        CardGame cardGame = new CardGame();
        cardGame.playerList(playerNum);

        MyLinkedList playerLinkedList = cardGame.playerLinkedList;
        playerLinkedList.setCurrent(playerLinkedList.getHead());

        for (int i = 0; i < order; i++) {
            playerLinkedList.next();
        }

        for (int i = 0; i < reverseOrder; i++) {
            playerLinkedList.prev();
        }

        Player data = (Player) (playerLinkedList.getCurrent()).data;

        return data.getPlayerNum();
    }

    @Test
    void nextTurn() {
        // player 수 설정
        CardGame cardGame = new CardGame();
        cardGame.playerList(4);

        MyLinkedList playerLinkedList = cardGame.playerLinkedList;
        boolean bool = true;

        for (int i = 0; i < 15; i++) {
            cardGame.nextTurn(bool);
            if (i==6) bool = false;
            Player data = (Player) (playerLinkedList.getCurrent()).data;
            System.out.print(data.getPlayerNum() + "-");
        }


    }



    @Test
    void orderTest(){
        assertEquals(2, playerList(4,10));
        assertEquals(2, playerList(6,8));
        assertEquals(0, playerList(5,10));
        assertEquals(1, playerList(3,10));
    }

    @Test
    void reverseOrderTest() {
        assertEquals(3, playerReverseList(4,1));
        assertEquals(4, playerReverseList(6,8));
        assertEquals(0, playerReverseList(5,10));
    }

    @Test
    void mixOrderTest() {
        assertEquals(0,playerMixList(5,1,1));
        assertEquals(1, playerMixList(5, 10, 4));
    }





}