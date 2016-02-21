package br.eti.kinoshita.minecraft.niwa_weather;

/**
 * Response summary from NIWAWeather.
 * 
 * @author Bruno P. Kinoshita
 * @since 0.1
 */
public final class NIWAWeatherResponse {

    private String date;
    private String phase;
    private double averageTemperature;
    private int maxTemp;
    private String maxTempTime;
    private int minTemp;
    private String minTempTime;
    private String windDesc;
    private double rainAmount;
    private double snowAmount;
    private String precipitation;
    private String rainStartTime;
    private String rainEndTime;
    private String cloud;
    private String label;

    public NIWAWeatherResponse() {
        super();
    }

    public NIWAWeatherResponse(String date, String phase, double averageTemperature, int maxTemp, String maxTempTime,
            int minTemp, String minTempTime, String windDesc, double rainAmount, double snowAmount,
            String precipitation, String rainStartTime, String rainEndTime, String cloud, String label) {
        super();
        this.date = date;
        this.phase = phase;
        this.averageTemperature = averageTemperature;
        this.maxTemp = maxTemp;
        this.maxTempTime = maxTempTime;
        this.minTemp = minTemp;
        this.minTempTime = minTempTime;
        this.windDesc = windDesc;
        this.rainAmount = rainAmount;
        this.snowAmount = snowAmount;
        this.precipitation = precipitation;
        this.rainStartTime = rainStartTime;
        this.rainEndTime = rainEndTime;
        this.cloud = cloud;
        this.label = label;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public double getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(double averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getMaxTempTime() {
        return maxTempTime;
    }

    public void setMaxTempTime(String maxTempTime) {
        this.maxTempTime = maxTempTime;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
    }

    public String getMinTempTime() {
        return minTempTime;
    }

    public void setMinTempTime(String minTempTime) {
        this.minTempTime = minTempTime;
    }

    public String getWindDesc() {
        return windDesc;
    }

    public void setWindDesc(String windDesc) {
        this.windDesc = windDesc;
    }

    public double getRainAmount() {
        return rainAmount;
    }

    public void setRainAmount(double rainAmount) {
        this.rainAmount = rainAmount;
    }

    public double getSnowAmount() {
        return snowAmount;
    }

    public void setSnowAmount(double snowAmount) {
        this.snowAmount = snowAmount;
    }

    public String getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(String precipitation) {
        this.precipitation = precipitation;
    }

    public String getRainStartTime() {
        return rainStartTime;
    }

    public void setRainStartTime(String rainStartTime) {
        this.rainStartTime = rainStartTime;
    }

    public String getRainEndTime() {
        return rainEndTime;
    }

    public void setRainEndTime(String rainEndTime) {
        this.rainEndTime = rainEndTime;
    }

    public String getCloud() {
        return cloud;
    }

    public void setCloud(String cloud) {
        this.cloud = cloud;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "NIWAWeatherResponse [date=" + date + ", phase=" + phase + ", averageTemperature=" + averageTemperature
                + ", maxTemp=" + maxTemp + ", maxTempTime=" + maxTempTime + ", minTemp=" + minTemp + ", minTempTime="
                + minTempTime + ", windDesc=" + windDesc + ", rainAmount=" + rainAmount + ", snowAmount=" + snowAmount
                + ", precipitation=" + precipitation + ", rainStartTime=" + rainStartTime + ", rainEndTime="
                + rainEndTime + ", cloud=" + cloud + ", label=" + label + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(averageTemperature);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((cloud == null) ? 0 : cloud.hashCode());
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((label == null) ? 0 : label.hashCode());
        result = prime * result + maxTemp;
        result = prime * result + ((maxTempTime == null) ? 0 : maxTempTime.hashCode());
        result = prime * result + minTemp;
        result = prime * result + ((minTempTime == null) ? 0 : minTempTime.hashCode());
        result = prime * result + ((phase == null) ? 0 : phase.hashCode());
        result = prime * result + ((precipitation == null) ? 0 : precipitation.hashCode());
        temp = Double.doubleToLongBits(rainAmount);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((rainEndTime == null) ? 0 : rainEndTime.hashCode());
        result = prime * result + ((rainStartTime == null) ? 0 : rainStartTime.hashCode());
        temp = Double.doubleToLongBits(snowAmount);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((windDesc == null) ? 0 : windDesc.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        NIWAWeatherResponse other = (NIWAWeatherResponse) obj;
        if (Double.doubleToLongBits(averageTemperature) != Double.doubleToLongBits(other.averageTemperature))
            return false;
        if (cloud == null) {
            if (other.cloud != null)
                return false;
        } else if (!cloud.equals(other.cloud))
            return false;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (label == null) {
            if (other.label != null)
                return false;
        } else if (!label.equals(other.label))
            return false;
        if (maxTemp != other.maxTemp)
            return false;
        if (maxTempTime == null) {
            if (other.maxTempTime != null)
                return false;
        } else if (!maxTempTime.equals(other.maxTempTime))
            return false;
        if (minTemp != other.minTemp)
            return false;
        if (minTempTime == null) {
            if (other.minTempTime != null)
                return false;
        } else if (!minTempTime.equals(other.minTempTime))
            return false;
        if (phase == null) {
            if (other.phase != null)
                return false;
        } else if (!phase.equals(other.phase))
            return false;
        if (precipitation == null) {
            if (other.precipitation != null)
                return false;
        } else if (!precipitation.equals(other.precipitation))
            return false;
        if (Double.doubleToLongBits(rainAmount) != Double.doubleToLongBits(other.rainAmount))
            return false;
        if (rainEndTime == null) {
            if (other.rainEndTime != null)
                return false;
        } else if (!rainEndTime.equals(other.rainEndTime))
            return false;
        if (rainStartTime == null) {
            if (other.rainStartTime != null)
                return false;
        } else if (!rainStartTime.equals(other.rainStartTime))
            return false;
        if (Double.doubleToLongBits(snowAmount) != Double.doubleToLongBits(other.snowAmount))
            return false;
        if (windDesc == null) {
            if (other.windDesc != null)
                return false;
        } else if (!windDesc.equals(other.windDesc))
            return false;
        return true;
    }

}
