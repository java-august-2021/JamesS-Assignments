
public class Project {
    private String name;
    private String description;


    public Project(){
        String emptyName = "N/A";
        String emptyDesciption = "N/A";
        name = emptyName;
        description = emptyDesciption;
    }

    public Project(String name){
        this.name = name;
        String emptyDescription = "N/A";
        description = emptyDescription;
    }

    public Project(String name, String description){
        this.name = name;
        this.description = description;
    }

    // Getters

    public String getProjName(){
        return name;
    }
    public String getProjDescription(){
        return description;
    }

    // Setters

    public void setProjName(String name){
        this.name = name;
    }
    public void setProjDescription(String description){
        this.description = description;
    }

    // Instance Method
    
    public String elevatorPitch(){
        return String.format("%s : %s", name, description);

    }
}
