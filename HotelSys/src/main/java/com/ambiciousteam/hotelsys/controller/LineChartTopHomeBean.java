package com.ambiciousteam.hotelsys.controller;

import javax.enterprise.inject.Model;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Model
public class LineChartTopHomeBean {

    private LineChartModel model;

    public void preRender() {
        this.model = new LineChartModel();

        addSerie("Meses");
    }

    /**
     * @return the model
     */
    public LineChartModel getModel() {
        return model;
    }

    private void addSerie(String label) {
        LineChartSeries series = new LineChartSeries(label);

        series.set("Jan", Math.random() * 500);
        series.set("Fev", Math.random() * 500);
        series.set("Mar", Math.random() * 500);
        series.set("Abr", Math.random() * 500);
        series.set("Mai", Math.random() * 500);
        series.set("Jun", Math.random() * 500);
        series.set("Jul", Math.random() * 500);
        series.set("Ago", Math.random() * 500);
        series.set("Set", Math.random() * 500);
        series.set("Out", Math.random() * 500);
        series.set("Nov", Math.random() * 500);
        series.set("Dez", Math.random() * 500);

        this.model.addSeries(series);
    }

}
