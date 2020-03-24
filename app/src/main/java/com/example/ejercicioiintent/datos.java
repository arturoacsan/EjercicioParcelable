package com.example.ejercicioiintent;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class datos implements Parcelable {
    private String nombre;
    private String apellido;
    private String correo;
    private String color;
    private ArrayList<datos> amigos;

    public datos(String pNombre, String pApellido, String pCorreo, String pColor) {
        this.nombre = pNombre;
        this.apellido = pApellido;
        this.correo = pCorreo;
        this.color = pColor;
    }

    public datos() {
        this.nombre = "";
        this.apellido = "";
        this.correo = "";
        this.color = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    protected datos(Parcel in) {
        nombre = in.readString();
        apellido = in.readString();
        correo = in.readString();
        color = in.readString();
        if (in.readByte() == 0x01) {
            amigos = new ArrayList<datos>();
            in.readList(amigos, datos.class.getClassLoader());
        } else {
            amigos = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(apellido);
        dest.writeString(correo);
        dest.writeString(color);
        if (amigos == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(amigos);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<datos> CREATOR = new Parcelable.Creator<datos>() {
        @Override
        public datos createFromParcel(Parcel in) {
            return new datos(in);
        }

        @Override
        public datos[] newArray(int size) {
            return new datos[size];
        }
    };
}