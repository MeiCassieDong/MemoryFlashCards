package dragonwarrior.memorycard;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import dragonwarrior.memorycard.fragment.MainMenuFragment;

public class MainActivity extends FragmentActivity {
    private static final String MAIN_MENU_FRAGMENT = "MainMenuFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment fragment = new MainMenuFragment();
        ft.add(R.id.mainContainer, fragment);
        ft.commit();
    }
}
