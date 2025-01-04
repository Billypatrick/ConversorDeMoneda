import com.google.gson.annotations.SerializedName;

public class Moneda {

    @SerializedName("base_code")
    private String monedaBase;
    @SerializedName("target_code")
    private String monedaFinal;
    @SerializedName("conversion_result")
    private double resultadoConversion;

    public Moneda(String monedaBase, String monedaFinal, double resultadoConversion) {
        this.monedaBase = monedaBase;
        this.monedaFinal = monedaFinal;
        this.resultadoConversion = resultadoConversion;
    }

    public Moneda(MonedaAPI miMonedaAPI) {
        this.monedaBase = miMonedaAPI.base_code();
        this.monedaFinal = miMonedaAPI.target_code();
        this.resultadoConversion = miMonedaAPI.conversion_result();
    }

    public String getMonedaBase() {
        return monedaBase;
    }

    public void setMonedaBase(String monedaBase) {
        this.monedaBase = monedaBase;
    }

    public String getMonedaFinal() {
        return monedaFinal;
    }

    public void setMonedaFinal(String monedaFinal) {
        this.monedaFinal = monedaFinal;
    }

    public double getResultadoConversion() {
        return resultadoConversion;
    }

    public void setResultadoConversion(double resultadoConversion) {
        this.resultadoConversion = resultadoConversion;
    }

    @Override
    public String toString() {
        return "Moneda{" +
                "monedaBase='" + monedaBase + '\'' +
                ", monedaFinal='" + monedaFinal + '\'' +
                ", resultadoConversion=" + resultadoConversion +
                '}';
    }
}
