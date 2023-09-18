package onecard.v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OneCardSkillTest {
    CardGame cardGame = new CardGame();
    OneCardSkill oneCardSkill = new OneCardSkill();
    boolean bool = true;

    int attackCard = 3;


    @Test
    void QOrder() {
        cardGame.playerList(4);
        for (int i = 0; i < 20; i++) {
            cardGame.nextTurn(bool);
            Node current = cardGame.playerLinkedList.getCurrent();
            Player p = (Player) current.data;
            System.out.print(p.getPlayerNum());

            if (i == 5 || i == 10 || i == 15) {
                bool = oneCardSkill.Queen(bool);
            }
        }
    }

    @Test
    void JOrder() {
        cardGame.playerList(4);
        for (int i = 0; i < 20; i++) {
            cardGame.nextTurn(bool);
            Node current = cardGame.playerLinkedList.getCurrent();
            Player p = (Player) current.data;
            System.out.print(p.getPlayerNum() + "  ");

            if (i == 5 || i == 10 || i == 15) {
                oneCardSkill.Jack(cardGame, bool);
            }
        }
    }

    @Test
    void KOrder() {
        cardGame.playerList(4);
        for (int i = 0; i < 20; i++) {
            cardGame.nextTurn(bool);
            Node current = cardGame.playerLinkedList.getCurrent();
            Player p = (Player) current.data;
            System.out.print(p.getPlayerNum() + "  ");

            if (i == 5 || i == 10 || i == 15) {
                oneCardSkill.King(cardGame, bool);
            }
        }
    }

    int AAttack() {
        OneCard openCard = new OneCard(1, 0);
        attackCard = oneCardSkill.ACard(openCard, attackCard);
        return attackCard;
    }

    @Test
    void AttackTest() {
        assertEquals(6,AAttack());
    }


}