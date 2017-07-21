package dragonwarrior.memorycard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import dragonwarrior.memorycard.R;
import dragonwarrior.memorycard.model.DataPair;


public class DataPairItemView extends LinearLayout {
    private TextView m_dataA;
    private TextView m_dataB;

    public DataPairItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DataPairItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
    }

    public void setContent(DataPair dataPair) {
        m_dataA.setText((String)dataPair.getA());
        m_dataB.setText((String)dataPair.getB());
    }

    private void initView() {
        m_dataA = (TextView) findViewById(R.id.dataA);
        m_dataB = (TextView) findViewById(R.id.dataB);

    }

}
