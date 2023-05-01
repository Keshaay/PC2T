package Project;

public class UlozeniPodleNazvu2 extends UlozeniFilmu2 {
    
    private String folderPath;
    
    public UlozeniPodleNazvu2(String folderPath) {
        this.folderPath = folderPath;
    }
    
    @Override
    public String getFileName2(String title) {
        return folderPath + "/" + title + ".txt";
    }
}
