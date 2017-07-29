package dragonwarrior.memorycard;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import static org.junit.Assert.*;

import dragonwarrior.memorycard.view.CardItemView;


@RunWith(RobolectricTestRunner.class)
public class MemoryGameEngineTest {

    @Test
    public void testHandleClickedCard() {
        MemoryGameEngine testEngine  = MemoryGameEngine.getInstance();
        testEngine.initialGame(2);
        CardItemView view = new CardItemView(RuntimeEnvironment.application.getBaseContext(), null);
        boolean gameNotOver = testEngine.handleClickedCard(view);

        assertTrue(gameNotOver);
    }
}