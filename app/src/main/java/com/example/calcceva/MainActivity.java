package com.example.calcceva;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText txtml1;
    private EditText txtml2;
    private EditText txtml3;
    private EditText txtpreco1;
    private EditText txtpreco2;
    private EditText txtpreco3;
    private WebView  webceva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtml1 =  findViewById(R.id.txtml1);
        txtml2 = findViewById(R.id.txtml2);
        txtml3 = findViewById(R.id.txtml3);
        txtpreco1 = findViewById(R.id.txtpreco1);
        txtpreco2 =  findViewById(R.id.txtpreco2);
        txtpreco3 = findViewById(R.id.txtpreco3);





    }

    public void calc(View view) {



        if (txtml1.getText().toString().isEmpty() || txtml2.getText().toString().isEmpty() || txtml3.getText().toString().isEmpty() || txtpreco1.getText().toString().isEmpty()
                || txtpreco2.getText().toString().isEmpty() || txtpreco3.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Digite os valores!", Toast.LENGTH_SHORT).show();
        } else {

            webceva =  findViewById(R.id.webceva);
            webceva.loadUrl("file:///android_asset/tenor.html");

            float ml1 = Float.valueOf(txtml1.getText().toString());
            float ml2 = Float.valueOf(txtml2.getText().toString());
            float ml3 = Float.valueOf(txtml3.getText().toString());

            float preco1 = Float.valueOf(txtpreco1.getText().toString());
            float preco2 = Float.valueOf(txtpreco2.getText().toString());
            float preco3 = Float.valueOf(txtpreco3.getText().toString());

            float valor1 = ml1 / preco1;
            float valor2 = ml2 / preco2;
            float valor3 = ml3 / preco3;

            if (Float.compare(valor1, valor2) > 0 && Float.compare(valor1, valor3) > 0 ) {
                Toast.makeText(MainActivity.this, "A primeira é a melhor ceva, vai na fé amigo.", Toast.LENGTH_SHORT).show();
            }
            else if (Float.compare(valor2, valor1) > 0 && Float.compare(valor2, valor3) > 0 ) {
                Toast.makeText(MainActivity.this, "A segunda é a melhor ceva, vai na fé amigo.", Toast.LENGTH_SHORT).show();
            }
            else if (Float.compare(valor3, valor1) > 0 && Float.compare(valor3, valor2) > 0 ) {
                Toast.makeText(MainActivity.this, "A terceira é a melhor ceva, vai na fé amigo.", Toast.LENGTH_SHORT).show();
            }
            else if (Float.compare(valor1, valor2) == 0 && Float.compare(valor1, valor3) == 0) {
                Toast.makeText(MainActivity.this, "Todas cervejas custam o mesmo valor, pega a que tu preferir.", Toast.LENGTH_SHORT).show();
            }
            else if (Float.compare(valor1, valor2) == 0 && Float.compare(valor1, valor3) < valor1) {
                Toast.makeText(MainActivity.this, "A primeira e a segunda cerveja tem o mesmo preço, vai na fé amigo.", Toast.LENGTH_SHORT).show();
            }
            else if (Float.compare(valor1, valor3) == 0 && Float.compare(valor1, valor2) < valor1) {
                Toast.makeText(MainActivity.this, "A primeira e a terceira cerveja tem o mesmo preço, vai na fé amigo.", Toast.LENGTH_SHORT).show();
            }
            else if (Float.compare(valor3, valor2) == 0 && Float.compare(valor3, valor1) < valor3) {
                Toast.makeText(MainActivity.this, "A segunda e a terceira cerveja tem o mesmo preço, vai na fé amigo.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}