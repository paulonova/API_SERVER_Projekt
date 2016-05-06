package paulo.android.nackademin.api_server_projekt;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class API_MainActivity extends AppCompatActivity {

    TextView output;
    ProgressBar pb;

    /*
    * When the list are equals ZERO on preExecute ==> setVisible
    * When the list are != ZERO onPostExecute ==> setINVISIBLE*/
    List<MyTask> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api__main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //
        pb = (ProgressBar) findViewById(R.id.progressBar1);
        pb.setVisibility(View.INVISIBLE);

        //List to store references from all my tasks..
        tasks = new ArrayList<>();

        //Initialize the TextView for vertical scrolling
        output = (TextView) findViewById(R.id.textView);
        output.setMovementMethod(new ScrollingMovementMethod());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isOnLine()){
                    requestData();
                }else {
                    Toast.makeText(getApplicationContext(), "Network isn´t available!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    //Code to request the informations
    private void requestData() {
        MyTask task = new MyTask();
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "Param1", "Param2", "Param3");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_api__main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            output.setText("");
        }

        return super.onOptionsItemSelected(item);
    }

    protected void updateDisplay(String message){
        output.append(message + "\n");
    }

    protected boolean isOnLine(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();

        //Checking the Connection..
        if(netInfo != null && netInfo.isConnectedOrConnecting()){
            return true;
        }else {
            return false;
        }
    }



    // Params, Progress, Result need to be declared
    private class MyTask extends AsyncTask<String, String, String>{

        //Execute before doInBackground()
        @Override
        protected void onPreExecute() {
           updateDisplay("Starting task..");

            if(tasks.size() == 0){
                pb.setVisibility(View.VISIBLE);
            }
            tasks.add(this);

        }

        @Override //result              params
        protected String doInBackground(String... params) {

            for (int i = 0; i <params.length ; i++) {
                publishProgress("Working with " + params[i]);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return "Task complete!";
        }

        @Override
        protected void onPostExecute(String result) {
            updateDisplay(result);

            tasks.remove(this);
            if(tasks.size() == 0){
                pb.setVisibility(View.INVISIBLE);
            }

        }


        @Override
        protected void onProgressUpdate(String... values) {
            updateDisplay(values[0]);
        }
    }







}
