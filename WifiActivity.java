package com.glinb.michaelwang.myhtctest;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by michael.wang on 2015/4/11.
 */
public class WifiActivity extends ActionBarActivity{
    private final IntentFilter intentFilter=new IntentFilter();
    private WifiP2pManager.Channel mChannel;
    private WifiP2pManager mManager;
    private BroadcastReceiver mReceiver;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context= null; // Needs to initialize variable context.
        //public final Context context= new Context ();
        //Indicates a change in the Wi-Fi P2P status.
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION);
        // Indicates a change in the list of available peers.
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION);
        // Indicates the state of Wi-Fi P2P connectivity has changed.
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION);
        // Indicates this device's details have changed.
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION);

        mManager=(WifiP2pManager) context.getSystemService(Context.WIFI_P2P_SERVICE);
        mChannel=mManager.initialize(this,context.getMainLooper(),null);
        mReceiver= new WifiDirectBroadcastReceiver(mManager,mChannel,this);


    }
    @Override
    public void onResume(){
        super.onResume();
        receiver = new WiFiDirectBroadcastReceiver(mManager, mChannel, this);
        registerReceiver(receiver, intentFilter);
    }
    @Override
    public void onPause(){
        super.onPause();
        unregisterReceiver(receiver);
    }
}
