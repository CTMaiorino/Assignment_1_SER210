package edu.quinnipiac.ser210.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StartActivity extends Activity {

    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        configurePlayButton();

    }

    private void configurePlayButton(){
        Button playButton = (Button) findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.user_name);
                message = editText.getText().toString();
                Intent intent = new Intent(StartActivity.this, PlayActivity.class);
                intent.putExtra("USER_NAME", message);
                startActivity(intent);
            }
        });
    }

}
