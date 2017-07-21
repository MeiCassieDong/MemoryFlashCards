package dragonwarrior.memorycard.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import dragonwarrior.memorycard.R;
import dragonwarrior.memorycard.model.DataPair;
import dragonwarrior.memorycard.model.DataStorage;

/**
 * Created by casdong on 12/7/16.
 */
public class AddNewCardFragment extends Fragment {

    private EditText m_cardA;
    private EditText m_cardB;
    private Button m_saveButton;
    private DataStorage m_dataStorage;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_new_card, container, false);
        m_cardA = (EditText) view.findViewById(R.id.cardA);
        m_cardB = (EditText) view.findViewById(R.id.cardB);
        m_saveButton = (Button) view.findViewById(R.id.saveButton);
        m_dataStorage = new DataStorage(getActivity());

        m_saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDataToStorage(m_cardA.getText().toString(), m_cardB.getText().toString());
                Toast toast = Toast.makeText(getActivity(), "Saved successfully", Toast.LENGTH_SHORT);
                toast.show();
                m_cardA.setText("");
                m_cardB.setText("");
            }
        });

        return view;
    }

    private void addDataToStorage(String cardA, String cardB) {
        m_dataStorage.addData(new DataPair(cardA, cardB));
    }

}

