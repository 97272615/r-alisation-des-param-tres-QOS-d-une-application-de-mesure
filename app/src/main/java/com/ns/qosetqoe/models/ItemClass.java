package com.ns.qosetqoe.models;


import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import static com.ns.qosetqoe.utils.UtilsClass.parseDMS;


public class ItemClass implements Parcelable
{

    @SerializedName("N")
    @Expose
    private String n;
    @SerializedName("E")
    @Expose
    private String e;
    @SerializedName("Alt_m")
    @Expose
    private String altM;
    @SerializedName("H(m)")
    @Expose
    private String hM;
    @SerializedName("Adresse")
    @Expose
    private String adresse;
    @SerializedName("Delegation")
    @Expose
    private String delegation;
    @SerializedName("Opt")
    @Expose
    private String opt;
    @SerializedName("conf")
    @Expose
    private String conf;
    @SerializedName("ST")
    @Expose
    private String sT;
    @SerializedName("Fr\u00e9q")
    @Expose
    private String frQ;
    @SerializedName("ste")
    @Expose
    private String ste;
    @SerializedName("Nbr sect")
    @Expose
    private String nbrSect;
    @SerializedName("Obs")
    @Expose
    private String obs;
    @SerializedName("Debit Moyen Mbps")
    @Expose
    private String debitMoyenMbps;
    @SerializedName("Niveau de champs moyen voltm")
    @Expose
    private String niveauDeChampsMoyenVoltm;
    @SerializedName("Taux de blocage")
    @Expose
    private String tauxDeBlocage;
    @SerializedName("Taux de coupure")
    @Expose
    private String tauxDeCoupure;
    @SerializedName("Taux de HO")
    @Expose
    private String tauxDeHO;
    public final static Parcelable.Creator<ItemClass> CREATOR = new Creator<ItemClass>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ItemClass createFromParcel(Parcel in) {
            return new ItemClass(in);
        }

