package com.glinb.michaelwang.myhtctest;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.content.BroadcastReceiver;



public class WifiDirectBroadcastReceiver extends BroadcastReceiver {
    //private final IntentFilter intentFilter=new IntentFilter();
private WifiP2pManager.Channel mChannel;
private WifiP2pManager mManager;
private BroadcastReceiver mReceiver;
    public WifiDirectBroadcastReceiver(WifiP2pManager manager,WifiP2pManager.Channel channel, BroadcastReceiver receiver){
    super();
    this.mManager=manager;
    this.mChannel=channel;
    this.mReceiver=receiver;
    }



   /* @Override
    //public void onCreate(Bundle savedInstanceState) {
        //Context context; // Needs to initialize variable context.
 //public final Context context=new Context ();
        //Indicates a change in the Wi-Fi P2P status.
        //intentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION);
        // Indicates a change in the list of available peers.
        //intentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION);
        // Indicates the state of Wi-Fi P2P connectivity has changed.
        //intentFilter.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION);
        // Indicates this device's details have changed.
        //intentFilter.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION);

        //mManager=(WifiP2pManager) context.getSystemService(Context.WIFI_P2P_SERVICE);
        //mChannel=mManager.initialize(this,context.getMainLooper(),null);
        //mReceiver= new WifiDirectBroadcastReceiver(mManager,mChannel,this);
   }*/

    @Override
    public void onReceive(Context context, Intent intent){
        String action=intent.getAction();

    if (WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION.equals(action)){
    //Determine if Wifi P2P mode is enabled or not, alert
        // the Activity.
        // what Activity is alerted?
       int state = intent.getIntExtra(WifiP2pManager.EXTRA_WIFI_STATE,-1);
        if (state==WifiP2pManager.WIFI_P2P_STATE_ENABLED) {
            //Wifi P2P is enabled}

            //receiver.setIsWifiP2pEnabled(true);
        } else {
        //receiver.setIsWifiP2pEnabled(false);
            }
        }else if(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION.equals(action)){
            // The peer list has changed!  We should probably do something about
            // that.
        }else if (WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION.equals(action)){
            // Connection state changed!  We should probably do something about
            // that.
        }else if (WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION.equals(action)){
            /*DeviceListFragment fragment=(DeviceListFragment) activity.getFragmentManager().findFragmentById(R.id.frag_list);
            fragment.updateThisDevice(WifiP2pDevice) intent.getParcelableExtra(WifiP2pManager.EXTRA_WIFI_P2P_DEVICE));*/
        }
    }
        /** register the BroadcastReceiver with the intent values to be matched */
    /*@Override
    protected void onResume(){
            super.onResume();
            registerReceiver(receiver, intentFilter);
        }
    @Override
    protected void onPause(){
            super.onPause();
            unregisterReceiver(receiver);
        }*/

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }*/

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
