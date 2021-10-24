package com.panwarjagdev.covidtracker;

public class Covid {
private String  dist, active, confirm,
        deceased, recovered ;

public Covid(String dist
,String active,String confirmed,String deceased
,String recovered){
    this.dist =dist
;
    this.active = active;
    this.confirm = confirmed;
    this.deceased = deceased;
    this.recovered = recovered;

}


    public void setDist(String dist) {this.dist = dist; }

    public void setActive(String active) {
        this.active = active;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public void setDeceased(String deceased) {
        this.deceased = deceased;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getDist() {
        return dist;
    }

    public String getActive() {
        return active;
    }

    public String getConfirm() {
        return confirm;
    }

    public String getDeceased() {
        return deceased;
    }

    public String getRecovered() {
        return recovered;
    }
}