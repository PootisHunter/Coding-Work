import java.util.ArrayList;

public class InsInfoContainer {
    
    private ArrayList<InsuranceInfo> list = new ArrayList<>();
    private InsuranceInfo info;

    
    public InsInfoContainer(ArrayList<InsuranceInfo> list, InsuranceInfo info) {
        this.list = list;
        this.info = info;
    }
    public InsInfoContainer(){}

    public ArrayList<InsuranceInfo> getList(){
        return list;
    }

    public void setList(ArrayList<InsuranceInfo> list){
        this.list = list;
    }
    public InsuranceInfo getInfo() {
        return info;
    }
    public void setInfo(InsuranceInfo info) {
        this.info = info;
    }

    public void AddInfoToContainer(InsuranceInfo info){
        list.add(new InsuranceInfo(info.getTyyppi(),info.getSijainti(),info.getVakuutusarvo()));
    }
    public void PrintContainerInfo(){
        for (InsuranceInfo vakuutus : list){
            vakuutus.tulostaVakuutus();
        }
    }
    public void PrintContainerBelow(Double Raja){
        for (InsuranceInfo vakuutus : list){
            if (vakuutus.getVakuutusarvo() < Raja){
                vakuutus.tulostaVakuutus();
            }  
        }
    }
    public void PrintContainerAbove(Double Raja){
        for (InsuranceInfo vakuutus : list){
            if (vakuutus.getVakuutusarvo() > Raja){
                vakuutus.tulostaVakuutus();
            }  
        }
    }
    

}
