package br.com.igrejadapaz.fortaleza.np2mapas;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Samuel Santiago on 29/11/2015.
 */
public class CafeteriaBean implements Parcelable {

    private int id;
    private String nome;
    private String endereco;
    private String telefone;
    private String preco;


    public CafeteriaBean(Parcel in) {
    }

    public CafeteriaBean(String nome, String endereco, String telefone, String preco) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.preco = preco;
    }


    @SuppressWarnings("rawtypes")
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public CafeteriaBean createFromParcel(Parcel in) {
            return new CafeteriaBean(in);
        }

        public CafeteriaBean[] newArray(int size) {
            return new CafeteriaBean[size];
        }
    };

    /**
     * Describe the kinds of special objects contained in this Parcelable's
     * marshalled representation.
     *
     * @return a bitmask indicating the set of special object types marshalled
     * by the Parcelable.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nome);
        dest.writeString(endereco);
        dest.writeString(telefone);
        dest.writeString(preco);

    }

    private void readFromParcelable(Parcel in) {
        id = in.readInt();
        nome = in.readString();
        endereco = in.readString();
        telefone = in.readString();
        preco = in.readString();
    }

    public String toString(){
        return nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

