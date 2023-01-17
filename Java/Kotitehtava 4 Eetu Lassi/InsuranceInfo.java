public class InsuranceInfo {
    
    private Property property;
    private Double vakuutusarvo;

    
    public InsuranceInfo(String tyyppi, String sijainti, Double vakuutusarvo) {
        this.property = new Property(tyyppi, sijainti);
        this.vakuutusarvo = vakuutusarvo;
    }
    public InsuranceInfo(){
        this.property = new Property();
    }

    public Property getProperty() {
        return property;
    }
    public void setProperty(Property property) {
        this.property = property;
    }
    public Double getVakuutusarvo() {
        return vakuutusarvo;
    }
    public void setVakuutusarvo(Double vakuutusarvo) {
        if (vakuutusarvo < 0){
            System.out.println("Anna sopiva arvo vakuutusarvoille");
            System.exit(0);
        }
        else{
            this.vakuutusarvo = vakuutusarvo;
        }
        
    }

    public String getTyyppi() {
        return property.getTyyppi();
    }

    public void setTyyppi(String tyyppi) {
        property.setTyyppi(tyyppi);
    }

    public String getSijainti() {
        return property.getSijainti();
    }

    public void setSijainti(String sijainti) {
        property.setSijainti(sijainti);
    }
    public void tulostaVakuutus(){
        System.out.println(property.getTyyppi());
        System.out.println(property.getSijainti());
        System.out.println(vakuutusarvo);
    }
}
