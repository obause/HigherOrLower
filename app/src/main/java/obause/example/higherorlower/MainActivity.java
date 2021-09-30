package obause.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    int randomNumber;

    public void generateRandomNumber () {
        Random random = new Random();
        randomNumber = random.nextInt(20);
    }

    public void guess(View view) {

        int guessValue = Integer.parseInt(editText.getText().toString());
        String message;

        if (guessValue > randomNumber && guessValue <= 20) {
            message = "Niedriger!";
        }
        else if (guessValue < randomNumber && guessValue <= 1) {
            message = "Höher";
        }
        else if (guessValue == randomNumber) {
            message = "Richtig! Neue Runde...";
            generateRandomNumber();
        }
        else {
            message = "Zahl ist außerhalb von 1 bis 20";
        }
        editText.getText().clear();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextNumber);
        generateRandomNumber();
    }
}