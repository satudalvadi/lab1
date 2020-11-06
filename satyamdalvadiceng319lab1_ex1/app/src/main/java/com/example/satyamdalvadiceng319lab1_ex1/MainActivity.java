package com.example.satyamdalvadiceng319lab1_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public TopFrag nFrag = null;
    public BotFrag bFrag = null;

      String[] act = new String[] {"AIActivity","VRActivity"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast toast = Toast.makeText(this.getApplicationContext(), getString(R.string.create), Toast.LENGTH_LONG);
        toast.show();

        nFrag = (TopFrag)getSupportFragmentManager(). findFragmentById(R.id.topFrag) ;
        bFrag = (BotFrag)getSupportFragmentManager(). findFragmentById(R.id.botFrag);

        ListView topLv = nFrag.getView().findViewById(android.R.id.list);
        ArrayAdapter<String> topLvAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, act);
        topLv.setAdapter(topLvAdapter);

        topLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String act1 = act[i];
                Intent r;
                switch(act1) {
                    case "AIActivity":
                        Intent q = new Intent(view.getContext(), AIActivity.class);
                        startActivity(q);
                        break;
                    case "VRActivity":
                        Intent t  = new Intent(view.getContext(), VRActivity.class);
                        startActivity(t);
                        break;

                }
            }
        });

        TextView nLifeCyleList = bFrag.getView().findViewById(R.id.LifecycleList);
        nLifeCyleList.setText(nLifeCyleList.getText()+ "\nonCreate():Finished");
    }
    @Override
    protected void onStart(){
        super.onStart();
        TextView nLifeCyleList = bFrag.getView().findViewById(R.id.LifecycleList);
        nLifeCyleList.setText(nLifeCyleList.getText()+ "\nonStart():Finished");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        TextView nLifeCyleList = bFrag.getView().findViewById(R.id.LifecycleList);
        nLifeCyleList.setText(nLifeCyleList.getText()+ "\nonDestroy():Finished");
    }
}