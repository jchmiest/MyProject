package pl.sda.carmanager.web;

import java.math.BigDecimal;

public class SummaryEntry {
    private BigDecimal costSum;

    public BigDecimal getCostSum() {
        return costSum;
    }

    public void setCostSum(BigDecimal costSum) {
        this.costSum = costSum;
    }
    private Integer idSum;

    public Integer getIdSum() {
        return idSum;
    }

    public void setIdSum(Integer idSum) {
        this.idSum = idSum;
    }
    private BigDecimal averageConsumption; //spalanie

    public BigDecimal getAverageConsumption() {
        return averageConsumption;
    }

    public void setAverageConsumption(BigDecimal averageConsumption) {
        this.averageConsumption = averageConsumption;
    }

}
