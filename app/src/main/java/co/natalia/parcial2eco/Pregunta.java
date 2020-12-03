package co.natalia.parcial2eco;

public class Pregunta {

    private String id;
    private String DescrQuestion;
    private String estado;

    public Pregunta(String id, String descrQuestion, String estado) {
        this.id = id;
        DescrQuestion = descrQuestion;
        this.estado = estado;
    }

    public Pregunta() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescrQuestion() {
        return DescrQuestion;
    }

    public void setDescrQuestion(String descrQuestion) {
        DescrQuestion = descrQuestion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
