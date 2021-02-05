package sv.edu.udb.guia03app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Ejercicio 8
    /*
    Josué Alexander Villeda Chacón      VC170991
    Kevin Javier Castillo Hernández     CH170823
    Manuel Oswaldo Hernandez Lopez      HL180507
    Luis Armando Chévez Durán           CD161656
    */
    
    private EditText lado1;
    private EditText lado2;
    private EditText lado3;
    private TextView tvResultado;

    //Acumuladores
    private TextView tvEscalenos;
    private TextView tvIsosceles;
    private TextView tvEquilateros;

    private int contadorEscaleno = 0;
    private int contadorIsosceles = 0;
    private int contadorEquilatero = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lado1=(EditText)findViewById(R.id.lado1);
        lado2=(EditText)findViewById(R.id.lado2);
        lado3=(EditText) findViewById(R.id.lado3);
        tvResultado=(TextView) findViewById(R.id.tvResultado);

        //Acumuladores
        tvEscalenos=(TextView) findViewById(R.id.tvEscalenos);
        tvIsosceles=(TextView) findViewById(R.id.tvIsosceles);
        tvEquilateros=(TextView) findViewById(R.id.tvEquilateros);
    }

    public void Verificar(View view) {
        //Obtenemos los valores de cada input Number
        String valor1= lado1.getText().toString();
        String valor2= lado2.getText().toString();
        String valor3= lado3.getText().toString();

        int lado1 = Integer.parseInt(valor1);
        int lado2 = Integer.parseInt(valor2);
        int lado3 = Integer.parseInt(valor3);

        String resu = ""; //Variable para respuesta

        if ( lado1 == lado2 && lado2 == lado3) {
            resu = "Triángulo Equilatero";
            contadorEquilatero++;
        } else if( lado1 == lado2 || lado1==lado3  || lado2 == lado3){
            resu = "Triángulo Isósceles";
            contadorIsosceles++;
        } else {
            resu = "Triángulo Escaleno";
            contadorEscaleno++;
        }

        //Respuesta de tipo de triángulo
        tvResultado.setText(resu);

        String escalenos = String.valueOf(contadorEscaleno);
        String isosceles = String.valueOf(contadorIsosceles);
        String equilateros = String.valueOf(contadorEquilatero);

        //Mostramos los contadores
        tvEscalenos.setText(escalenos);
        tvIsosceles.setText(isosceles);
        tvEquilateros.setText(equilateros);



    }


}