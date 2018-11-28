package Lab4;

public class Produs {
    private String nume;
    private String cod_produs;
    private String pre_unitate;
    private String unit_masura;

    public Produs(String nume, String cod_produs, String pre_unitate, String unit_masura) {
        this.nume = nume;
        this.cod_produs = cod_produs;
        this.pre_unitate = pre_unitate;
        this.unit_masura = unit_masura;
    }

    public Produs() {
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCod_produs() {
        return cod_produs;
    }

    public void setCod_produs(String cod_produs) {
        this.cod_produs = cod_produs;
    }

    public String getPre_unitate() {
        return pre_unitate;
    }

    public void setPre_unitate(String pre_unitate) {
        this.pre_unitate = pre_unitate;
    }

    public String getUnit_masura() {
        return unit_masura;
    }

    public void setUnit_masura(String unit_masura) {
        this.unit_masura = unit_masura;
    }
}
