package jp.harhogefoo.fragmentsample;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import layout.main;
import model.Counter;

public class MainActivity extends AppCompatActivity implements main.OnFragmentInteractionListener {
    private int COUNTER_NUM = 4;
    Counter[] counterArray = new Counter[COUNTER_NUM];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i=0; i<counterArray.length; i++) {
            counterArray[i] = new Counter();
        }

        // protect re-attach fragment when activity is restarted.
        // Fragment state is restored by super.onCreate(savedInstanceState
        if (savedInstanceState == null) {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            // arg1: attached layout
            transaction.add(R.id.container, new main());
            transaction.commit();
        }
    }

    @Override
    public void onFragmentInteraction(Button button) {
        counterArray[0].setCount(Integer.parseInt(button.getText().toString()));
        Log.d(counterArray.toString(), String.valueOf(counterArray[0].getCount()));
    }
}