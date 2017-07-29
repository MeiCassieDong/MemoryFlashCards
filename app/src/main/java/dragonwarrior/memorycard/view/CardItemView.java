package dragonwarrior.memorycard.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;


import dragonwarrior.memorycard.MemoryGameEngine;
import dragonwarrior.memorycard.R;
import dragonwarrior.memorycard.model.DataPair;

public class CardItemView extends FrameLayout {

    private View m_backgroundImage;
    private TextView m_content;
    private View m_container;
    private boolean isClickable = true;
    private MemoryGameEngine m_gameEngine;
    private DataPair m_dataPair;
    private View m_contentContainer;

    public CardItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CardItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setContent(String content) {
        m_content.setText(content);
    }

    public void setDataPair(DataPair dataPair) {
        m_dataPair = dataPair;
    }

    public DataPair getDataPair() {
        return m_dataPair;
    }

    public boolean isPairedWith(CardItemView activeViewB) {
        return m_dataPair.equals(activeViewB.getDataPair());
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (isInEditMode()) return;
        initView();
        m_gameEngine = MemoryGameEngine.getInstance();
    }

    public void closeCard() {
        m_backgroundImage.setVisibility(VISIBLE);
        m_contentContainer.setVisibility(GONE);
        isClickable = true;
    }

    private void initView() {
        m_backgroundImage = findViewById(R.id.backgroundImage);
        m_container = findViewById(R.id.container);
        m_content = (TextView)findViewById(R.id.text);
        m_contentContainer = (View)findViewById(R.id.contentContainer);

        m_container.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClickable) {
                    showContent();
                }
            }
        });
    }

    private void cardIsClicked() {
        m_gameEngine.handleClickedCard(this);
    }

    private void showContent() {
        m_backgroundImage.setVisibility(GONE);
        m_contentContainer.setVisibility(VISIBLE);
        (new Handler()).postDelayed(new Runnable() {
            @Override
            public void run() {
                cardIsClicked();
            }
        }, (long) 1000);
        isClickable = false;
    }
}
