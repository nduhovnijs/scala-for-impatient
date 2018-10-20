import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

class MyBean implements java.io.Serializable {
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    // Assume that task is not having to reimplement those methods
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }

    private int myValue;

    int getMyValue() {
        return myValue;
    }

    void setMyValue(int newValue) {
        int oldValue = myValue;
        myValue = newValue;
        this.pcs.firePropertyChange("myValue", oldValue, myValue);
    }

    public MyBean() {}
}

class MyPropertyChangeListener implements PropertyChangeListener {
    public void propertyChange(PropertyChangeEvent event) {
        String property = event.getPropertyName();
        Integer oldValue = (Integer) event.getOldValue();
        Integer newValue = (Integer) event.getNewValue();
        System.out.println("Following has been changed: " + property + " from " + oldValue + " to " + newValue);
    }
}

public class Ch10Ex05 {
    public static void main(String[] args) {
        MyBean bn = new MyBean();
        PropertyChangeListener myPropertyChangeListener = new MyPropertyChangeListener();
        bn.addPropertyChangeListener(myPropertyChangeListener);
        bn.setMyValue(5);
    }
}
