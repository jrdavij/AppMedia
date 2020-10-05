package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btmedia = findViewById(R.id.button);
        Button btcombustivel = findViewById(R.id.button2);


        btmedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.calculando_media);
                final Button btcalcular = findViewById(R.id.button3);
                final EditText et_p1 = findViewById(R.id.p1);
                final EditText et_projeto = findViewById(R.id.projeto);
                final EditText et_lista = findViewById(R.id.lista);

                btcalcular.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Double nota_p1 = et_p1.getText().toString().equals("") || Double.parseDouble(et_p1.getText().toString())<0 ? 0 : Double.parseDouble(et_p1.getText().toString()) * 0.3;
                        Double nota_projeto = et_projeto.getText().toString().equals("") || Double.parseDouble(et_projeto.getText().toString())<0 ? 0 : Double.parseDouble(et_projeto.getText().toString()) * 0.5;
                        Double nota_lista =  et_lista.getText().toString().equals("") || Double.parseDouble(et_lista.getText().toString())<0 ? 0 : Double.parseDouble(et_lista.getText().toString());

                        final TextView nota_final = findViewById(R.id.media);
                        final TextView situacao_final = findViewById(R.id.situacao);
                        nota_final.setText(String.valueOf(nota_p1 + nota_lista + nota_projeto));
                        situacao_final.setText((nota_p1 + nota_lista + nota_projeto)>6 ? "Aprovado" : "Reprovado !");
                    }
                });

            }
        });

        btcombustivel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.calculando_combustivel);

                final EditText gasolina = findViewById(R.id.textgas);
                final EditText etanol = findViewById(R.id.texteta);
                final Button calculareficiencia = findViewById(R.id.btcalcular);
                final TextView resultado_eficiencia = findViewById(R.id.txtresultado);

                calculareficiencia.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        double gasosa = gasolina.getText().toString().equals("") ? 0 : Double.parseDouble(gasolina.getText().toString()); //vazio?
                        double etan = etanol.getText().toString().equals("") ? 0 : Double.parseDouble(etanol.getText().toString()); // vazio?

                        if (gasosa * 0.7 > etan){
                            //etanol melhor
                            resultado_eficiencia.setText("O etanol vence");
                        }
                        else if (gasosa * 0.7 == etan){
                            //tanto faz
                            resultado_eficiencia.setText("Tanto faz");
                        }
                        else{
                            //gasolina melhor
                            resultado_eficiencia.setText("A gasolina vence");
                        }
                    }
                });

            }
        });

    }
}