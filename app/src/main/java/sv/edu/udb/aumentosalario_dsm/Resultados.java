package sv.edu.udb.aumentosalario_dsm;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import android.os.Bundle;

public class Resultados extends AppCompatActivity {

    private TextView tvOriginData;
    private TextView tvNewSalary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        tvOriginData = (TextView)findViewById(R.id.tvOriginData);
        tvNewSalary = (TextView)findViewById(R.id.tvNewSalary);

        getData();
    }

    public void getData(){
        Bundle bundle = getIntent().getExtras();
        String salary = bundle.getString("txtSalary");
        String years = bundle.getString("txtYears");

        RenderResults(salary,years);
    }

    public void RenderResults(String salary, String years){

        tvOriginData.setText("Salario: $ "+ salary + "  Años de antiguedad: " + years);

        Double Salary = Double.parseDouble(salary);
        Double Years = Double.parseDouble(years);

        Double NewSalary = 0.0;

        if(Salary < 500 && Years >= 10){ //sueldo es inferior a 500 y su antigüedad es igual o superior a 10 años, otorgarle un aumento del 20 %
            NewSalary = Salary + (Salary * 0.20);

        } else if(Salary < 500 && Years < 10){ //sueldo es inferior a 500 pero su antigüedad es menor a 10 años, otorgarle un aumento de 5 %.
            NewSalary = Salary + (Salary * 0.05);

        } else if(Salary >= 500){ //sueldo es mayor o igual a 500 mostrar el sueldo en pantalla sin cambios.
            NewSalary = Salary;
        }

        tvNewSalary.setText("$ " + NewSalary);
    }

    public void BackToMain(View v){
        this.onBackPressed();
    }
}