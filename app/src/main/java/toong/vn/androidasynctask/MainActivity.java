package toong.vn.androidasynctask;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_start_second_activity).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                        startSecondActivity();
                    }
                });

        findViewById(R.id.button_start_ansyctask).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AAsyncTask().execute();
            }
        });
    }

    private void startSecondActivity() {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }

    static class AAsyncTask extends AsyncTask<Void, Void, Void> {
        String TAG = getClass().getSimpleName();

        @Override
        protected Void doInBackground(Void... voids) {
            int i = 0;
            while (i < 12) {
                Log.i(TAG, "" + Thread.currentThread().getName() + " : " + i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Log.i(TAG, "" + Thread.currentThread().getName() + " onPostExecute");
            super.onPostExecute(aVoid);
        }
    }
}
