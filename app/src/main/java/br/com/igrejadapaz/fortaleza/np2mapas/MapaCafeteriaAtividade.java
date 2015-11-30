package br.com.igrejadapaz.fortaleza.np2mapas;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapaCafeteriaAtividade extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private CafeteriaBean cafeteriaSelecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_cafeteria_atividade);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        cafeteriaSelecionada = getIntent().getExtras().getParcelable("cafeteriaSelecionada");

        TextView nome = (TextView) findViewById(R.id.textViewNome);
        nome.setText(cafeteriaSelecionada.getNome());
        TextView endereco = (TextView) findViewById(R.id.textViewEndereco);
        endereco.setText(cafeteriaSelecionada.getEndereco());
        TextView telefone = (TextView) findViewById(R.id.textViewTelefone);
        telefone.setText(cafeteriaSelecionada.getTelefone());
        TextView preco = (TextView) findViewById(R.id.textViewPreco);
        preco.setText(cafeteriaSelecionada.getPreco());

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.addMarker(new MarkerOptions().position(getLatLngFromAddress(cafeteriaSelecionada.getEndereco())).title(cafeteriaSelecionada.getNome()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(getLatLngFromAddress(cafeteriaSelecionada.getEndereco())));
    }

    public LatLng getLatLngFromAddress(String endereco) {
        Geocoder geocoder = new Geocoder(this);
        List<Address> listaEnderecos = null;
        Double latitude = null;
        Double longitude = null;
        try {
            listaEnderecos = geocoder.getFromLocationName(endereco, 3);
            if (listaEnderecos == null) {
                return null;
            }
            Address address = listaEnderecos.get(0);
            latitude = address.getLatitude();
            longitude = address.getLongitude();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new LatLng(latitude, longitude);
    }
}
