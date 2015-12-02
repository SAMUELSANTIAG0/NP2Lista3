package br.com.igrejadapaz.fortaleza.np2mapas.entidade;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Samuel Santiago on 01/12/2015.
 */
public class CafeteriasBean implements Parcelable {

    private int id;
    private String nome;
    private String endereco;
    private String telefone;
    private String preco;

    public CafeteriasBean(){
        // TODO
    }

    public CafeteriasBean(int id, String nome, String endereco, String telefone, String preco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.preco = preco;
    }

    public CafeteriasBean(String nome, String endereco, String telefone, String preco) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.preco = preco;
    }


    public CafeteriasBean(Parcel in) {
        readFromParcelable(in);
    }

    private void readFromParcelable(Parcel in) {
        id = in.readInt();
        nome = in.readString();
        endereco = in.readString();
        telefone = in.readString();
        preco = in.readString();
    }

    @SuppressWarnings("rawtypes")
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public CafeteriasBean createFromParcel(Parcel in) {
            return new CafeteriasBean(in);
        }

        public CafeteriasBean[] newArray(int size) {
            return new CafeteriasBean[size];
        }
    };

    public String toString(){
        return nome;
    }

    @Override
    public int describeContents() {
        //não vai usar
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nome);
        dest.writeString(endereco);
        dest.writeString(telefone);
        dest.writeString(preco);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public static Parcelable.Creator getCREATOR() {
        return CREATOR;
    }
}
