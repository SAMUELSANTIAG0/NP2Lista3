package br.com.igrejadapaz.fortaleza.np2mapas;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.igrejadapaz.fortaleza.np2mapas.entidade.CafeteriasBean;

public class ListaCafeteriaAtividade extends AppCompatActivity {

    private ListView listViewCafeteriaBean;
    private CafeteriasBean cafeteriaSelecionada;
    private List<CafeteriasBean> registrosCafeteriaBean = null;
    private ArrayAdapter<CafeteriasBean> adaptadorLista;
    private int adptadorLayout = android.R.layout.simple_list_item_1;
    private boolean az = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cafeteria_atividade);
        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.hide();

        listViewCafeteriaBean = (ListView) findViewById(R.id.listView);
        registrosCafeteriaBean = listaCafeterias(az);
        adaptadorLista = new ArrayAdapter<CafeteriasBean>(this, adptadorLayout, registrosCafeteriaBean);
        listViewCafeteriaBean.setAdapter(adaptadorLista);
        registerForContextMenu(listViewCafeteriaBean);

        listViewCafeteriaBean.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cafeteriaSelecionada = (CafeteriasBean) adaptadorLista.getItem(position);


                Intent intent = new Intent(ListaCafeteriaAtividade.this, MapaCafeteriaAtividade.class);
                intent.putExtra("cs", (Parcelable) cafeteriaSelecionada);
                startActivity(intent);
            }
        });

    }

    public void az(View v){
        this.az = true;
        registrosCafeteriaBean = listaCafeterias(az);
        adaptadorLista.clear();
        adaptadorLista = new ArrayAdapter<CafeteriasBean>(this, adptadorLayout, registrosCafeteriaBean);
        adaptadorLista.notifyDataSetChanged();
        listViewCafeteriaBean.setAdapter(adaptadorLista);
    }

    public void za(View v){
        this.az = false;
        adaptadorLista.notifyDataSetChanged();
        registrosCafeteriaBean = listaCafeterias(az);
        adaptadorLista.clear();
        adaptadorLista = new ArrayAdapter<CafeteriasBean>(this, adptadorLayout, registrosCafeteriaBean);
        adaptadorLista.notifyDataSetChanged();
        listViewCafeteriaBean.setAdapter(adaptadorLista);
    }

    private List<CafeteriasBean> listaCafeterias(boolean az) {
        ArrayList<CafeteriasBean> lista = new ArrayList<CafeteriasBean>();

        if (az) {
            lista.add(new CafeteriasBean(1, "Cafeteria Santa Clara", "R. José Avelino, 293 - Centro", "(85) 3219-1257", "1,99"));
            lista.add(new CafeteriasBean(2, "Villa Torri Cafeteria", "Rua Deputado João Pontes, 846 - Fatima", "(85) 3017-1854", "2,99"));
            lista.add(new CafeteriasBean(3, "Vinyle Café", "Rua Waldery Uchôa, 42 - Benfica", "(85) 3055-3397", "3,99"));
        }else {
            lista.add(new CafeteriasBean(3, "Vinyle Café", "Rua Waldery Uchôa, 42 - Benfica", "(85) 3055-3397", "3,99"));
            lista.add(new CafeteriasBean(2, "Villa Torri Cafeteria", "Rua Deputado João Pontes, 846 - Fatima", "(85) 3017-1854", "2,99"));
            lista.add(new CafeteriasBean(1, "Cafeteria Santa Clara", "R. José Avelino, 293 - Centro", "(85) 3219-1257", "1,99"));
        }

        return lista;
    }
}
