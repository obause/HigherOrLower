package obause.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    int randomNumber;

    public void fade(ImageView imageView, boolean visibility) {
        if (visibility) {
            imageView.animate().alpha(1).setDuration(500);
        }
        else {
            imageView.animate().alpha(0).setDuration(500);
        }
    }

    public void generateRandomNumber () {
        Random random = new Random();
        randomNumber = random.nextInt(20);
        Log.i("NUMBER", Integer.toString(randomNumber));
    }

    public void guess(View view) {

        ImageView ivCheck = findViewById(R.id.imageViewCheck);
        ImageView ivLower = findViewById(R.id.imageViewLower);
        ImageView ivHigher = findViewById(R.id.imageViewHigher);

        fade(ivCheck, false);
        fade(ivHigher, false);
        fade(ivLower, false);

        int guessValue = Integer.parseInt(editText.getText().toString());
        String message;

        if (guessValue > randomNumber) {
            message = "Niedriger!";
            fade(ivLower, true);
        }
        else if (guessValue < randomNumber) {
            message = "Höher";
            fade(ivHigher, true);
        }
        else if (guessValue == randomNumber) {
            message = "Richtig! Neue Runde...";
            generateRandomNumber();
            fade(ivCheck, true);
        }
        else {
            message = "Fehler";
        }
        editText.getText().clear();
        textView.setText(message);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("INFO", "App started.");

        editText = findViewById(R.id.editTextNumber);
        textView = findViewById(R.id.textView);
        generateRandomNumber();

    }
}