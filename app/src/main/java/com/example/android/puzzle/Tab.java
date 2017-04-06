package com.example.android.puzzle;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class Tab extends TabActivity {
    private static final String ONE = "Level 1";
    private static final String TWO = "Level 2";
    private static final String THREE = "Level 3";
    private static final String FOUR = "Level 4";
    private static final String FIVE = "Level 5";
    private static final String SIX = "Level 6";
    private static final String SEVEN = "Level 7";
    private static final String EIGHT = "Level 8";
    private static final String NINE = "Level 9";
    private static final String TEN = "Level 10";
    private static final String ELEVEN = "Level 11";
    private static final String TWELVE = "Level 12";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        TabHost tabHost = getTabHost();

        // Inbox Tab
        TabHost.TabSpec oneone = tabHost.newTabSpec(ONE);
        oneone.setIndicator(ONE, getResources().getDrawable(R.drawable.icon_inbox));
        Intent inboxIntent = new Intent(this, Main2Activity.class);
        // Tab Content
        oneone.setContent(inboxIntent);

        // Outbox Tab
        TabHost.TabSpec onetwo = tabHost.newTabSpec(TWO);
        onetwo.setIndicator(TWO, getResources().getDrawable(R.drawable.icon_inbox));
        Intent outboxIntent = new Intent(this, level2.class);
        onetwo.setContent(outboxIntent);

        /*// Profile Tab
        TabHost.TabSpec onethree = tabHost.newTabSpec(THREE);
        onethree.setIndicator(THREE, getResources().getDrawable(R.drawable.icon_inbox));
        Intent profileIntent = new Intent(this, level2.class);
        onethree.setContent(profileIntent);

        // Inbox Tab
        TabHost.TabSpec four = tabHost.newTabSpec(FOUR);
        four.setIndicator(FOUR, getResources().getDrawable(R.drawable.icon_inbox));
        Intent inboxIntent4 = new Intent(this, level2.class);
        // Tab Content
        four.setContent(inboxIntent4);

        // Inbox Tab
        TabHost.TabSpec five = tabHost.newTabSpec(FIVE);
        five.setIndicator(FIVE, getResources().getDrawable(R.drawable.icon_inbox));
        Intent inboxIntent5 = new Intent(this, level2.class);
        // Tab Content
        five.setContent(inboxIntent5);

        // Inbox Tab
        TabHost.TabSpec six = tabHost.newTabSpec(SIX);
        six.setIndicator(SIX, getResources().getDrawable(R.drawable.icon_inbox));
        Intent inboxIntent6 = new Intent(this, level2.class);
        // Tab Content
        six.setContent(inboxIntent6);

        // Inbox Tab
        TabHost.TabSpec seven = tabHost.newTabSpec(SEVEN);
        seven.setIndicator(SEVEN, getResources().getDrawable(R.drawable.icon_inbox));
        Intent inboxIntent7 = new Intent(this, level2.class);
        // Tab Content
        seven.setContent(inboxIntent7);

        // Inbox Tab
        TabHost.TabSpec eight = tabHost.newTabSpec(EIGHT);
        eight.setIndicator(EIGHT, getResources().getDrawable(R.drawable.icon_inbox));
        Intent inboxIntent8 = new Intent(this, level2.class);
        // Tab Content
        eight.setContent(inboxIntent8);

        // Inbox Tab
        TabHost.TabSpec nine = tabHost.newTabSpec(NINE);
        nine.setIndicator(NINE, getResources().getDrawable(R.drawable.icon_inbox));
        Intent inboxIntent9 = new Intent(this, level2.class);
        // Tab Content
        nine.setContent(inboxIntent9);

        // Inbox Tab
        TabHost.TabSpec ten = tabHost.newTabSpec(TEN);
        ten.setIndicator(TEN, getResources().getDrawable(R.drawable.icon_inbox));
        Intent inboxIntent10 = new Intent(this, level2.class);
        // Tab Content
        ten.setContent(inboxIntent10);

        // Inbox Tab
        TabHost.TabSpec eleven = tabHost.newTabSpec(ELEVEN);
        eleven.setIndicator(ELEVEN, getResources().getDrawable(R.drawable.icon_inbox));
        Intent inboxIntent11 = new Intent(this, level2.class);
        // Tab Content
        eleven.setContent(inboxIntent11);

        // Inbox Tab
        TabHost.TabSpec twelve = tabHost.newTabSpec(TWELVE);
        twelve.setIndicator(TWELVE, getResources().getDrawable(R.drawable.icon_inbox));
        Intent inboxIntent12 = new Intent(this, level2.class);
        // Tab Content
        twelve.setContent(inboxIntent12);*/

        // Adding all TabSpec to TabHost
        tabHost.addTab(oneone); // Adding Inbox tab
        tabHost.addTab(onetwo); // Adding Outbox tab
        /*tabHost.addTab(onethree); // Adding Profile tab
        tabHost.addTab(four);
        tabHost.addTab(five);
        tabHost.addTab(six);
        tabHost.addTab(seven);
        tabHost.addTab(eight);
        tabHost.addTab(nine);
        tabHost.addTab(ten);
        tabHost.addTab(eleven);
        tabHost.addTab(twelve);*/

    }
}

