package sv.edu.udb.aumentosalario_dsm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Josué Villeda        VC170991
    // Chantell Alvarenga   AA170621
    // Kevin Castillo       CH170823

    private EditText salary;
    private EditText years;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        salary=(EditText)findViewById(R.id.salary);
        years=(EditText)findViewById(R.id.years);
    }

    public void ResultadosActividad (View v) {

        Double Salary = Double.parseDouble(salary.getText().toString());
        Double Years = Double.parseDouble(years.getText().toString());

        if ( salary.getText().toString().trim().length() < 0 || years.getText().toString().trim().length() < 0 ) {
            Toast notificacion = Toast.makeText(this,"Debe ingresar los datos solicitados",Toast.LENGTH_LONG);
            notificacion.show();

        } else if (Salary < 100.0) {
            Toast notificacion2 = Toast.makeText(this,"El Salario no debe ser menor a $100.0",Toast.LENGTH_LONG);
            notificacion2.show();
        } else if (Salary < 0.0 || Years < 0.0){
            Toast notificacion3 = Toast.makeText(this,"Los valores no pueden ser negativos",Toast.LENGTH_LONG);
            notificacion3.show();
        } else {
            Intent i=new Intent(this, Resultados.class);
            i.putExtra("txtSalary", salary.getText().toString());
            i.putExtra("txtYears", years.getText().toString());
            startActivity(i);

            salary.setText("");
            years.setText("");
        }

    }
}