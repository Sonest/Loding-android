package com.olycloud.progressbar;

import com.olycloud.view.HorizontalProgressbarWithProgress;
import com.olycloud.view.RoundProgressBarWidthProgress;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {
	private static final int MSG_UPDATE = 0X110;
	
	private Handler mHandler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			int progress = mHProgress.getProgress();
			int Rprogress = mRProgress.getProgress();
			
			mHProgress.setProgress(++progress);
			mRProgress.setProgress(++Rprogress);
			if(progress>=100){
				mHandler.removeMessages(MSG_UPDATE);
			}else{
				mHandler.sendEmptyMessageDelayed(MSG_UPDATE, 100);
				
			}
		}
	};
	private RoundProgressBarWidthProgress mRProgress;
	private HorizontalProgressbarWithProgress mHProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRProgress = (RoundProgressBarWidthProgress) findViewById(R.id.id_progress02);
        mHProgress = (HorizontalProgressbarWithProgress) findViewById(R.id.id_progress01);
        mHandler.sendEmptyMessage(MSG_UPDATE);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
