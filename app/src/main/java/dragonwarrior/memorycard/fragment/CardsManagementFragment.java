package dragonwarrior.memorycard.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import dragonwarrior.memorycard.R;
import dragonwarrior.memorycard.model.DataStorage;
import dragonwarrior.memorycard.view.DataPairListAdapter;
import dragonwarrior.memorycard.view.DataPairListView;

public class CardsManagementFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View newGameView = inflater.inflate(R.layout.fragment_cards_management, container, false);

        final DataPairListView listView = (DataPairListView) newGameView.findViewById(R.id.dataListView);

        Button saveButton = (Button) newGameView.findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DataStorage(getActivity()).saveAllData(
                        ((DataPairListAdapter)listView.getAdapter()).getDataPairList());
                closeFragment();
            }
        });

        return newGameView;
    }

    private void closeFragment() {
        getActivity().onBackPressed();
    }
}
