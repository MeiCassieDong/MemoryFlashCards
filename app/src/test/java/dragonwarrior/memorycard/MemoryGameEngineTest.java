package dragonwarrior.memorycard;

import android.app.Activity;
import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import dragonwarrior.memorycard.model.DataPair;
import dragonwarrior.memorycard.view.CardItemView;


@RunWith(RobolectricTestRunner.class)
@Config(constants= BuildConfig.class)
@SmallTest
public class MemoryGameEngineTest {

    @Test
    public void whenAllCardsAreClicked_ReturnGameOver() {
        //create game
        MemoryGameEngine testEngine  = MemoryGameEngine.getInstance();
        testEngine.initialGame(2);
        Activity activity = Robolectric.setupActivity(MainActivity.class);
        DataPair dataPair = new DataPair("morning", "Morgen");
        CardItemView viewA = new CardItemView(activity, null);
        viewA.setDataPair(dataPair);
        CardItemView viewB = new CardItemView(activity, null);
        viewB.setDataPair(dataPair);

        //click all cards
        testEngine.handleClickedCard(viewA);
        boolean gameOver = !testEngine.handleClickedCard(viewB);

        //check results
        assertThat(gameOver, is(true));
    }

    @Test
    public void whenUnmatchingCardsAreClicked_cardViewsFlipBack(){
        //create game
        MemoryGameEngine testEngine  = MemoryGameEngine.getInstance();
        testEngine.initialGame(2);
        Activity activity = Robolectric.setupActivity(MainActivity.class);
        MockitoAnnotations.initMocks(this);
        DataPair dataPair = new DataPair("morning", "Morgen");
        CardItemView viewA = mock(CardItemView.class);
        CardItemView viewB = mock(CardItemView.class);
        when(viewA.isPairedWith(any(CardItemView.class))).thenReturn(false);

        //click all cards
        testEngine.handleClickedCard(viewA);
        testEngine.handleClickedCard(viewB);

        verify(viewA).closeCard();
        verify(viewB).closeCard();
    }
}