package io.weichao.wav_player;

import android.app.AlertDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    static {
        System.loadLibrary("WAV_Player");
    }

    private native void play(String fileName) throws IOException;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File file = new File(Environment.getExternalStorageDirectory(),
                "8k16bitpcm.wav");
        PlayTask playTask = new PlayTask();
        playTask.execute(file.getAbsolutePath());
    }

    private class PlayTask extends AsyncTask<String, Void, Exception> {
        protected Exception doInBackground(String... file) {
            Exception result = null;

            try {
                play(file[0]);
            } catch (IOException ex) {
                result = ex;
            }

            return result;
        }

        protected void onPostExecute(Exception ex) {
            if (ex != null) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Error Occurred")
                        .setMessage(ex.getMessage()).show();
            }
        }
    }
}
