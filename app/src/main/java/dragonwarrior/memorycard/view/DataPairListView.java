package dragonwarrior.memorycard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

import java.util.List;
import dragonwarrior.memorycard.model.DataPair;
import dragonwarrior.memorycard.model.DataStorage;

public class DataPairListView extends ListView {
    private final Context m_context;
    private final List<DataPair> m_dataPairs;

    public DataPairListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        m_context = context;
        m_dataPairs = new DataStorage(context).getAllData();
    }

    public DataPairListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        m_context = context;
        m_dataPairs = new DataStorage(context).getAllData();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        final DataPairListAdapter listAdapter = new DataPairListAdapter(m_context, m_dataPairs);
        setAdapter(listAdapter);
    }
}
