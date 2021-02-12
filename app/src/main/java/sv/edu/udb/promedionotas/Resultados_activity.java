package sv.edu.udb.promedionotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Resultados_activity extends AppCompatActivity {

    // Josué Villeda        VC170991
    // Chantell Alvarenga   AA170621

    private TextView tvName;
    private TextView nota1_result;
    private TextView nota2_result;
    private TextView nota3_result;
    private TextView tvPromedio;
    private TextView tvResult;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados_activity);

        tvName = (TextView)findViewById(R.id.tvName);
        nota1_result = (TextView)findViewById(R.id.nota1_result);
        nota2_result = (TextView)findViewById(R.id.nota2_result);
        nota3_result = (TextView)findViewById(R.id.nota3_result);
        tvPromedio = (TextView) findViewById(R.id.tvPromedio);
        tvResult = (TextView) findViewById(R.id.tvResult);

        getGrades();

    }

    public void getGrades(){
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("txtName");
        String nota1 = bundle.getString("txtNota1");
        String nota2 = bundle.getString("txtNota2");
        String nota3 = bundle.getString("txtNota3");

        RenderGradesResults(name,nota1,nota2,nota3);
    }

    public void RenderGradesResults(String name, String nota1, String nota2, String nota3){

        tvName.setText("Nombre: " + name);
        nota1_result.setText("Nota: " + nota1);
        nota2_result.setText("Nota: " + nota2);
        nota3_result.setText("Nota: " + nota3);

        Double Nota1 = Double.parseDouble(nota1);
        Double Nota2 = Double.parseDouble(nota2);
        Double Nota3 = Double.parseDouble(nota3);
        Double promedio = (Nota1+Nota2+Nota3)/3;

        String status = "";

        if(promedio <= 5){
            status = "Reprobado";

        } else if( promedio > 5 && promedio < 7){
            status = "Regular";

        } else if( promedio > 7 && promedio <= 10){
            status = "Excelente";
        }

        tvPromedio.setText("Promedio: " + promedio.toString() );
        tvResult.setText("Estado: " + status);
    }

    public void BackToMain(View v){
            this.onBackPressed();
    }
}