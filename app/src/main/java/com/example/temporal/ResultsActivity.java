package com.example.temporal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ResultsActivity extends AppCompatActivity {

    private List<Question> questionList;
    private TextView messageTextView;
    Button Botonahome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        questionList = (List<Question>) getIntent().getSerializableExtra("questionList");
        int score = getIntent().getIntExtra("score", 0);

        TextView scoreTextView = findViewById(R.id.scoreTextView);
        scoreTextView.setText("Puntaje: " + score+"/5");

        messageTextView = findViewById(R.id.messageTextView);

        if(score == 0){
            messageTextView.setText("¡Sigue estudiando! Te queda un largo camino");
        } else if (score == 1) {
            messageTextView.setText("¡No te rindas! Todos empezamos por algún lado");
        } else if (score == 2) {
            messageTextView.setText("¡Puedes mejorar!");
        } else if (score == 3) {
            messageTextView.setText("¡Estas por medio camino!");
        } else if (score == 4) {
            messageTextView.setText("¡Muy bien!");
        } else if (score == 5) {
            messageTextView.setText("¡Felicidades!, tienes un buen futuro ");
        }
        else{
            messageTextView.setText("¡Felicidades!");
        }

        TextView resultsTextView = findViewById(R.id.resultsTextView);
        resultsTextView.setText(generateResultsText());

        Botonahome = findViewById(R.id.btnregresar);

        Botonahome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_main = new Intent(ResultsActivity.this, home.class);
                startActivity(intent_main);
            }
        });

    }

    private String generateResultsText() {
        StringBuilder resultsText = new StringBuilder();
        for (int i = 0; i < questionList.size(); i++) {
            Question question = questionList.get(i);
            String status = question.isCorrect() ? "Correcta" : "Incorrecta";
            resultsText.append("Pregunta ").append(i + 1).append(": ").append(status).append("\n");
        }
        return resultsText.toString();
    }
}