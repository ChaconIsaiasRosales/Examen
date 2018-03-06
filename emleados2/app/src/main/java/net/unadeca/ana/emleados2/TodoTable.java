package net.unadeca.ana.emleados2;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by ANA on 05/02/2018.
 */

@Table(database = Tododatabase.class)
public class TodoTable extends BaseModel {

    // aqui declaramos nuestra tabla

    @PrimaryKey(autoincrement = true)
    public long id;

    @Column
    public String nombre;

    @Column
    public String apellidos;

    @Column
    public String cedula;

    @Column
    public String departamento;

    @Column
    public String codigoempleado;

    @Column
    public String telefono;


    @Column
    public int estado;
}
