package mvc;

import java.io.Serializable;

public class Model extends Publisher implements Serializable {
    Boolean unsavedChanges = false;
    String fileName = null;
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName){
        this.fileName = fileName;
    }
    public Boolean getUnsavedChanges(){
        return unsavedChanges;
    }
    public void setUnsavedChanges(Boolean unsavedChanges){
        this.unsavedChanges = unsavedChanges;
    }
    public void changed(){
        setUnsavedChanges(true);
        notifySubscribers();
    }
}
