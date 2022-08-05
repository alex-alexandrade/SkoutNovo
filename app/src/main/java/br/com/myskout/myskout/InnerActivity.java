package br.com.myskout.myskout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InnerActivity extends AppCompatActivity {
    //Declarar as variáveis que irão receber o xml
    EditText edtUsuario, edtSenha;
    Button btnEntrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //abrir o meu layout
        setContentView(R.layout.inner_layout);
        //Apresentar as variaveis Java para as variaveis xml
        edtUsuario = findViewById(R.id.edtUsuario);
        edtSenha = findViewById(R.id.edtSenha);
        btnEntrar = findViewById(R.id.btnEntrar);

        //Criando a ação no botão entrar
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usuario, senha;

                usuario = edtUsuario.getText().toString();
                senha = edtSenha.getText().toString();

                //Validar a entrada do usuário

                if (usuario.equals("Senac") && senha.equals("Senac")) {
                    //Abrindo outra janela
                    //Duas formas de abrir uma janela
                    startActivity(new Intent(getApplicationContext(), MenuPrincipalActivity.class));
                    finish();

                } else {
                    //Enviando uma caixa com mensagem para o usuário
                    Toast.makeText(getApplicationContext(),
                            "Usuário ou senha inválidos",
                            Toast.LENGTH_SHORT).show();
                    //chamando o médodo limpar janela
                    limparJanela();
                }
            }
        });
    }

    //criando o método limpar janela
    public void limparJanela() {
        edtUsuario.setText("");
        edtSenha.setText("");
        edtUsuario.requestFocus();
    }

    //Vai sair do sistema
    public void sairSistema(View view) {
        finish();
    }

}