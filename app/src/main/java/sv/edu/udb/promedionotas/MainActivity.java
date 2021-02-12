package sv.edu.udb.promedionotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    // Josué Villeda        VC170991
    // Chantell Alvarenga   AA170621

    private EditText name;
    private EditText nota1;
    private EditText nota2;
    private EditText nota3;
    private TextView tvValidator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText)findViewById(R.id.name);
        nota1=(EditText)findViewById(R.id.nota1);
        nota2=(EditText)findViewById(R.id.nota2);
        nota3=(EditText)findViewById(R.id.nota3);
        tvValidator=(TextView) findViewById(R.id.tvValidator);
    }

    public void ResultadosActividad (View v) {
        Intent i=new Intent(this, Resultados_activity.class);
        i.putExtra("txtName", name.getText().toString());
        i.putExtra("txtNota1", nota1.getText().toString());
        i.putExtra("txtNota2", nota2.getText().toString());
        i.putExtra("txtNota3", nota3.getText().toString());
        startActivity(i);

        name.setText("");
        nota1.setText("");
        nota2.setText("");
        nota3.setText("");
        tvValidator.setText("");

    }
}