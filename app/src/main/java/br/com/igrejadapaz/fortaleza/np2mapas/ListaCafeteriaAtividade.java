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

public class ListaCafeteriaAtividade extends AppCompatActivity {

    private ListView listViewCafeteriaBean;
    private CafeteriaBean cafeteriaSelecionada;
    private List<CafeteriaBean> registrosCafeteriaBean = null;
    private ArrayAdapter<CafeteriaBean> adaptadorLista;
    private int adptadorLayout = android.R.layout.simple_list_item_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cafeteria_atividade);

        listViewCafeteriaBean = (ListView) findViewById(R.id.listView);
        registrosCafeteriaBean = listaCafeterias();
        adaptadorLista = new ArrayAdapter<CafeteriaBean>(this, adptadorLayout, registrosCafeteriaBean);
        listViewCafeteriaBean.setAdapter(adaptadorLista);
        registerForContextMenu(listViewCafeteriaBean);

        listViewCafeteriaBean.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cafeteriaSelecionada = (CafeteriaBean) adaptadorLista.getItem(position);
                Intent intent = new Intent(ListaCafeteriaAtividade.this, MapaCafeteriaAtividade.class);
                intent.putExtra("cafeteriaSelecionada", (Parcelable) cafeteriaSelecionada);
                startActivity(intent);
            }
        });

    }

    private List<CafeteriaBean> listaCafeterias() {
        ArrayList<CafeteriaBean> lista = new ArrayList<CafeteriaBean>();
        lista.add(new CafeteriaBean("Cafeteria Santa Clara", "R. José Avelino, 293 - Centro,Fortaleza - CE,60060-360", "(85) 3219-1257", "1,99"));
        lista.add(new CafeteriaBean("Villa Torri Cafeteria", "Rua Deputado João Pontes, 846 - Fatima,Fortaleza - CE,60040-430", "(85) 3017-1854", "2,99"));
        lista.add(new CafeteriaBean("Vinyle Café", "Rua Waldery Uchôa, 42 - Benfica,Fortaleza - CE,60040-531", "(85) 3055-3397", "3,99"));
        return lista;
    }
}
