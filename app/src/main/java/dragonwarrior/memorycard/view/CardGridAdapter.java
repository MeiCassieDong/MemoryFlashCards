package dragonwarrior.memorycard.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import dragonwarrior.memorycard.R;
import dragonwarrior.memorycard.model.DataPair;

public class CardGridAdapter extends BaseAdapter {

    private final LayoutInflater m_inflater;
    private final List<CardItem> m_gameData = new ArrayList<>();

    private class CardItem {
        Object m_content;
        DataPair m_dataPair;

        CardItem(Object content, DataPair dataPair) {
            m_content = content;
            m_dataPair = dataPair;
        }
    }

    public CardGridAdapter(Context context, List<DataPair> dataPairs) {
        m_inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        initialGameData(dataPairs);
    }

    //m_gameData contains the list of memory cards data
    private void initialGameData(List<DataPair> dataPairs) {
        for(DataPair dataPair : dataPairs) {
            m_gameData.add(new CardItem(dataPair.getA(), dataPair));
            m_gameData.add(new CardItem(dataPair.getB(), dataPair));
        }

        Collections.shuffle(m_gameData);
    }

    @Override
    public int getCount() {
        return m_gameData.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CardItemView itemView;
        if (convertView instanceof CardItemView) {
            itemView = (CardItemView) convertView;
        } else {
            itemView = (CardItemView) m_inflater.inflate(R.layout.card_item_view, null);
        }

        itemView.setContent((String) m_gameData.get(position).m_content);
        itemView.setDataPair(m_gameData.get(position).m_dataPair);
        return itemView;
    }
}
