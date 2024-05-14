package it.federicomollica.dto;

public class PrecipitationSaveDto {
    private double value;
    private int forecastId;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getForecastId() {
        return forecastId;
    }

    public void setForecastId(int forecastId) {
        this.forecastId = forecastId;
    }
}
