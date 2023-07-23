package apps.utp.SuperTest;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import apps.utp.SuperTest.R;

public class MainActivity extends AppCompatActivity {

    private List<Question> questionList;
    private QuestionAdapter questionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView questionsRecyclerView = findViewById(R.id.questionsRecyclerView);
        questionsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        questionList = new ArrayList<>();
        questionList.add(new Question("Pregunta #1\nEn la caja del seguro social queremos saber si un paciente es jubilado, ¿qué información se pide?", new String[]{"Edad", "Año actual", "Medicamentos", "Nombre"}, 0));
        questionList.add(new Question("Pregunta #2\n¿Si la salida de mi cálculo es 2, cuáles son las posibles entradas para que la suma de esas entradas coincida con la salida?", new String[]{"1 y 100", "1 y 10", "1 y 1", "2 y 2"}, 2));
        questionList.add(new Question("Pregunta #3\n¿Para saber si el estudiante de la UTP está matriculado, qué documento se podría ingresar como entrada de comprobación?", new String[]{"Constancia de matrícula", "Ingreso mensual", "Pasaporte", "Horario de grupo"}, 0));
        questionList.add(new Question("Pregunta #4\n¿Si se desea ingresar al sistema de matrícula de la UTP, cuál sería la entrada para poder acceder al sistema?", new String[]{"Token", "Cédula y contraseña", "Correo electrónico y contraseña", "Nombre y contraseña"}, 1));
        questionList.add(new Question("Pregunta #5\n¿Cuál es el area de un romboide si mi diagonal mayor es de 16 y mi diagonal menor es de 12?", new String[]{"38", "45", "96", "114"}, 2));
        // Agrega más preguntas según sea necesario

        questionAdapter = new QuestionAdapter(this, questionList);
        questionsRecyclerView.setAdapter(questionAdapter);
////////////////////////////////////////////////////////////////////////////////////////////////////


        Button submitBtn = findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(v -> {
            if (areAllQuestionsAnswered()) {
                showResults();
            } else {
                Toast.makeText(this, "Por favor, responda todas las preguntas", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean areAllQuestionsAnswered() {
        for (Question question : questionList) {
            if (!question.isAnswered()) {
                return false;
            }
        }
        return true;
    }

    private void showResults() {
        int score = calculateScore();
        Intent intent = new Intent(MainActivity.this, ResultsActivity.class);
        intent.putExtra("questionList", new ArrayList<>(questionList));
        intent.putExtra("score", score);
        startActivity(intent);
    }

    private int calculateScore() {
        int score = 0;
        for (Question question : questionList) {
            if (question.isCorrect()) {
                score++;
            }
        }
        return score;
    }
}