package com.ambiciousteam.hotelsys.controller;

import javax.enterprise.inject.Model;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Model
public class BarChartBottomHomeBean {

    private BarChartModel model;

    public void preRender() {
        this.model = new BarChartModel();

        addSerie("Dias");
    }

    /**
     * @return the model
     */
    public BarChartModel getModel() {
        return model;
    }

    private void addSerie(String label) {
        ChartSeries series = new ChartSeries(label);

        series.set("1", Math.random() * 500);
        series.set("2", Math.random() * 500);
        series.set("3", Math.random() * 500);
        series.set("4", Math.random() * 500);
        series.set("5", Math.random() * 500);
        series.set("6", Math.random() * 500);
        series.set("7", Math.random() * 500);
        series.set("8", Math.random() * 500);
        series.set("9", Math.random() * 500);
        series.set("10", Math.random() * 500);
        series.set("11", Math.random() * 500);
        series.set("12", Math.random() * 500);
        series.set("13", Math.random() * 500);
        series.set("14", Math.random() * 500);
        series.set("15", Math.random() * 500);
        series.set("16", Math.random() * 500);
        series.set("17", Math.random() * 500);
        series.set("18", Math.random() * 500);
        series.set("19", Math.random() * 500);
        series.set("20", Math.random() * 500);
        series.set("21", Math.random() * 500);
        series.set("22", Math.random() * 500);
        series.set("23", Math.random() * 500);
        series.set("24", Math.random() * 500);
        series.set("25", Math.random() * 500);
        series.set("26", Math.random() * 500);
        series.set("27", Math.random() * 500);
        series.set("28", Math.random() * 500);
        series.set("29", Math.random() * 500);
        series.set("30", Math.random() * 500);

        this.model.addSeries(series);
    }

}
