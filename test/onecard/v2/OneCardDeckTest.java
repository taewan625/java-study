package onecard.v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OneCardDeckTest {
    OneCardDeck oneCardDeck = new OneCardDeck();

    int checkOneCardDeck() {
        int size = oneCardDeck.oneCardList.size();
        return size;
    }

    int checkCardKind(int kind) {
        int k = 0;
        for (int i = 0; i < 54; i++) {
            OneCard oneCard = oneCardDeck.oneCardList.get(i);
            if (oneCard.kind == kind) k++;
        }
        return k;
    }

    int checkCardNum(int num){
        int k = 0;
        for (int i = 0; i < 54; i++) {
            OneCard oneCard = oneCardDeck.oneCardList.get(i);
            if (oneCard.number == num) k++;
        }
        return k;
    }


    @Test
    void totalCard() {
            // 54장 카드 생성되는지 확인인
        assertEquals(54, checkOneCardDeck());
    }

    @Test
    void cardKind() {
        assertEquals(13,checkCardKind(0));
        assertEquals(13,checkCardKind(1));
        assertEquals(13,checkCardKind(2));
        assertEquals(13,checkCardKind(3));
        assertEquals(1,checkCardKind(4));
        assertEquals(1,checkCardKind(5));
    }

    @Test
    void cardNum() {
        assertEquals(4,checkCardNum(0));
        assertEquals(4,checkCardNum(1));
        assertEquals(4,checkCardNum(2));
        assertEquals(4,checkCardNum(3));
        assertEquals(4,checkCardNum(4));
        assertEquals(4,checkCardNum(5));
        assertEquals(4,checkCardNum(6));
        assertEquals(4,checkCardNum(7));
        assertEquals(4,checkCardNum(8));
        assertEquals(4,checkCardNum(9));
        assertEquals(4,checkCardNum(10));
        assertEquals(4,checkCardNum(11));
        assertEquals(4,checkCardNum(12));
        assertEquals(2,checkCardNum(13));
    }

}