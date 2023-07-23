package apps.utp.SuperTest;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import apps.utp.SuperTest.R;

public class home extends AppCompatActivity {
    Button Boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Boton = findViewById(R.id.button);

        Boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_main = new Intent(home.this, MainActivity.class);
                startActivity(intent_main);
            }
        });

    }
}