        public ItemClass[] newArray(int size) {
            return (new ItemClass[size]);
        }

    }
            ;

    protected ItemClass(Parcel in) {
        this.n = ((String) in.readValue((String.class.getClassLoader())));
        this.e = ((String) in.readValue((String.class.getClassLoader())));
        this.altM = ((String) in.readValue((String.class.getClassLoader())));
        this.hM = ((String) in.readValue((String.class.getClassLoader())));
        this.adresse = ((String) in.readValue((String.class.getClassLoader())));
        this.delegation = ((String) in.readValue((String.class.getClassLoader())));
        this.opt = ((String) in.readValue((String.class.getClassLoader())));
        this.conf = ((String) in.readValue((String.class.getClassLoader())));
        this.sT = ((String) in.readValue((String.class.getClassLoader())));
        this.frQ = ((String) in.readValue((String.class.getClassLoader())));
        this.ste = ((String) in.readValue((String.class.getClassLoader())));
        this.nbrSect = ((String) in.readValue((String.class.getClassLoader())));
        this.obs = ((String) in.readValue((String.class.getClassLoader())));
        this.debitMoyenMbps = ((String) in.readValue((String.class.getClassLoader())));
        this.niveauDeChampsMoyenVoltm = ((String) in.readValue((String.class.getClassLoader())));
        this.tauxDeBlocage = ((String) in.readValue((String.class.getClassLoader())));
        this.tauxDeCoupure = ((String) in.readValue((String.class.getClassLoader())));
        this.tauxDeHO = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public ItemClass() {
    }

    /**
     *
     * @param ste
     * @param tauxDeCoupure
     * @param e
     * @param adresse
     * @param n
     * @param niveauDeChampsMoyenVoltm
     * @param tauxDeBlocage
     * @param conf
     * @param tauxDeHO
     * @param obs
     * @param delegation
     * @param hM
     * @param debitMoyenMbps
     * @param frQ
     * @param sT
     * @param nbrSect
     * @param altM
     * @param opt
     */
    public ItemClass(String n, String e, String altM, String hM, String adresse, String delegation, String opt, String conf, String sT, String frQ, String ste, String nbrSect, String obs, String debitMoyenMbps, String niveauDeChampsMoyenVoltm, String tauxDeBlocage, String tauxDeCoupure, String tauxDeHO) {
        super();
        this.n = n;
        this.e = e;
        this.altM = altM;
        this.hM = hM;
        this.adresse = adresse;
        this.delegation = delegation;
        this.opt = opt;
        this.conf = conf;
        this.sT = sT;
        this.frQ = frQ;
        this.ste = ste;
        this.nbrSect = nbrSect;
        this.obs = obs;
        this.debitMoyenMbps = debitMoyenMbps;
        this.niveauDeChampsMoyenVoltm = niveauDeChampsMoyenVoltm;
        this.tauxDeBlocage = tauxDeBlocage;
        this.tauxDeCoupure = tauxDeCoupure;
        this.tauxDeHO = tauxDeHO;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

    public String getAltM() {
        return altM;
    }

    public void setAltM(String altM) {
        this.altM = altM;
    }

    public String getHM() {
        return hM;
    }

    public void setHM(String hM) {
        this.hM = hM;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDelegation() {
        return delegation;
    }

    public void setDelegation(String delegation) {
        this.delegation = delegation;
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }

    public String getConf() {
        return conf;
    }

    public void setConf(String conf) {
        this.conf = conf;
    }

    public String getST() {
        return sT;
    }

    public void setST(String sT) {
        this.sT = sT;
    }

    public String getFrQ() {
        return frQ;
    }

    public void setFrQ(String frQ) {
        this.frQ = frQ;
    }

    public String getSte() {
        return ste;
    }

    public void setSte(String ste) {
        this.ste = ste;
    }

    public String getNbrSect() {
        return nbrSect;
    }

    public void setNbrSect(String nbrSect) {
        this.nbrSect = nbrSect;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getDebitMoyenMbps() {
        return debitMoyenMbps;
    }

    public void setDebitMoyenMbps(String debitMoyenMbps) {
        this.debitMoyenMbps = debitMoyenMbps;
    }

    public String getNiveauDeChampsMoyenVoltm() {
        return niveauDeChampsMoyenVoltm;
    }

    public void setNiveauDeChampsMoyenVoltm(String niveauDeChampsMoyenVoltm) {
        this.niveauDeChampsMoyenVoltm = niveauDeChampsMoyenVoltm;
    }

    public String getTauxDeBlocage() {
        return tauxDeBlocage;
    }

    public void setTauxDeBlocage(String tauxDeBlocage) {
        this.tauxDeBlocage = tauxDeBlocage;
    }

    public String getTauxDeCoupure() {
        return tauxDeCoupure;
    }

    public void setTauxDeCoupure(String tauxDeCoupure) {
        this.tauxDeCoupure = tauxDeCoupure;
    }

    public String getTauxDeHO() {
        return tauxDeHO;
    }

    public void setTauxDeHO(String tauxDeHO) {
        this.tauxDeHO = tauxDeHO;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(n);
        dest.writeValue(e);
        dest.writeValue(altM);
        dest.writeValue(hM);
        dest.writeValue(adresse);
        dest.writeValue(delegation);
        dest.writeValue(opt);
        dest.writeValue(conf);
        dest.writeValue(sT);
        dest.writeValue(frQ);
        dest.writeValue(ste);
        dest.writeValue(nbrSect);
        dest.writeValue(obs);
        dest.writeValue(debitMoyenMbps);
        dest.writeValue(niveauDeChampsMoyenVoltm);
        dest.writeValue(tauxDeBlocage);
        dest.writeValue(tauxDeCoupure);
        dest.writeValue(tauxDeHO);
    }

    public int describeContents() {
        return 0;
    }

    public double getLatitude() {
        return parseDMS(getE());
    }

    public double getLongitude() {
        return parseDMS(getN());
    }

    public Location getLocation() {
        Location location = new Location(getAdresse());
        location.setAltitude(Double.parseDouble(getAltM()));
        location.setLatitude(getLatitude());
        location.setLongitude(getLongitude());
        return location;
    }

    // Returns the distance between two location in meters
    public float getDistanceToLocation(Location location) {
        return location.distanceTo(getLocation());
    }

}

