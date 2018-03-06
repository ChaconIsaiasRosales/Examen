package net.unadeca.ana.emleados2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.raizlabs.android.dbflow.config.FlowManager;

public class datos extends AppCompatActivity {
    private EditText txtnombre;
    private  EditText txtapellidos;
    private EditText txtcedula;
    private EditText txtdepartamento;
    private EditText txtcodigo;
    private EditText txttelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datos);
        FlowManager.init(this);
        txtnombre = findViewById(R.id.txtNombre);
        txtapellidos = findViewById(R.id.txtAellidos);
        txtcedula = findViewById(R.id.txtCedula);
        txtdepartamento = findViewById(R.id.txtDepartamento);
        txtcodigo = findViewById(R.id.txtCod);
        txttelefono = findViewById(R.id.txtTelefono);
    }

    private boolean validación (){
        boolean send =true;
        if (txtnombre.getText().toString().isEmpty()){
            return send;
        }
        if (txtapellidos.getText().toString().isEmpty()){
            send = false;
        }
        if (txtcedula.getText().toString().isEmpty()){
            send = false;
        }
        if (txtdepartamento.getText().toString().isEmpty()){
            send = false;
        }
        if (txtcodigo.getText().toString().isEmpty()){
            send = false;
        }
        if (txttelefono.getText().toString().isEmpty()){
            send = false;
        }

        return  send;
    }

    private void guardar(){
        if (validación()){
            TodoTable registro = new TodoTable();
            registro.nombre = txtnombre.getText().toString();
            registro.apellidos = txtapellidos.getText().toString();
            registro.cedula = txtcedula.getText().toString();
            registro.departamento = txtdepartamento.getText().toString();
            registro.codigoempleado = txtcodigo.getText().toString();
            registro.telefono = txttelefono.getText().toString();
            registro.save();
            finish();
        }
        else{
            Toast.makeText(this,"Hay un Error.",Toast.LENGTH_LONG).show();
        }
    }

    public void clickguardar(View view) {
        guardar();
    }
}
