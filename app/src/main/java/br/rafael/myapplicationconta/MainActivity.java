package br.rafael.myapplicationconta;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContaPessoaJuridica contaPessoaFisica = new ContaPessoaJuridica(1L
                , "BARAO"
                , 0.0
                , "123.258.258-78"
                , "Rafael");

        contaPessoaFisica.credito(100.0);
        Log.d("BANCOBARAO", contaPessoaFisica.getExtrato());
    }
}
