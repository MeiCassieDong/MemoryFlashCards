package dragonwarrior.memorycard.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import dragonwarrior.memorycard.R;
import dragonwarrior.memorycard.model.DataStorage;

public class MainMenuFragment extends Fragment {
    private Button m_startNewGameButton;
    private Button m_addNewCardButton;
    private Button m_manageCardsButton;

    public MainMenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_menu, container, false);
        m_startNewGameButton = (Button)view.findViewById(R.id.startNewGameButton);
        m_addNewCardButton = (Button)view.findViewById(R.id.addNewCard);
        m_manageCardsButton = (Button)view.findViewById(R.id.manageCards);

        m_startNewGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                NewGameFragment newGameFragment = new NewGameFragment();
                ft.replace(R.id.mainContainer, newGameFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);
                ft.addToBackStack("NewGameFragment");
                ft.commit();
            }
        });

        m_addNewCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                AddNewCardFragment addNewCardFragment = new AddNewCardFragment();
                ft.replace(R.id.mainContainer, addNewCardFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);
                ft.addToBackStack("AddNewCardFragment");
                ft.commit();
            }
        });

        m_manageCardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                CardsManagementFragment dataStorageFragment = new CardsManagementFragment();
                ft.replace(R.id.mainContainer, dataStorageFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);
                ft.addToBackStack("CardsManagementFragment");
                ft.commit();
            }
        });
        return view;
    }
}
