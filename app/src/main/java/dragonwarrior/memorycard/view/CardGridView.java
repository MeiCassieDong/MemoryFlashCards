package dragonwarrior.memorycard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

import java.util.List;

import dragonwarrior.memorycard.model.DataPair;
import dragonwarrior.memorycard.model.DataStorage;

public class CardGridView extends GridView {
    private final Context m_context;
    private List<DataPair> m_dataPairs;

    public CardGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        m_context = context;
        m_dataPairs = new DataStorage(context).getGameDatas();
    }

    public CardGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        m_context = context;
        m_dataPairs = new DataStorage(context).getGameDatas();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (m_dataPairs != null) {
            setAdapter(new CardGridAdapter(m_context, m_dataPairs));
        }
    }
}
