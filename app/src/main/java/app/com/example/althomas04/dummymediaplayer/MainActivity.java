package app.com.example.althomas04.dummymediaplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private Button playButton, pauseButton, skipButton, resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.temple);
        playButton = (Button) findViewById(R.id.play_button);
        pauseButton = (Button) findViewById(R.id.pause_button);
        skipButton = (Button) findViewById(R.id.skip_button);
        resetButton = (Button) findViewById(R.id.reset_button);
        pauseButton.setEnabled(false);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Playing sound",Toast.LENGTH_SHORT).show();
                mediaPlayer.start();
                playButton.setEnabled(false);
                pauseButton.setEnabled(true);
                skipButton.setEnabled(true);
                resetButton.setEnabled(true);
            }
        });
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Paused",Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();
                pauseButton.setEnabled(false);
                playButton.setEnabled(true);
                skipButton.setEnabled(false);
                resetButton.setEnabled(false);
            }
        });
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Skipped", Toast.LENGTH_SHORT).show();
                mediaPlayer.seekTo(29000);
                skipButton.setEnabled(false);
                pauseButton.setEnabled(true);
                playButton.setEnabled(false);
            }
        });
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Replayed", Toast.LENGTH_SHORT).show();
                mediaPlayer.seekTo(0);
                skipButton.setEnabled(true);
                pauseButton.setEnabled(true);
                playButton.setEnabled(false);
            }
        });
    }
}
