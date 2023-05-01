package Project;

public class UlozeniPodleNazvu extends UlozeniFilmu {
    
    private String folderPath;
    
    public UlozeniPodleNazvu(String folderPath) {
        this.folderPath = folderPath;
    }
    
    @Override
    public String getFileName(String title) {
        return folderPath + "/" + title + ".txt";
    }
}
