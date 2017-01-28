package com.example.jholland20.myapp;

import android.os.CountDownTimer;
import android.os.Handler;
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
import java.util.Queue;

public class MainActivity extends AppCompatActivity {

    Button left;
    Button right;
    Button forward;
    Button back;
    Button wait;
    Button run;
    int x = 0;
    int y = 3;
    Button erase;
    Boolean g;
    ArrayList<Block_Input> bi;
    Button[][] r = new Button[3][7];

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    final String FORWARD = "Forward";
    final String BACKWARD = "Back";
    final String UP = "Up";
    final String DOWN = "Down";
    final String WAIT = "Wait";
    final String ERASE = "Erase";
    final String ROBOT = "Robot";
    final String GEAR = "Gear";
    final String SHIP = "Ship";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r [0][0] = (Button) findViewById(R.id.button12);
        r [1][0] = (Button) findViewById(R.id.button13);
        r [2][0] = (Button) findViewById(R.id.button14);
        r [0][1] = (Button) findViewById(R.id.button15);
        r [0][2] = (Button) findViewById(R.id.button4);
        r [0][3] = (Button) findViewById(R.id.button9);
        r [0][4] = (Button) findViewById(R.id.button5);
        r [0][5] = (Button) findViewById(R.id.button16);
        r [0][6] = (Button) findViewById(R.id.button20);
        r [1][1] = (Button) findViewById(R.id.button23);
        r [1][2] = (Button) findViewById(R.id.button3);
        r [1][3] = (Button) findViewById(R.id.button11);
        r [1][4] = (Button) findViewById(R.id.button10);
        r [1][5] = (Button) findViewById(R.id.button18);
        r [1][6] = (Button) findViewById(R.id.button21);
        r [2][1] = (Button) findViewById(R.id.button25);
        r [2][2] = (Button) findViewById(R.id.button8);
        r [2][3] = (Button) findViewById(R.id.button7);
        r [2][4] = (Button) findViewById(R.id.button6);
        r [2][5] = (Button) findViewById(R.id.button19);
        r [2][6] = (Button) findViewById(R.id.button17);


        r[x][y].setText(ROBOT);
        r[1][3].setText(GEAR);
        r[2][3].setText(SHIP);

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
        run.setText("Run");
        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < bi.size(); i++) {
                    Log.e("String", bi.get(i).getAction());
                    String action = bi.get(i).getAction();

                    Queue<Block_Input> qbi = new

                    r[x][y].setText("");
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
                            r[x][y].setText(SHIP);
                            break;
                    }
                    //r[x][y].setText(ROBOT);
                    // Call this method directly from java file

                    int secs = 2; // Delay in seconds

                    Utils.delay(secs, new Utils.DelayCallback() {
                        @Override
                        public void afterDelay() {
                            // Do something after delay

                            r[x][y].setText(ROBOT);
                        }
                    });
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
        if (y + 1 < 7) {
            r[x][y].setText("");
            y++;
            r[2][3].setText(SHIP);
            if (x == 1) {
                if (y == 3) {
                    g = (true);
                }
            }
            if (x == 2) {
                if (y == 3) {
                    if (g) {
                        bi.clear();
                        x = 0;
                        y = 3;
                        r[x][y].setText(ROBOT);
                        r[1][3].setText(GEAR);
                        r[2][3].setText(SHIP);
                        g = (false);
                    }
                }
            }
        }
    }

    public void goUp() {
        if (y - 1 > -1) {
            r[x][y].setText("");
            y--;
            r[2][3].setText(SHIP);
            if (x == 1) {
                if (y == 3) {
                    g = (true);
                }
            }
            if (x == 2) {
                if (y == 3) {
                    if (g) {
                        bi.clear();
                        x = 0;
                        y = 3;
                        r[x][y].setText(ROBOT);
                        r[1][3].setText(GEAR);
                        r[2][3].setText(SHIP);
                        g = (false);
                    }
                }
            }
        }
    }

    public void goForward() {
        if (x + 1 < 3) {
            r[x][y].setText("");
            x++;
            r[2][3].setText(SHIP);
            if (x == 1) {
                if (y == 3) {
                    g = (true);
                }

            }
        }
        if (x == 2) {
            if (y == 3) {
                if (g) {
                    bi.clear();
                    x = 0;
                    y = 3;
                    r[x][y].setText(ROBOT);
                    r[1][3].setText(GEAR);
                    r[2][3].setText(SHIP);
                    g = (false);
                }
            }
        }
    }

    public void goBackward() {
        if (x - 1 > -1) {
            r[x][y].setText("");
            x--;
            r[2][3].setText(SHIP);
            if (x == 1) {
                if (y == 3) {
                    g = (true);
                }
            }
            if (x == 2) {
                if (y == 3) {
                    if (g) {
                        bi.clear();
                        x = 0;
                        y = 3;
                        r[x][y].setText(ROBOT);
                        r[1][3].setText(GEAR);
                        r[2][3].setText(SHIP);
                        g = (false);
                    }
                }
            }
        }
    }

}