package dragonwarrior.memorycard;

import dragonwarrior.memorycard.view.CardItemView;

public class GameEngine {
    private static GameEngine m_engine = null;
    private CardItemView m_activeViewA;
    private CardItemView m_activeViewB;
    private GameEngine() {
    }

    public static GameEngine getInstance() {
        if (m_engine == null) {
            m_engine = new GameEngine();
        }
        return m_engine;
    }

    public void setCardItemView(CardItemView cardItemView) {
        if(m_activeViewA == null && m_activeViewB == null) {
            m_activeViewA = cardItemView;
        } else if(m_activeViewA != null && m_activeViewB == null) {
            m_activeViewB = cardItemView;

            if (! m_activeViewA.isPairedWith(m_activeViewB)) {
                m_activeViewA.closeCard();
                m_activeViewB.closeCard();
            }
            m_activeViewA = m_activeViewB = null;

        } else if(m_activeViewA != null && m_activeViewB != null) {
            m_activeViewA = cardItemView;
            m_activeViewB = null;
        }
    }
}
