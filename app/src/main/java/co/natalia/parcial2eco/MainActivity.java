package co.natalia.parcial2eco;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button OkBtn;
    private EditText Puntaje;
    private TextView ActualQuestion;
    private FirebaseDatabase db;
    private String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OkBtn = findViewById(R.id.OKBtn);
        Puntaje = findViewById(R.id.Puntaje);
        ActualQuestion = findViewById(R.id.ActualQuestion);

        db = FirebaseDatabase.getInstance();

        loadDatabase();
        OkBtn.setOnClickListener(this);
    }

    public void loadDatabase(){
        DatabaseReference ref = db.getReference().child("Preguntas");
        ref.addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot child : snapshot.getChildren()) {
                            Pregunta question = child.getValue(Pregunta.class);

                            if(question.getEstado().equals("actual")){
                                uid = question.getId();
                                ActualQuestion.setText(question.getDescrQuestion());
                            } else {
                                ActualQuestion.setText("No hay pregunta actual");

                            }

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }


                }
        );
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.OKBtn :
                DatabaseReference ref = db.getReference().child("Puntajes").push();

                Puntaje score = new Puntaje(
                  uid,
                  ref.getKey(),
                  Puntaje.getText().toString()
                );

                ref.setValue(score);
                break;
        }
    }
}