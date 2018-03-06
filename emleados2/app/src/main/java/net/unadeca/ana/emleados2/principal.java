package net.unadeca.ana.emleados2;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import org.sufficientlysecure.htmltextview.HtmlResImageGetter;

import java.util.List;

public class principal extends AppCompatActivity {
    private RecyclerView lista;
    private static Context QuickContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        QuickContext = this;
        FlowManager.init(this);
        lista = findViewById(R.id.lista);
        lista.setLayoutManager(new LinearLayoutManager(this));

        List<TodoTable> info = SQLite.select().from(TodoTable.class).queryList();
        lista.setAdapter(new ToDoAdapter(info));
    }
    public static class ToDoAdapter extends RecyclerView.Adapter<TodoViewHolder> {
        private final List<TodoTable> listToDoTable;
        private final LayoutInflater inflater;

        public ToDoAdapter(List<TodoTable> listToDoTables) {
            this.inflater = LayoutInflater.from(QuickContext);
            this.listToDoTable = listToDoTables;
        }

        @Override
        public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.objecto, parent, false);
            return new TodoViewHolder(view);
        }

        public void animateTo(List<TodoTable> models) {
            applyAndAnimateRemovals(models);
            applyAndAnimateAdditions(models);
            applyAndAnimateMovedItems(models);
        }

        private void applyAndAnimateRemovals(List<TodoTable> newModels) {
            for (int i = listToDoTable.size() - 1; i >= 0; i--) {
                final TodoTable model = listToDoTable.get(i);
                if (!newModels.contains(model)) {
                    removeItem(i);
                }
            }
        }

        private void applyAndAnimateAdditions(List<TodoTable> newModels) {
            for (int i = 0, count = newModels.size(); i < count; i++) {
                final TodoTable model = newModels.get(i);
                if (!listToDoTable.contains(model)) {
                    addItem(i, model);
                }
            }
        }

        private void applyAndAnimateMovedItems(List<TodoTable> newModels) {
            for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
                final TodoTable model = newModels.get(toPosition);
                final int fromPosition = listToDoTable.indexOf(model);
                if (fromPosition >= 0 && fromPosition != toPosition) {
                    moveItem(fromPosition, toPosition);
                }
            }
        }

        public TodoTable removeItem(int position) {
            final TodoTable model = listToDoTable.remove(position);
            notifyItemRemoved(position);
            return model;
        }

        public void addItem(int position, TodoTable model) {
            listToDoTable.add(position, model);
            notifyItemInserted(position);
        }

        public void moveItem(int fromPosition, int toPosition) {
            final TodoTable model = listToDoTable.remove(fromPosition);
            listToDoTable.add(toPosition, model);
            notifyItemMoved(fromPosition, toPosition);
        }

        @Override
        public void onBindViewHolder(final TodoViewHolder holder, final int position) {
            TodoTable current = listToDoTable.get(position);
            holder.html.setHtml(ActividadAString(current),
                    new HtmlResImageGetter(holder.html));


        }
        private String ActividadAString(TodoTable todo){
            String html = "<a><b>" +"Nombre: " + todo.nombre+"<b>";
            html+= "<br>" +"Apellido: " +todo.apellidos+"</a>";
            html+= "<br>" +"Cedula: " +todo.cedula+"</a>";
            html+= "<br>" +"Departamento: "+todo.departamento+"</a>";
            html+= "<br>" +"Codigo Empleado: "+todo.codigoempleado+"</a>";
            html+= "<br>" +"Número Teléfono: "+todo.telefono+"</a>";
            return html;
        }


        @Override
        public int getItemCount() {
            return listToDoTable.size();
        }




    }
    public void clickanadir(View view) {
        Intent inte = new Intent(principal.this,datos.class);
        startActivity(inte);

    }
}
