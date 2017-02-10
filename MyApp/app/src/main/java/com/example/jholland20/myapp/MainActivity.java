package com.example.jholland20.myapp;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {

    Button left;
    Button right;
    Button forward;
    Button back;
    Button wait;
    Button run;
    Button erase;
    Boolean g;
    ArrayList<Block_Input> bi;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    final String FORWARD = "Forward";
    final String BACKWARD = "Back";
    final String UP = "Up";
    final String DOWN = "Down";
    final String WAIT = "Wait";
    final String ERASE = "Erase";
    final String RUN = "Run";
    final String ROBOT = "Robot";
    final String GEAR = "Gear";
    final String SHIP = "Ship";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        g = (false);

        bi = new ArrayList<Block_Input>();

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(bi);
        mRecyclerView.setAdapter(mAdapter);

        run = (Button) findViewById(R.id.runButton);
        run.setText(RUN);
        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < bi.size(); i++) {
                    Log.e("String", bi.get(i).getAction());
                    String action = bi.get(i).getAction();

                    switch (action) {
                        case FORWARD:
                            goForward();
                            break;
                        case BACKWARD:
                            goBackward();
                            break;
                        case UP:
                            goUp();
                            break;
                        case DOWN:
                            goDown();
                            break;
                        case WAIT:
                            break;
                    }

                }
                    bi.clear();
                    // specify an adapter (see also next example)
                    mAdapter = new MyAdapter(bi);
                    mRecyclerView.setAdapter(mAdapter);

            }
        });



        forward = (Button) findViewById(R.id.forwardButton);
        forward.setText(FORWARD);
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bi.add(new Block_Input((FORWARD)));
                // specify an adapter (see also next example)
                mAdapter = new MyAdapter(bi);
                mRecyclerView.setAdapter(mAdapter);
            }
        });

        back = (Button) findViewById(R.id.backButton);
        back.setText(BACKWARD);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bi.add(new Block_Input((BACKWARD)));
                // specify an adapter (see also next example)
                mAdapter = new MyAdapter(bi);
                mRecyclerView.setAdapter(mAdapter);
            }
        });

        left = (Button) findViewById(R.id.leftButton);
        left.setText(DOWN);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bi.add(new Block_Input((DOWN)));
                // specify an adapter (see also next example)
                mAdapter = new MyAdapter(bi);
                mRecyclerView.setAdapter(mAdapter);
            }
        });

        right = (Button) findViewById(R.id.rightButton);
        right.setText(UP);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bi.add(new Block_Input((UP)));
                // specify an adapter (see also next example)
                mAdapter = new MyAdapter(bi);
                mRecyclerView.setAdapter(mAdapter);

            }
        });


        wait = (Button) findViewById(R.id.waitButton);
        wait.setText(WAIT);
        wait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bi.add(new Block_Input((WAIT)));
                // specify an adapter (see also next example)
                mAdapter = new MyAdapter(bi);
                mRecyclerView.setAdapter(mAdapter);
            }
        });


        erase = (Button) findViewById(R.id.erase);
        erase.setText(ERASE);
        erase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               bi.clear();
                mAdapter = new MyAdapter(bi);
                mRecyclerView.setAdapter(mAdapter);
            }
        });


                        LinearLayoutManager layoutManager
                        = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        RecyclerView myList = (RecyclerView) findViewById(R.id.my_recycler_view);
        myList.setLayoutManager(layoutManager);


    }

    public void goDown() {

    }
    public void goUp() {

    }
    public void goForward() {

    }
    public void goBackward() {

    }
}
