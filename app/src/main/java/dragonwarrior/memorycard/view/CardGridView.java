package dragonwarrior.memorycard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

import java.util.List;

import dragonwarrior.memorycard.MemoryGameEngine;
import dragonwarrior.memorycard.model.DataPair;
import dragonwarrior.memorycard.model.DataStorage;

public class CardGridView extends GridView {
    private final Context m_context;
    private List<DataPair> m_dataPairs;

    public CardGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        m_context = context;
        m_dataPairs = new DataStorage(m_context).getGameDatas();
        MemoryGameEngine.getInstance().initialGame(m_dataPairs.size(), this);
    }

    public CardGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        m_context = context;
        m_dataPairs = new DataStorage(context).getGameDatas();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        setAdapter(new CardGridAdapter(m_context, m_dataPairs));

    }

    public void restartGame() {
        m_dataPairs = new DataStorage(m_context).getGameDatas();
        setAdapter(new CardGridAdapter(m_context, m_dataPairs));
        MemoryGameEngine.getInstance().initialGame(m_dataPairs.size(), this);
    }

}
