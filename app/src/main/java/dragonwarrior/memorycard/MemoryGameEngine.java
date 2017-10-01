package dragonwarrior.memorycard;

import android.app.AlertDialog;
import android.content.DialogInterface;

import dragonwarrior.memorycard.view.CardItemView;

public class MemoryGameEngine {
    private static MemoryGameEngine m_engine = null;
    private CardItemView m_firstClickedCard;
    private CardItemView m_secondClickedCard;
    private int m_cardsCount;

    private MemoryGameEngine() {
    }

    public static MemoryGameEngine getInstance() {
        if (m_engine == null) {
            m_engine = new MemoryGameEngine();
        }
        return m_engine;
    }

    //return false when all the cards are open, otherwise return true
    public boolean handleClickedCard(CardItemView cardItemView) {
        if(m_firstClickedCard == null && m_secondClickedCard == null) {
            m_firstClickedCard = cardItemView;
        } else if(m_firstClickedCard != null && m_secondClickedCard == null) {
            m_secondClickedCard = cardItemView;

            if (! m_firstClickedCard.isPairedWith(m_secondClickedCard)) {
                m_firstClickedCard.closeCard();
                m_secondClickedCard.closeCard();
            } else {
                m_cardsCount = m_cardsCount - 1;
            }
            m_firstClickedCard = m_secondClickedCard = null;

        } else if(m_firstClickedCard != null && m_secondClickedCard != null) {
            m_firstClickedCard = cardItemView;
            m_secondClickedCard = null;
        }

        boolean gameIsNotOver = m_cardsCount > 0;

        if (!gameIsNotOver) {
            new AlertDialog.Builder(cardItemView.getContext())
                    .setTitle(R.string.congratulations)
                    .setPositiveButton(R.string.continue_play, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {


                        }
                    })
                    .create().show();
        }

        return  gameIsNotOver;
    }

    public void initialGame(int size) {
        m_cardsCount = size;
    }
}
