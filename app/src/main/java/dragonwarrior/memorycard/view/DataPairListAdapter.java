package dragonwarrior.memorycard.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.List;

import dragonwarrior.memorycard.R;
import dragonwarrior.memorycard.model.DataPair;

public class DataPairListAdapter extends BaseAdapter {

    private final List<DataPair> m_dataPairs;
    private final Context m_context;

    public DataPairListAdapter(Context context, List<DataPair> dataPairs) {
        m_dataPairs = dataPairs;
        m_context = context;
    }
    @Override
    public int getCount() {
        return m_dataPairs.size();
    }

    @Override
    public Object getItem(int position) {
        return m_dataPairs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        DataPairItemView itemView;
        if (convertView instanceof DataPairItemView) {
            itemView = (DataPairItemView) convertView;
        } else {
            LayoutInflater inflater = (LayoutInflater)m_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = (DataPairItemView) inflater.inflate(R.layout.data_pair_item_view, null);
        }

        itemView.setContent(m_dataPairs.get(position));
        ImageButton deleteButton = (ImageButton) itemView.findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_dataPairs.remove(position);
                notifyDataSetChanged();
            }
        });

//        EditText textA = (EditText) itemView.findViewById(R.id.cardA);
//        textA.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                //todo
//            }
//        });
        return itemView;
    }

    public List<DataPair> getDataPairList() {
        return m_dataPairs;
    }
}
