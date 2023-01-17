public class Property{

    private String tyyppi;
    private String sijainti;
    
    public Property(String tyyppi, String sijainti) {
        this.setTyyppi(tyyppi);
        this.setSijainti(sijainti);
    }
    public Property(){}

    public String getTyyppi() {
        return tyyppi;
    }

    public void setTyyppi(String tyyppi) {
        this.tyyppi = tyyppi;
    }

    public String getSijainti() {
        return sijainti;
    }

    public void setSijainti(String sijainti) {
        this.sijainti = sijainti;
    }

}
