package com.example.tp02_grupo9_android;

import android.os.Parcel;
import android.os.Parcelable;

public class ContactoClass implements Parcelable{

    private Integer Id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String direccion;
    private String fechaNacimiento;
    private String SpnTelefono;
    private String SpnEmail;

    //-----------------------------//

    private String radioEstudio;
    private Integer checkDeportes;
    private Integer checkMusica;
    private Integer checkArte;
    private Integer checkTecnologia;
    private Integer recibirInformacion;

    public ContactoClass() {
    }

    public ContactoClass(Integer id, String nombre, String apellido, String telefono, String email,
                    String direccion, String fechaNacimiento, String spnTelefono, String spnEmail,
                    String radioEstudio, Integer checkDeportes, Integer checkMusica, Integer checkArte,
                         Integer checkTecnologia, Integer recibirInformacion) {
        this.Id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.SpnTelefono = spnTelefono;
        this.SpnEmail = spnEmail;
        this.radioEstudio = radioEstudio;
        this.checkDeportes = checkDeportes;
        this.checkMusica = checkMusica;
        this.checkArte = checkArte;
        this.checkTecnologia = checkTecnologia;
        this.recibirInformacion = recibirInformacion;
    }



    // Métodos necesarios para Parcelable
    protected ContactoClass(Parcel in) {
        Id = in.readInt();
        nombre = in.readString();
        apellido = in.readString();
        telefono = in.readString();
        email = in.readString();
        direccion = in.readString();
        fechaNacimiento = in.readString();
        SpnTelefono = in.readString();
        SpnEmail = in.readString();
        radioEstudio = in.readString();
        checkDeportes = in.readInt();
        checkMusica = in.readInt();
        checkArte = in.readInt();
        checkTecnologia = in.readInt();
        recibirInformacion = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(Id);
        dest.writeString(nombre);
        dest.writeString(apellido);
        dest.writeString(telefono);
        dest.writeString(email);
        dest.writeString(direccion);
        dest.writeString(fechaNacimiento);
        dest.writeString(SpnTelefono.toString());
        dest.writeString(SpnEmail.toString());
        dest.writeString(radioEstudio);
        dest.writeInt(checkDeportes);
        dest.writeInt(checkMusica);
        dest.writeInt(checkArte);
        dest.writeInt(checkTecnologia);
        dest.writeInt(recibirInformacion);
    }

    public static final Creator<ContactoClass> CREATOR = new Creator<ContactoClass>() {
        @Override
        public ContactoClass createFromParcel(Parcel in) {
            return new ContactoClass(in);
        }

        @Override
        public ContactoClass[] newArray(int size) {
            return new ContactoClass[size];
        }
    };


    //-------------------------------------------------------------------------------//


    // Getters
    public Integer getId() {
        return Id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getSpnTelefono() {
        return SpnTelefono;
    }

    public String getSpnEmail() {
        return SpnEmail;
    }

    public String getRadioEstudio() {
        return radioEstudio;
    }

    public Integer getCheckDeportes() {
        return checkDeportes;
    }

    public Integer getCheckMusica() {
        return checkMusica;
    }

    public Integer getCheckArte() {
        return checkArte;
    }

    public Integer getCheckTecnologia() {
        return checkTecnologia;
    }

    public Integer getRecibirInformacion() {
        return recibirInformacion;
    }

    // Setters
    public void setId(Integer id) {
        this.Id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setSpnTelefono(String spnTelefono) {
        this.SpnTelefono = spnTelefono;
    }

    public void setSpnEmail(String spnEmail) {
        this.SpnEmail = spnEmail;
    }

    public void setRadioEstudio(String radioEstudio) {
        this.radioEstudio = radioEstudio;
    }

    public void setCheckDeportes(Integer checkDeportes) {
        this.checkDeportes = checkDeportes;
    }

    public void setCheckMusica(Integer checkMusica) {
        this.checkMusica = checkMusica;
    }

    public void setCheckArte(Integer checkArte) {
        this.checkArte = checkArte;
    }

    public void setCheckTecnologia(Integer checkTecnologia) {this.checkTecnologia = checkTecnologia;}

    public void setRecibirInformacion(Integer recibirInformacion) {this.recibirInformacion = recibirInformacion;}
}
