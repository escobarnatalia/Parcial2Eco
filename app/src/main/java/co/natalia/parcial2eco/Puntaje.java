package co.natalia.parcial2eco;

public class Puntaje {
    private String uid;
    private String id;
    private String DescrPuntaje;

    public Puntaje(String uid, String id, String descrPuntaje) {
        this.uid = uid;
        this.id = id;
        DescrPuntaje = descrPuntaje;
    }

    public Puntaje() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescrPuntaje() {
        return DescrPuntaje;
    }

    public void setDescrPuntaje(String descrPuntaje) {
        DescrPuntaje = descrPuntaje;
    }
}
