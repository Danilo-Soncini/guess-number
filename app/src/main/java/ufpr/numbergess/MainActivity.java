package ufpr.numbergess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber, tentativas;
    Random random;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        novoJogo();
        Button novoJogo = (Button)findViewById(R.id.novoJogo);
        novoJogo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                novoJogo ();
            }
        });
        Button advinhar = (Button)findViewById(R.id.adivinhar);
        advinhar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                advinhar();
            }
        });
    }


    public void advinhar (){
        EditText resposta = (EditText) findViewById(R.id.numero);

        if(resposta.length() == 0){
            Toast.makeText(this,"Preench alguma para advinhar", Toast.LENGTH_SHORT).show();
        }
        else{
            int number = Integer.parseInt(resposta.getText().toString());
            TextView dica = (TextView) findViewById(R.id.dica);
            tentativas++;
            if(number > randomNumber){
                dica.setText("O Número "+ number + " é maior que o escolhido");
            }
            else if (number < randomNumber){
                dica.setText("O Número " + number + " é menor que o escolhido");
            }
            else{
                dica.setText("Você acertou em " +  tentativas + " Tentativas");
            }
        }
    }


    public void novoJogo (){
        random = new Random();
        randomNumber = random.nextInt(100) +1 ;
        tentativas = 0;
        TextView dica = (TextView) findViewById(R.id.dica);
        EditText resposta = (EditText) findViewById(R.id.numero);
        dica.setText("");
        resposta.setText("");
    }




}
